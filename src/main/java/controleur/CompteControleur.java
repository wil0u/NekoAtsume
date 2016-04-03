package controleur;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modele.Astuce;
import modele.Chat;
import modele.CompteAdmin;
import modele.CompteInscrit;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CompteControleur {

	
	/** Retourne la page pour s'inscrire
	 * */
	@RequestMapping(value="/compte", method = RequestMethod.GET)
	public ModelAndView Inscription(){
		
		 //cr�ation modele
		ModelAndView modelAndView = new ModelAndView("InscriptionForm");
		
		return modelAndView;
	}
	
	/**
	 * Permet 
	 * @param httpSession donne les info de l'utilisateur connect�
	 * @return modelAndView page
	 */
	@RequestMapping(value="/monProfil", method = RequestMethod.GET)
	public ModelAndView voirProfil(HttpSession httpSession){
		
		 //creation modele
		ModelAndView modelAndView = new ModelAndView("CompteProfil");
		
		//ouverture session
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//rechercher d'un compte par son email
		String email = (String)httpSession.getAttribute("emailUser");
		Query query= session.getNamedQuery("findCompteByEmail")
				.setString("email", email);
		CompteInscrit compte= (CompteInscrit) query.uniqueResult();
		
		//mise du compte et de ses infos dans le modele
		modelAndView.addObject("compte",compte);
		modelAndView.addObject("Admin",httpSession.getAttribute("Admin"));
		return modelAndView;
	}
	
	/**
	 * Permet d'ajouter une personne aux comptes
	 * @param compte compte cr�� par modelAttribute
	 * @param result g�re les �ventuelles erreurs de modelAttribute
	 * @param request requ�te http
	 * @param response r�ponse http
	 * @return modelAndView la page
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value="/compte", method = RequestMethod.POST)
	public ModelAndView AjoutCompte(@ModelAttribute("compte") CompteInscrit compte, BindingResult result, HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		   
		ModelAndView model1 = new ModelAndView("InscriptionForm");
        String resultat;

        Map<String, String> erreurs = new HashMap<String, String>();
		
		/* R�cup�ration des champs du formulaire. */

        // s'il y a des erreurs dans la cr�ation du modelattribute, on renvoie � l'inscription
		if(result.hasErrors()){
			
			model1.addObject("error", "Erreur dans le formulaire, veuillez contacter un admin");
			return model1;
		}
		
		// informations du formulaire r�cup�r� par l'objet compte
		String pseudo = compte.getPseudo() ;
		String email = compte.getEmail() ;
		String motDePasse = compte.getMdp();
		String confirmation = request.getParameter("confirmation");
		
		CompteInscrit compteRetour;
		
		// ouverture session
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//regarder si ya pas d�j� un email existant
		Criteria criteria = session.createCriteria(CompteInscrit.class);  
		criteria.add( Restrictions.like("email", compte.getEmail()));
		List<CompteInscrit> comptesEmail = criteria.list();
					
		if(comptesEmail.size()>0){
		
			model1.addObject("error1","Cet email est deja utilis� !");
			
		}
		
		//regarder si ya pas un pseudo existant
		criteria = session.createCriteria(CompteInscrit.class);  
		criteria.add( Restrictions.like("pseudo", compte.getPseudo()));
		List<CompteInscrit> comptesPseudo = criteria.list();
		
		boolean erreur = false ;
		if(comptesPseudo.size()>0){
			
			model1.addObject("error2","Ce pseudo est d�ja utilis� !");
			erreur = true ;
		}
		
		//v�rifie les champs
		if(compte.getEmail().equals("")||compte.getPseudo().equals("")||compte.getMdp().equals("") ){
			
			model1.addObject("error3","Un ou plusieurs champs sont vides !");
			erreur = true ;
		}
		
		     /* Validation des champs mot de passe et confirmation. */

        try {

            validationMotsDePasse( motDePasse, confirmation );

        } catch ( Exception e ) {
          erreurs.put( "motdepasse", e.getMessage() );
          erreur = true ;
          
        	model1.addObject("error4","Votre mot de passe n'est pas identique ou trop court.");
	  }


        /* Validation du champ nom. */

        try {

            validationNom( pseudo );

        } catch ( Exception e ) {
        	erreur = true ;
 
        	model1.addObject("error5","Le nom d'utilisateur doit contenir au moins 3 caract�res.");
		  }
		
        // s'il y a une quelconque erreur
    	if (erreur == true){
			return model1;
		}
		else{
			
		session.save(compte);
		session.getTransaction().commit();
		session.close();
		ModelAndView modelAndView = new ModelAndView("index");
	    modelAndView.addObject("succes","Votre compte a �t� cr�� !");
		return modelAndView;}
	}


