package controleur;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modele.Astuce;
import modele.CategorieAstuce;
import modele.CategorieObjet;
import modele.Chat;
import modele.CompteInscrit;
import modele.Objet;
import modele.Vote;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AstuceControleur {

	/**
	 * Retourne la liste des astuces
	 * 
	 * @param httpSession
	 *            donne les info de l'utilisateur connect�
	 *
	 */
	@RequestMapping("/astuces")
	public ModelAndView listeAstuce(HttpSession httpSession) {
		
		//creation modelmal
		ModelAndView modelAndView = new ModelAndView("AstuceListe");
		
		//ouverture de session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// recherchar par critera, les astuces "publiees"
		Criteria criteria = session.createCriteria(Astuce.class);
		criteria.add(Restrictions.eq("publie", true));
		
		//fais la liste
		List<Astuce> astuces = (List<Astuce>) criteria.list();
		session.close();
		
		// ajout des infos
		modelAndView.addObject("ListeAstuce", astuces);
		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
		return modelAndView;

	}


	/**Retourne la page d'accueil
	 * @param httpSession donne les info de l'utilisateur connect�
	 * */
	@RequestMapping("/index")
	public ModelAndView listeAstuceRecent(HttpSession httpSession){
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		//ouverture de session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		//r�cup�ration de la date courante
		Date dateAuj = new Date();
		int nbDays = -7 ;
		
		 Calendar cal = new GregorianCalendar();
	     cal.setTime(dateAuj);
	     cal.add(Calendar.DATE, nbDays);
	     	          
	     // date daujour'hui en SQL
	     java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime() );
	     
	     // date d'il y a une Sem en SQL
	     java.sql.Date dateSem = new java.sql.Date(cal.getTime().getTime());
	     
		//criteria qui r�cup�re les astuces datant que d'il y a une semaine	
		Criteria criteria = session.createCriteria(Astuce.class);
		criteria.add(Restrictions.ge("date",dateSem));
		criteria.add(Restrictions.le("date", date));
		criteria.add(Restrictions.eq("publie", true));
		
		// r�sultats
		List<Astuce> astuces = (List<Astuce>) criteria.list();
		session.close();
		
		// ajout des infos
		modelAndView.addObject("ListeAstuce", astuces);
		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
		
	
		return modelAndView;
		
	}

	/**
	 * Retourne le d�tail d'une astuce
	 * 
	 * @idAstuce r�cup�re l'id contenu dans l'URL
	 * @param httpSession
	 *            donne les info de l'utilisateur connect�
	 */
	@RequestMapping("/astuce/{idAstuce}")
	public ModelAndView detailAstuce(@PathVariable("idAstuce") int idAstuce, HttpSession httpSession) {
		// creation modele
		ModelAndView modelAndView = new ModelAndView("Astuce");
		
		Astuce astuce = new Astuce();
		String info = "";
		String cas = "";
		
		// ouverture de dession
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		astuce = session.get(Astuce.class, idAstuce);
		CompteInscrit compteRetour;
		Vote vote;

		// criteria cherchant pour les votes
		Criteria crit = session.createCriteria(Vote.class);
		Criterion price = Restrictions.eq("astuce", astuce);
		Criterion name = Restrictions.ne("valeur", "1");
		LogicalExpression orExp = Restrictions.and(price, name);
		crit.add(orExp);
		List<Vote> toutvotes = (List<Vote>) crit.list();
		
		// float car sinon la division ne fonctionne pas
		int nbVoteTotal = toutvotes.size();
		crit = session.createCriteria(Vote.class);
		price = Restrictions.eq("astuce", astuce);
		name = Restrictions.like("valeur", "3");
		orExp = Restrictions.and(price, name);
		crit.add(orExp);
		List<Vote> lesDislikes = (List<Vote>) crit.list();
		float nbDislike = lesDislikes.size();

		crit = session.createCriteria(Vote.class);
		price = Restrictions.eq("astuce", astuce);
		name = Restrictions.like("valeur", "2");
		orExp = Restrictions.and(price, name);
		crit.add(orExp);
		List<Vote> leslikes = (List<Vote>) crit.list();

		float nblike = leslikes.size();

		// calcule le pourcentage et envoie toutes les infos � la page
		List<Float> listVal = calculerPourcentage(nbVoteTotal, nblike, nbDislike);
		modelAndView.addObject("votesTotal", (int) nbVoteTotal);
		modelAndView.addObject("votesPour", (int) nblike);
		modelAndView.addObject("votesContre", (int) nbDislike);
		modelAndView.addObject("pourCentLike", listVal.get(0));
		modelAndView.addObject("pourCentDislike", listVal.get(1));
		
		
		

		// va d�terminer si la personne peut voter ou non.
		String email = (String) httpSession.getAttribute("emailUser");
		
		
		// trouver compte par email
		Query query = session.getNamedQuery("findCompteByEmail").setString("email", email);
		compteRetour = (CompteInscrit) query.uniqueResult();
		
		// SI vide, non connect�
		if (email == null) {
			info = "Vous devez être connecter pour liker une astuce";
			cas = "0";
			modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
			modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
			modelAndView.addObject("Astuce", astuce);
			modelAndView.addObject("Info", info);
			modelAndView.addObject("cas", cas);
			return modelAndView;
		} else {

			// sinon, il peut voter tout �a.
			Criteria criteria = session.createCriteria(Vote.class);
			criteria.add(Restrictions.eq("astuce", astuce)).add(Restrictions.eq("compte", compteRetour));
			List<Vote> votes = (List<Vote>) criteria.list();
			
			// si pas de votes et taille vote =0, il n' apas vot�
			if (votes == null || votes.size() == 0) {
				info = "Vous n'avez pas encore vot� pour cette astuce";
				cas = "1";
				modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
				modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
				modelAndView.addObject("Astuce", astuce);
				modelAndView.addObject("Info", info);
				modelAndView.addObject("cas", cas);
				return modelAndView;
			}
			vote = votes.get(0);
			
			// si le vote egal � 1, il n' apas vot� (???)
			
			modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
			modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
			modelAndView.addObject("Astuce", astuce);
			
			
			if (vote.getValeur().equals("1")) {
				info = "Vous n'avez pas encore voté pour cette astuce";
				cas = vote.getValeur();
				modelAndView.addObject("Info", info);
				modelAndView.addObject("cas", cas);
				return modelAndView;
			}
			
			// si le vote =2, il a like
			if (vote.getValeur().equals("2")) {
				info = "Vous avez liké cette astuce";
				cas = vote.getValeur();
				modelAndView.addObject("Info", info);
				modelAndView.addObject("cas", cas);
				return modelAndView;
			}
			
			// si le vote =3 , il a dislike
			if (vote.getValeur().equals("3"))
				info = "Vous avez disliké cette astuce";
			cas = vote.getValeur();
			modelAndView.addObject("Info", info);
			modelAndView.addObject("cas", cas);
			return modelAndView;
		}

	}

	/**
	 * Calcule le pourcentage que repr�sentent les votes
	 * 
	 * @param nbTotal
	 *            Nombre total des votes
	 * @param like
	 *            Nombre des likes
	 * @param dislike
	 *            Nombre des dislikes
	 */
	public List<Float> calculerPourcentage(int nbTotal, float like, float dislike) {
		
		// calcul du pourcentage
		List<Float> vals = new ArrayList<Float>();
		float pourLike;
		float pourDislike;
		if (nbTotal == 0) {
			pourLike = 0;
			pourDislike = 0;
		} else {
			pourLike = (like / nbTotal) * 100;
			pourDislike = (dislike / nbTotal) * 100;

		}

		vals.add(pourLike);
		vals.add(pourDislike);
		return vals;

	}

	/**
	 * Donne toutes les astuces pour un chat donn�
	 * 
	 * @param httpSession
	 *            donne les info de l'utilisateur connect�
	 * @request Requ�te Http
	 */
	@RequestMapping("/chat/RechAstucesChat")
	public ModelAndView RechAstucesChat(HttpSession httpSession, HttpServletRequest request) {

		// r�cup�re le nom du chat � chercher
		String nomChat = request.getParameter("RechAstucesChat");
		// indique la page � retourner

		// ouverture de session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// trouver le chat
		Query query = session.getNamedQuery("findCatbyName").setString("nom", nomChat);
		Chat chat = (Chat) query.uniqueResult();

		if (chat != null) {
			// Si le chat existe, on va chercher la m�thode qui va chercher
			// pour nous
			
			ModelAndView modelAndView = new ModelAndView("AstucesChat");
			modelAndView = AstucesAssocieesAuChatNORMAL(chat.getIdChat(), httpSession);
			session.close();
			return modelAndView;
		} else {
			ModelAndView modelAndView = listeAstuce(httpSession);
			modelAndView.addObject("error", "Il n'y a pas d'astuces associ�es � ce chat");
			return modelAndView;
		}

	}

	/**Donne les astuces associ�es � un chat sans passer par un param dans l'URL {idChat}
	 * @param idChat L'id du chat � qui chercher les astuces
	 * @param httpSession donne les info de l'utilisateur connect� 
	 * */
	public ModelAndView AstucesAssocieesAuChatNORMAL(int idChat, HttpSession httpSession) {

		ModelAndView modelAndView = new ModelAndView("AstucesChat");
		// Cr�e le chat en question
		Chat chat = new Chat();
		
		//ouverture de session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		chat = session.get(Chat.class, idChat);

		// criteria, recherche les astuces publiees
		Criteria criteria = session.createCriteria(Astuce.class);
		criteria.add(Restrictions.eq("chat", chat)).add(Restrictions.eq("publie", true));
		List<Astuce> astuces = (List<Astuce>) criteria.list();
		
		session.close();
		
		// ajoute les infos
		modelAndView.addObject("listeAstuces", astuces);
		modelAndView.addObject("Chat", chat);
		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
		return modelAndView;

	}

	/**Donne les astuces associ�es � un chat en passant par une variable PATH
	 * @param idChat Id du chat dont on cherche les astuces
	 * @param httpSession donne les info de l'utilisateur connect�
	 * */
	@RequestMapping(value = "/chat/{idChat}/astuces", method = RequestMethod.GET)
	public ModelAndView AstucesAssocieesAuChat(@PathVariable("idChat") int idChat, HttpSession httpSession) {

		ModelAndView modelAndView = new ModelAndView("AstucesChat");
		// Cr�e le chat en question
		Chat chat = new Chat();
		
		// ouverture de dession
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		chat = session.get(Chat.class, idChat);

		// criteria cherche les astuces publiees
		Criteria criteria = session.createCriteria(Astuce.class);
		criteria.add(Restrictions.eq("chat", chat)).add(Restrictions.eq("publie", true));
		List<Astuce> astuces = (List<Astuce>) criteria.list();
		
		// les ajoute
		
		session.close();
		
		// ajoute les infos
		modelAndView.addObject("listeAstuces", astuces);
		modelAndView.addObject("Chat", chat);
		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
		return modelAndView;

	}

    /** Affiche la page du formulaire d'ajout d'astuces
     * @param idChat Id du chat dont on veut rajouter une astuce
     * @param httpSession donne les info de l'utilisateur connect�
     * */
	@RequestMapping(value = "/chat/{idChat}/astuce", method = RequestMethod.GET)
	public ModelAndView AfficheAjoutAstuce(@PathVariable("idChat") int idChat, HttpSession httpSession) {
		
		// on peut acc�der que si connect�
		if (httpSession.getAttribute("emailUser") == null) {
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info", "Vous devez �tre connect� pour ajouter une astuce.");
			return model1;
		}
		ModelAndView modelAndView = new ModelAndView("AjoutAstuceForm");
		Chat chat = new Chat();
		
		// ouverture de dession
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		chat = session.get(Chat.class, idChat);
		
		//r�cup�re les objets pour les afficher, et yen a un tas.
		Criteria criteriaCategorieObjet = session.createCriteria(CategorieObjet.class);
		List<CategorieObjet> categorieObjets = (List<CategorieObjet>) criteriaCategorieObjet.list();

		Criteria criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(0)));
		List<Objet> balls = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(1)));
		List<Objet> boxs = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(2)));
		List<Objet> beds = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(3)));
		List<Objet> furniture = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(4)));
		List<Objet> tunnels = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(5)));
		List<Objet> toys = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(6)));
		List<Objet> heating = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(7)));
		List<Objet> bagsHiding = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(8)));
		List<Objet> scratching = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(9)));
		List<Objet> baskets = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(10)));
		List<Objet> foods = (List<Objet>) criteria.list();

		criteria = session.createCriteria(CategorieAstuce.class);
		List<CategorieAstuce> categorieAstuces = (List<CategorieAstuce>) criteria.list();

		session.close();
		