/**
 * Valide les mots de passe saisis	
 * @param motDePasse 
 * @param confirmation
 * @throws Exception
 */
	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
		
		// v�rifie si mdp non null et si lui et sa confirmations ne sont pas diff�rents
		if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null
				&& confirmation.trim().length() != 0) {

			if (!motDePasse.equals(confirmation)) {

				throw new Exception("Les mots de passe entr�s sont diff�rents, merci de les saisir � nouveau.");

			} else if (motDePasse.trim().length() < 3) {

				throw new Exception("Les mots de passe doivent contenir au moins 3 caract�res.");

			}

		} else {

			throw new Exception("Merci de saisir et confirmer votre mot de passe.");

		}

	}


/**
 * V�rifie que le nom n'est pas null et sup�rieur � 3 carac
 * @param nom nom �  tester
 * @throws Exception
 */
	private void validationNom(String nom) throws Exception {

		if (nom != null && nom.trim().length() < 3) {

			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caract�res.");

		}

	}
	
	
	
	/**
	 * Renvoie le formulaire de connection
	 * @return modelAndView la page
	 */
	@RequestMapping(value="/connexion", method = RequestMethod.GET)
	public ModelAndView ConnexionForm(){
		ModelAndView modelAndView = new ModelAndView("ConnexionForm");		
		return modelAndView;
	}
	/**
	 * Permet de se connecter
	 * @param compte Cr�� par modelAttribute � partir des infos saisies
	 * @param result g�re les erreurs eventuelles de modelattribute
	 * @param httpSession donne les info de l'utilisateur connect�
	 * @return
	 */
	@RequestMapping(value="/connexion", method = RequestMethod.POST)
	public ModelAndView Connexion(@ModelAttribute("compte") CompteInscrit compte, BindingResult result,HttpSession httpSession){
		
		//cr�ation du modele
		ModelAndView modelAndView = new ModelAndView("index");
		
		// s'il y a une rreur dans la creation du compteinscrit, bye bye
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			return model1;
		}	
		
		//ouverture session
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session sessionHibernate = sessionFactory.openSession();
		sessionHibernate.beginTransaction();
		CompteInscrit compteRetour = null;
		
		// chercher un compte par son email
		Query query= sessionHibernate.getNamedQuery("findCompteByEmail")
				.setString("email", compte.getEmail());
		compteRetour = (CompteInscrit) query.uniqueResult();
		
		//Si c'est vide, le compte n'existe pas
		if(compteRetour == null){
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("error","Erreur : Email ou mot de passe incorrect.");
			return model1;
		}else if(!compte.getMdp().equals(compteRetour.getMdp())){ // je vais te tuer t'as fait des elseif
			// si le mdp fourni est diff�rent du mdp BDD, l'authentification n'est pas bonne
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("error","Erreur : Le mot de passe est incorrect.");
			return model1;
		}
			else if(compteRetour.isBanned()){
				// Si on est banni ben c'est mort.
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("error","Erreur : Le compte : "+compte.getEmail()+" est banni, veuillez vous adresser à un admin.");
				return model1;
				
				
				
			}	
			//test si Admin
		else if(compte.getMdp().equals(compteRetour.getMdp()) && !compteRetour.isBanned()){
			if(compteRetour instanceof CompteAdmin){
				httpSession.setAttribute("Admin", "Admin");
				System.out.println("je suis un admin");
			}
			System.out.println("le user existe  et son mdp coincide!");
			httpSession.setAttribute("emailUser", compte.getEmail());
			
		}
	
		
		
		return modelAndView;
	}
	
	/**
	 * Permet de se deconnecter
	 * @param httpSession donne les info de l'utilisateur connect�
	 * @return
	 */
	@RequestMapping(value="/deconnexion")
	public ModelAndView Deconnexion(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView("index");
		   httpSession.invalidate(); 
           return modelAndView;
	}
	
	/**
	 * Permet de changer le mot de passe
	 * @param httpSession donne les info de l'utilisateur connect�
	 * @param pass1 
	 * @param pass2 en comparaison avec pass1, permet de v�rifier
	 * @return
	 */
	@RequestMapping(value="/submitMotPass", method = RequestMethod.POST)
	public ModelAndView ChangerMdpSubmit(HttpSession httpSession,@RequestParam("pass1") String pass1,@RequestParam("pass2") String pass2){
		
		// il faut que le 2 mdp soient identiques
		if(!pass1.equals(pass2)){	
		ModelAndView model1 = new ModelAndView("ChangerDeMotDePassForm");
		model1.addObject("error","Error : Les mots de passes ne sont pas identiques");
		return model1;
		}
		if(pass1.equals("")||pass2.equals("")){	
			ModelAndView model1 = new ModelAndView("ChangerDeMotDePassForm");
			model1.addObject("error","Attention un ou plusieurs champ(s) de saisie(s) sont vides.");
			return model1;
			}
		
		//ouverture session
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session sessionHibernate = sessionFactory.openSession();
		sessionHibernate.beginTransaction();
		CompteInscrit compteRetour = null;
		
		// chercher compte par email
		String email = (String)httpSession.getAttribute("emailUser");
		Query query= sessionHibernate.getNamedQuery("findCompteByEmail")
				.setString("email",email);
		compteRetour = (CompteInscrit) query.uniqueResult();
		
		// set le mdp 
		System.out.println(compteRetour.getMdp());
		compteRetour.setMdp(pass1);
		System.out.println(compteRetour.getMdp());
		sessionHibernate.save(compteRetour);
		sessionHibernate.getTransaction().commit();
		// sauvegarde les changements
		
		ModelAndView modelAndView = voirProfil(httpSession);
		
		modelAndView.addObject("Succes","Changement de mot de passe effectu� avec succ�s.");
        return modelAndView;
	}
	
	/**
	 * Affiche la page pour changer de mot de passe
	 * @param httpSession
	 * @return modelAndView, la page
	 */
	@RequestMapping(value="/changerMotPass")
	public ModelAndView changerMdp(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView("ChangerDeMotDePassForm");
		   
        return modelAndView;
	}
	


	/**
	 * Affiche le panneau admin des membres
	 * @param httpSession donne les info de l'utilisateur connect�
	 * @return modelAndViewla page
	 */
	@RequestMapping(value="/AdminMembres")
	public ModelAndView affichePanneauAdminMembres(HttpSession httpSession){
		
		// si on est pas un admin, on ne peut pas acc�der � la page
		if(httpSession.getAttribute("Admin")==null){
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
			return model1;
		}
ModelAndView modelAndView = new ModelAndView("AdminMembres");

//ouverture de session
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session session = sessionFactory.openSession();
session.beginTransaction();

// rechercher criteria par email
Criteria criteria = session.createCriteria(CompteInscrit.class);
List<CompteInscrit> inscrits = (List<CompteInscrit>) criteria.list();
modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
modelAndView.addObject("listInscrit", inscrits);



//modelAndView.addObject("listInscrit", indicateurBanned);
// 

		return modelAndView;
	}
	
	/**
	 * Permet de bannir un compte
	 * @param idCompte compte concern�
	 * @param httpSession donne les info de l'utilisateur connect�
	 * @return la page
	 */
	@RequestMapping(value="/membre/{idCompte}/bannir")
	public ModelAndView bannir(@PathVariable("idCompte") int idCompte,HttpSession httpSession){
		
		// si on est pas admin, on ne peut pas acc�der � la page
		if(httpSession.getAttribute("Admin")==null){
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
			return model1;
		}
		
		//ouverture session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CompteInscrit compteRetour;
		compteRetour = session.get(CompteInscrit.class,idCompte);
		
		// changer la personne en "banni"
		compteRetour.setBanned(true);
		session.save(compteRetour);
		session.getTransaction().commit();
		// sauvegarde des changements
		
		ModelAndView modelAndView = affichePanneauAdminMembres(httpSession);
        return modelAndView;
	}
	@RequestMapping(value="/membre/{idCompte}/debannir")
	public ModelAndView debannir(@PathVariable("idCompte") int idCompte,HttpSession httpSession){
		
		// fonction accessibles qu'aux admins
		if(httpSession.getAttribute("Admin")==null){
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
			return model1;
		}
		
		// ouverture session
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		CompteInscrit compteRetour;
		
		// changement de la personne en "debanni" ou normal
		compteRetour = session.get(CompteInscrit.class,idCompte);
		compteRetour.setBanned(false);
		session.save(compteRetour);
		session.getTransaction().commit();
		// sauvegarde des changements 
		
		ModelAndView modelAndView = affichePanneauAdminMembres(httpSession);
        return modelAndView;
	}
	
	 
	
	
}