// ajout des infos
		modelAndView.addObject("balls", balls);
		modelAndView.addObject("boxes", boxs);
		modelAndView.addObject("beds", beds);
		modelAndView.addObject("furniture", furniture);
		modelAndView.addObject("tunnels", tunnels);
		modelAndView.addObject("toys", toys);
		modelAndView.addObject("heating", heating);
		modelAndView.addObject("bagsHiding", bagsHiding);
		modelAndView.addObject("scratching", scratching);
		modelAndView.addObject("baskets", baskets);
		modelAndView.addObject("foods", foods);
		modelAndView.addObject("chat", chat);
		modelAndView.addObject("categorieAstuces", categorieAstuces);
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));

		return modelAndView;

	}

	/** R�cup�re les infos du form et ajoute une astuce
	 * @param idChat IdChat auquel on rajoute une astuce
	 * @param httpSession donne les info de l'utilisateur connect�
	 * @throws ParseException 
	 * */
	@RequestMapping(value = "/chat/{idChat}/astuce", method = RequestMethod.POST)
	public ModelAndView AjoutAstuce(@ModelAttribute("astuce") Astuce astuce, BindingResult result,
			@PathVariable("idChat") int idChat, HttpSession httpSession) throws ParseException {
		

		// Teste si il y � des erreus
		if (result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("AjoutAstuceForm");
			model1.addObject("error", "Probl�me dans le formulaire, veuillez contacter un Admin");
			return model1;
		}
		if (astuce.getTitre().equals("") || astuce.getAstuce().equals("")  || astuce.getTitre().length()>253 || astuce.getAstuce().length()>253) {
			ModelAndView model1 = new ModelAndView("Redirection");
			model1.addObject("error", "Erreur : Le corps, le titre de l'astuce est vide ou trop grand (255 caractères MAXIMUM) !!");
			model1.addObject("url", "/NekoAtsume/chat/" + idChat + "/astuce");
			return model1;
		}

		// Associe la vue AjoutSucces avec m�thode

		Objet objet;
		Chat chat;
//		
//		CategorieAstuce categorieAstuce = astuce.getCategorie();
//		
		CompteInscrit compte;
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Liste d'objet a r�cuperer � partir des identifiants transmit par
		// le formulaire
		List<Objet> objets = new ArrayList<Objet>();
		for (int i = 0; i < astuce.getListObjetId().size(); i++) {
			objet = session.get(Objet.class, astuce.getListObjetId().get(i));
			objets.add(objet);
		}

		// On r�cup�re le chat associ�
		chat = session.get(Chat.class, idChat);
		Query query = session.getNamedQuery("findCompteByEmail").setString("email",
				(String) httpSession.getAttribute("emailUser"));
		
		

		String emailUser = (String) httpSession.getAttribute("emailUser");
		compte = (CompteInscrit) query.uniqueResult();
		// Et on bind les infos � l'astuce
		astuce.setListObjet(objets);
		astuce.setAuteur(compte);
		astuce.setChat(chat);
		CategorieAstuce categorieAstuce;
		Criteria criteriaCategorieAstuce = session.createCriteria(CategorieAstuce.class);
		criteriaCategorieAstuce.add(Restrictions.eq("nomCategorieAstuce", "Collection chat"));
		categorieAstuce = (CategorieAstuce) criteriaCategorieAstuce.uniqueResult();
		
		astuce.setCategorie(categorieAstuce);
		
		
			
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          astuce.setDate((java.sql.Date) date);
		
		session.save(astuce);
		session.getTransaction().commit();
		session.close();
		ModelAndView modelAndView = listeAstuce(httpSession);
		modelAndView.addObject("email", compte);
		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("succes",
				"Votre astuce a �t� envoy�e aux mod�rateurs afin qu'ils puissent la valider !");
		return modelAndView;

	}

	/**Affiches les Astuces sur le panneau Administrateur
	 * @param httpSession donne les info de l'utilisateur connect�
	 * */
	@RequestMapping("/AdminAstuces")
	public ModelAndView affichePanneauAdminAstuces(HttpSession httpSession) {
		
		//accessible qu'admin
		if (httpSession.getAttribute("Admin") == null) {
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info", "Vous devez etre connecte en tant qu'admin !");
			return model1;
		}
		
		//ouverture de dession
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//criteria qui r�cup�re toutes les astuces
		Criteria criteria = session.createCriteria(Astuce.class);
		List<Astuce> astuces = (List<Astuce>) criteria.list();
		session.close();
		
		// ajout des infos
		ModelAndView modelAndView = new ModelAndView("AdminAstuces");
		modelAndView.addObject("listAstuce", astuces);
		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));

		return modelAndView;
	}

	/** Permet � l'admin de modifier une astuce
	 * @param idAstuce id de l'Astuce concern�e par la modification
	 * @param httpSession donne les info de l'utilisateur connect�
	 * */
	@RequestMapping("/astuce/{idAstuce}/moderer")
	public ModelAndView AdminModererAstuce(@PathVariable("idAstuce") int idAstuce, HttpSession httpSession) {
		
		//accessible qu'en �tant admin
		if (httpSession.getAttribute("Admin") == null) {
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info", "Vous devez etre connecte en tant qu'admin !");
			return model1;
		}
		
		//creemodele and view
		ModelAndView modelAndView = new ModelAndView("AdminAstucesModeration");
		Astuce astuce = new Astuce();
		
		// ouverture de dession
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		astuce = session.get(Astuce.class, idAstuce);

		// criteria qui r�cup la cat�gorie des objets
		Criteria criteriaCategorieObjet = session.createCriteria(CategorieObjet.class);
		List<CategorieObjet> categorieObjets = (List<CategorieObjet>) criteriaCategorieObjet.list();

		Criteria criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(0)));
		List<Objet> balls = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(1)));
		List<Objet> boxs = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(2)));
		List<Objet> beds = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(3)));
		List<Objet> furniture = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(4)));
		List<Objet> tunnels = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(5)));
		List<Objet> toys = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(6)));
		List<Objet> heating = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(7)));
		List<Objet> bagsHiding = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(8)));
		List<Objet> scratching = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(9)));
		List<Objet> baskets = (List<Objet>) criteria.list();

		criteria = session.createCriteria(Objet.class);
		criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(10)));
		List<Objet> foods = (List<Objet>) criteria.list();

		criteria = session.createCriteria(CategorieAstuce.class);

		List<CategorieAstuce> listCategorieAstuces = (List<CategorieAstuce>) criteria.list();
		List<Objet> objetAstuces;
		objetAstuces = astuce.getListObjet();
		
		// va mettre si selectionn� ou pas.

		for (int i = 0; i < balls.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(balls.get(i).getNomObjet())) {
					balls.get(i).setIsChecked("T");
				}
			}
		}

		for (int i = 0; i < beds.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(beds.get(i).getNomObjet())) {
					beds.get(i).setIsChecked("T");
				}
			}
		}
		for (int i = 0; i < boxs.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(boxs.get(i).getNomObjet())) {
					boxs.get(i).setIsChecked("T");
				}
			}
		}
		for (int i = 0; i < furniture.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(furniture.get(i).getNomObjet())) {
					furniture.get(i).setIsChecked("T");
				}
			}
		}
		for (int i = 0; i < tunnels.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(tunnels.get(i).getNomObjet())) {
					tunnels.get(i).setIsChecked("T");
				}
			}
		}
		for (int i = 0; i < toys.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(toys.get(i).getNomObjet())) {
					toys.get(i).setIsChecked("T");
				}
			}
		}
		for (int i = 0; i < heating.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(heating.get(i).getNomObjet())) {
					heating.get(i).setIsChecked("T");
				}
			}
		}
		for (int i = 0; i < bagsHiding.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(bagsHiding.get(i).getNomObjet())) {
					bagsHiding.get(i).setIsChecked("T");
				}
			}
		}
		for (int i = 0; i < scratching.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(scratching.get(i).getNomObjet())) {
					scratching.get(i).setIsChecked("T");
				}
			}
		}

		for (int i = 0; i < baskets.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(baskets.get(i).getNomObjet())) {
					baskets.get(i).setIsChecked("T");
				}
			}
		}
		for (int i = 0; i < foods.size(); i++) {
			for (int j = 0; j < objetAstuces.size(); j++) {
				if (objetAstuces.get(j).getNomObjet().equals(foods.get(i).getNomObjet())) {
					foods.get(i).setIsChecked("T");
				}
			}
		}
		
		// ajout des infos
		session.close();
		modelAndView.addObject("balls", balls);
		modelAndView.addObject("boxes", boxs);
		modelAndView.addObject("beds", beds);
		modelAndView.addObject("furniture", furniture);
		modelAndView.addObject("tunnels", tunnels);
		modelAndView.addObject("toys", toys);
		modelAndView.addObject("heating", heating);
		modelAndView.addObject("bagsHiding", bagsHiding);
		modelAndView.addObject("scratching", scratching);
		modelAndView.addObject("baskets", baskets);
		modelAndView.addObject("foods", foods);
		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));

		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
		modelAndView.addObject("Astuce", astuce);
		return modelAndView;

	}

	/**Permet de valider les changements du chat par l'admin
	 * @param astuce est l'astuce modifi�e
	 * @param httpSession donne les info de l'utilisateur connect�
	 * */
	@RequestMapping(value="/modifierAstuce", method = RequestMethod.POST)
	public ModelAndView modificationAstuce(@ModelAttribute("astuce") Astuce astuce,BindingResult result, HttpSession httpSession) {
		
		
		if (result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("AdminAstucesModeration");
			return model1;
		}
		//accessible que si admin
		if (httpSession.getAttribute("Admin") == null) {
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info", "Vous devez etre connecte en tant qu'admin !");
			return model1;
		}
		
		//ouverture de session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//liste des objets
		Objet objet = new Objet();
		List<Objet> objets = new ArrayList();
		for (int i = 0; i < astuce.getListObjetId().size(); i++) {
			objet = session.get(Objet.class, astuce.getListObjetId().get(i));
			objets.add(objet);
		}

		//set les valeurs pour astuces
		Astuce astuceRetour = session.get(Astuce.class, astuce.getIdAstuce());
		astuceRetour.setAstuce(astuce.getAstuce());
		astuceRetour.setAuteur(astuce.getAuteur());
		astuceRetour.setListObjet(objets);
		astuceRetour.setTitre(astuce.getTitre());

		//sauvegarde
		session.save(astuceRetour);

		session.getTransaction().commit();
		session.close();

		//ajout les infos
		ModelAndView modelAndView = affichePanneauAdminAstuces(httpSession);
		modelAndView.addObject("Succes", "La modification de l'astuce a ete faite avec succes.");

		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));

		return modelAndView;
	}

	/** Supprime une astuce
	 * @param idAstuce id de l'astuce � supprimer
	 * @param httpSession donne les info de l'utilisateur connect�
	 * */
	@RequestMapping("/astuce/{idAstuce}/supprimerAstuce")
	public ModelAndView suppressionAstuce(@PathVariable("idAstuce") int idAstuce, HttpSession httpSession) {
		
		//accessible que si admin
		if (httpSession.getAttribute("Admin") == null) {
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info", "Vous devez etre connecte en tant qu'admin !");
			return model1;
		}
		
		//ouverture de dession
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Astuce astuceRetour = session.get(Astuce.class, idAstuce);
		Criteria criteria = session.createCriteria(Vote.class);
        criteria.add(Restrictions.eq("astuce",astuceRetour));
        List<Vote> votes = (List<Vote>)criteria.list();
        if (votes.size()>0){
        	for(int j=0;j<votes.size();j++){
        		Vote vote;
        		vote = session.get(Vote.class, votes.get(j).getIdVote());
        		
        		session.delete(vote);
        		}
        }
		//supprime astuce
		session.delete(astuceRetour);

		//sauvegarde les changements
		session.getTransaction().commit();
		session.close();

		//ajout des infos
		ModelAndView modelAndView = affichePanneauAdminAstuces(httpSession);
		modelAndView.addObject("Succes", "Suppression de l'astuce avec succes.");

		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));

		return modelAndView;
	}
	
/**Passe une astuce en stade publi�
 * @param idAstuce idAstuce concern�e
 * @param httpSession donne les info de l'utilisateur connect�
 * */
	@RequestMapping("/astuce/{idAstuce}/publier")
	public ModelAndView publicationAstuce(@PathVariable("idAstuce") int idAstuce, HttpSession httpSession) {
		
		//possible que si admin
		if (httpSession.getAttribute("Admin") == null) {
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info", "Vous devez etre connecte en tant qu'admin !");
			return model1;
		}
		
		//ouverture de dession
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//va passer une astuce en publier
		Astuce astuceRetour = session.get(Astuce.class, idAstuce);
		astuceRetour.setPublie(true);
		session.save(astuceRetour);

		//sauvegarde et fermture
		session.getTransaction().commit();
		session.close();
		
// ajout des infos
		ModelAndView modelAndView = affichePanneauAdminAstuces(httpSession);
		modelAndView.addObject("Succes", "Publication de l'astuce avec succes.");

		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));

		return modelAndView;
	}

	/**Permet de passer une astuce au stade cach� 
	 * @param idAstuce id de l'astuce � cacher
	 * @param httpSession donne les info de l'utilisateur connect�
	 * */
	@RequestMapping("/astuce/{idAstuce}/cacher")
	public ModelAndView cacherAstuce(@PathVariable("idAstuce") int idAstuce, HttpSession httpSession) {
		
		//accessible que si admin
		if (httpSession.getAttribute("Admin") == null) {
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info", "Vous devez etre connecte en tant qu'admin !");
			return model1;
		}
		
		//ouverture de session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//cache l'astuce aux yeux du grand public
		Astuce astuceRetour = session.get(Astuce.class, idAstuce);
		astuceRetour.setPublie(false);
		session.save(astuceRetour);

		//sauvegarde
		session.getTransaction().commit();
		session.close();

		//ajout des infos
		ModelAndView modelAndView = affichePanneauAdminAstuces(httpSession);
		modelAndView.addObject("Succes", "L'astuce a ete cachée avec succes.");

		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));

		return modelAndView;
	}

	/** R�sultat du bouton enclench� "like". Si no vote ou dislike, ajoute un like. Si d�j� like, supprimer le vote
	 * @param idAstuce astuce concern�e
	 * @param cas Cas demand� pour lel ike
	 * @param httpSession donne les info de l'utilisateur connect�
	 * */
	@RequestMapping("astuce/{idAstuce}/liker/{cas}")
	public ModelAndView liker(@PathVariable("idAstuce") int idAstuce, @PathVariable("cas") String cas,
			HttpSession httpSession) {
		//cr�� modele and view
		ModelAndView modelAndView = detailAstuce(idAstuce, httpSession);
		String info = "";

		//ouverture de session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//r�cup�re info de l'astuce
		Astuce astuce = session.get(Astuce.class, idAstuce);

		//associe le vote � l'email
		CompteInscrit compteRetour;
		String email = (String) httpSession.getAttribute("emailUser");
		Query query = session.getNamedQuery("findCompteByEmail").setString("email", email);
		compteRetour = (CompteInscrit) query.uniqueResult();

		//cherche le vote de l'astuce en cherchant l'utilisateur
		Criteria criteria = session.createCriteria(Vote.class);
		criteria.add(Restrictions.eq("astuce", astuce)).add(Restrictions.eq("compte", compteRetour));
		List<Vote> votes = (List<Vote>) criteria.list();
		
		// si personne, permet de voter et redirige
		if (votes == null || votes.size() == 0) {
			modelAndView = new ModelAndView("redirect:/astuce/" + idAstuce);
			Vote vote = new Vote();
			vote.setAstuce(astuce);
			vote.setCompte(compteRetour);
			vote.setValeur("2");
			session.save(vote);
			session.getTransaction().commit();
			session.close();
			return modelAndView;
		} else {
			
			// sinon l� je comprends plus rien au code
			Vote vote = votes.get(0);
			if (vote.getValeur().equals("1")) {
				modelAndView = new ModelAndView("redirect:/astuce/" + idAstuce);
				vote.setValeur("2");
				session.save(vote);
				session.getTransaction().commit();
				session.close();
				return modelAndView;
			}
			if (vote.getValeur().equals("2")) {
				modelAndView = new ModelAndView("redirect:/astuce/" + idAstuce);
				vote.setValeur("1");
				session.save(vote);
				session.getTransaction().commit();
				session.close();
				return modelAndView;
			}
			if (vote.getValeur().equals("3")) {
				modelAndView = new ModelAndView("redirect:/astuce/" + idAstuce);
				vote.setValeur("2");
				session.save(vote);
				session.getTransaction().commit();
				modelAndView = new ModelAndView("redirect:/astuce/" + idAstuce);
				session.close();
				return modelAndView;
			}
		}
		return null;
	}
	
	/** R�sultat du bouton enclench� "dislike". Si no vote ou like, ajoute un dislike. Si d�j� dislike, supprimer le vote
	 * @param idAstuce astuce concern�e
	 * @param cas Cas demand� pour lel ike
	 * @param httpSession donne les info de l'utilisateur connect�
	 * */
	@RequestMapping("astuce/{idAstuce}/disliker/{cas}")
	public ModelAndView disliker(@PathVariable("idAstuce") int idAstuce, @PathVariable("cas") String cas,
			HttpSession httpSession) {

		ModelAndView modelAndView = detailAstuce(idAstuce, httpSession);
		String info = "";
		
		// ouverture de session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Astuce astuce = session.get(Astuce.class, idAstuce);

		// cherche le compte par email
		CompteInscrit compteRetour;
		String email = (String) httpSession.getAttribute("emailUser");
		Query query = session.getNamedQuery("findCompteByEmail").setString("email", email);
		compteRetour = (CompteInscrit) query.uniqueResult();

		//regarde si ya un compte associ� au vote et � l'astuce
		Criteria criteria = session.createCriteria(Vote.class);
		criteria.add(Restrictions.eq("astuce", astuce)).add(Restrictions.eq("compte", compteRetour));
		List<Vote> votes = (List<Vote>) criteria.list();
		
		// l� vraiment il est tr�s tard, ou plut�t tr�s t�t, 6h02 du matin
		// plus s�rieusement, je ne comprends pas le code ci-dessous
		if (votes == null || votes.size() == 0) {
			modelAndView = new ModelAndView("redirect:/astuce/" + idAstuce);
			Vote vote = new Vote();
			vote.setAstuce(astuce);
			vote.setCompte(compteRetour);
			vote.setValeur("3");
			session.save(vote);
			session.getTransaction().commit();
			session.close();
			return modelAndView;
		} else {
			Vote vote = votes.get(0);
			if (vote.getValeur().equals("1")) {
				modelAndView = new ModelAndView("redirect:/astuce/" + idAstuce);
				vote.setValeur("3");
				session.save(vote);
				session.getTransaction().commit();
				session.close();
				return modelAndView;
			}
			if (vote.getValeur().equals("2")) {
				modelAndView = new ModelAndView("redirect:/astuce/" + idAstuce);
				vote.setValeur("3");
				session.save(vote);
				session.getTransaction().commit();
				session.close();
				return modelAndView;
			}
			if (vote.getValeur().equals("3")) {
				modelAndView = new ModelAndView("redirect:/astuce/" + idAstuce);
				vote.setValeur("1");
				session.save(vote);
				session.getTransaction().commit();
				session.close();
				return modelAndView;
			}
		}
		return null;
	}
	
	
	
	@RequestMapping(value="/AjoutAstuceGenerale", method = RequestMethod.GET)
	public ModelAndView AjoutAstuceGenerale(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("AjoutAstuceGeneraleForm");
		
		//accessible que si admin
		if (httpSession.getAttribute("emailUser") == null) {
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info", "Vous devez etre connecte!");
			return model1;
		}
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//r�cup�re les objets pour les afficher, et yen a un tas.
				Criteria criteriaCategorieObjet = session.createCriteria(CategorieObjet.class);
				List<CategorieObjet> categorieObjets = (List<CategorieObjet>) criteriaCategorieObjet.list();

				Criteria criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(0)));
				List<Objet> balls = (List<Objet>) criteria.list();

				criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(1)));
				List<Objet> boxs = (List<Objet>) criteria.list();

				criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(2)));
				List<Objet> beds = (List<Objet>) criteria.list();

				criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(3)));
				List<Objet> furniture = (List<Objet>) criteria.list();

				criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(4)));
				List<Objet> tunnels = (List<Objet>) criteria.list();

				criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(5)));
				List<Objet> toys = (List<Objet>) criteria.list();

				criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(6)));
				List<Objet> heating = (List<Objet>) criteria.list();

				criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(7)));
				List<Objet> bagsHiding = (List<Objet>) criteria.list();

				criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(8)));
				List<Objet> scratching = (List<Objet>) criteria.list();

				criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(9)));
				List<Objet> baskets = (List<Objet>) criteria.list();

				criteria = session.createCriteria(Objet.class);
				criteria.add(Restrictions.eq("categorieObjet", categorieObjets.get(10)));
				List<Objet> foods = (List<Objet>) criteria.list();

				criteria = session.createCriteria(CategorieAstuce.class);
				List<CategorieAstuce> categorieAstuces = (List<CategorieAstuce>) criteria.list();

				session.close();
				
		// ajout des infos
				modelAndView.addObject("balls", balls);
				modelAndView.addObject("boxes", boxs);
				modelAndView.addObject("beds", beds);
				modelAndView.addObject("furniture", furniture);
				modelAndView.addObject("tunnels", tunnels);
				modelAndView.addObject("toys", toys);
				modelAndView.addObject("heating", heating);
				modelAndView.addObject("bagsHiding", bagsHiding);
				modelAndView.addObject("scratching", scratching);
				modelAndView.addObject("baskets", baskets);
				modelAndView.addObject("foods", foods);
				modelAndView.addObject("categorieAstuces", categorieAstuces);
				modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
				modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));

		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("email", httpSession.getAttribute("emailUser"));

		return modelAndView;
	}
	

	@RequestMapping(value="/AjoutAstuceGenerale", method = RequestMethod.POST)
	public ModelAndView AjoutAstuceGeneraleSubmit(@ModelAttribute("astuce") Astuce astuce, BindingResult result,HttpSession httpSession) {
		
		
		//accessible que si admin
		if (httpSession.getAttribute("emailUser") == null) {
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info", "Vous devez etre connecte!");
			return model1;
		}
		if (astuce.getTitre().equals("") || astuce.getAstuce().equals("")  || astuce.getTitre().length()>253 || astuce.getAstuce().length()>253) {
			ModelAndView model1 = new ModelAndView("Redirection");
			model1.addObject("error", "Erreur : Le corps, le titre de l'astuce est vide ou trop grand (255 caractères MAXIMUM) !!");
			model1.addObject("url", "/NekoAtsume/AjoutAstuceGenerale");
			return model1;
		}

		
		Objet objet;
				
//		CategorieAstuce categorieAstuce = astuce.getCategorie();
//		System.out.println("HEEEEEEEEEEEEEEY"+categorieAstuce.getNomCategorieAstuce());
		CompteInscrit compte;
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Liste d'objet a r�cuperer � partir des identifiants transmit par
		// le formulaire
		List<Objet> objets = new ArrayList<Objet>();
		for (int i = 0; i < astuce.getListObjetId().size(); i++) {
			objet = session.get(Objet.class, astuce.getListObjetId().get(i));
			objets.add(objet);
		}

		Query query = session.getNamedQuery("findCompteByEmail").setString("email",
				(String) httpSession.getAttribute("emailUser"));
		
		

		String emailUser = (String) httpSession.getAttribute("emailUser");
		compte = (CompteInscrit) query.uniqueResult();
		// Et on bind les infos � l'astuce
		astuce.setListObjet(objets);
		astuce.setAuteur(compte);
		
		CategorieAstuce categorieAstuce;
		Criteria criteriaCategorieAstuce = session.createCriteria(CategorieAstuce.class);
		criteriaCategorieAstuce.add(Restrictions.eq("nomCategorieAstuce", "Général"));
		categorieAstuce = (CategorieAstuce) criteriaCategorieAstuce.uniqueResult();
		
		astuce.setCategorie(categorieAstuce);
		
			
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          astuce.setDate((java.sql.Date) date);
		
		session.save(astuce);
		session.getTransaction().commit();
		session.close();
		ModelAndView modelAndView = listeAstuce(httpSession);
		modelAndView.addObject("email", compte);
		modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
		modelAndView.addObject("succes",
				"Votre astuce a �t� envoy�e aux mod�rateurs afin qu'ils puissent la valider !");
		return modelAndView;
	}
	
}
