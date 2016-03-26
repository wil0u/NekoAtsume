package controleur;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import modele.Astuce;
import modele.CategorieAstuce;
import modele.CategorieObjet;
import modele.Chat;
import modele.CompteInscrit;
import modele.Objet;

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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AstuceControleur {
	@RequestMapping("/astuces")
	public ModelAndView listeAstuce(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView("AstuceListe");
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
    	Criteria criteria = session.createCriteria(Astuce.class);
		List<Astuce> astuces = (List<Astuce>)criteria.list();
		modelAndView.addObject("ListeAstuce",astuces);
		modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
		return modelAndView;
		
		
	}
	
	@RequestMapping("/astuce/{idAstuce}")
	public ModelAndView detailChat(@PathVariable("idAstuce") int idAstuce, HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView("Astuce");
		Astuce astuce = new Astuce();
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		astuce = session.get(Astuce.class,idAstuce);
		modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
		modelAndView.addObject("Astuce",astuce);
		return modelAndView;
		
		
	}
	@RequestMapping(value="/chat/{idChat}/astuces", method = RequestMethod.GET)
	public ModelAndView AstucesAssocieesAuChat(@PathVariable("idChat") int idChat,HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView("AstucesChat");
		Chat chat = new Chat();
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		chat = session.get(Chat.class,idChat);
		
    	Criteria criteria = session.createCriteria(Astuce.class);
    	criteria.add(Restrictions.eq("chat",chat));
		List<Astuce> astuces = (List<Astuce>)criteria.list();      
		for (int i = 1 ; i < astuces.size(); i++)
			System.out.println("Astuce :"+astuces.get(i).getAstuce());
		modelAndView.addObject("listeAstuces",astuces);
		modelAndView.addObject("Chat",chat);
		modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
		return modelAndView;
		
		
	}
	
	@RequestMapping(value="/chat/{idChat}/astuce", method = RequestMethod.GET)
	public ModelAndView AjoutAstuce(@PathVariable("idChat") int idChat,HttpSession httpSession){
		if(httpSession.getAttribute("emailUser")==null){
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("Info","Vous devez �tre connect� pour ajouter une astuce.");
			return model1;
		}
		ModelAndView modelAndView = new ModelAndView("AjoutAstuceForm");
		Chat chat = new Chat();
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		chat = session.get(Chat.class,idChat);
		
		Criteria criteriaCategorieObjet = session.createCriteria(CategorieObjet.class);
		List<CategorieObjet> categorieObjets = (List<CategorieObjet>)criteriaCategorieObjet.list();
		
		
		
    	Criteria criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(0)));
    	List<Objet> balls = (List<Objet>)criteria.list();
    	
    	criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(1)));
    	List<Objet> boxs = (List<Objet>)criteria.list();
		
    	criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(2)));
    	List<Objet> beds = (List<Objet>)criteria.list();
		
    	criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(3)));
    	List<Objet> furniture = (List<Objet>)criteria.list();
    	
    	criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(4)));
    	List<Objet> tunnels = (List<Objet>)criteria.list();
    	
    	criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(5)));
    	List<Objet> toys = (List<Objet>)criteria.list();
		
    	criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(6)));
    	List<Objet> heating = (List<Objet>)criteria.list();
		
    	criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(7)));
    	List<Objet> bagsHiding = (List<Objet>)criteria.list();
    	
    	criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(8)));
    	List<Objet> scratching = (List<Objet>)criteria.list();
		
    	criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(9)));
    	List<Objet> baskets = (List<Objet>)criteria.list();
    	
    	criteria = session.createCriteria(Objet.class);
    	criteria.add(Restrictions.eq("categorieObjet",categorieObjets.get(10)));
    	List<Objet> foods = (List<Objet>)criteria.list();
    	
    	
    	criteria = session.createCriteria(CategorieAstuce.class);
    	
    	List<CategorieAstuce> listCategorieAstuces = (List<CategorieAstuce>)criteria.list();
    	
    	
    	
		modelAndView.addObject("balls",balls);
		modelAndView.addObject("boxes",boxs);
		modelAndView.addObject("beds",beds);
		modelAndView.addObject("furniture",furniture);
		modelAndView.addObject("tunnels",tunnels);
		modelAndView.addObject("toys",toys);
		modelAndView.addObject("heating",heating);
		modelAndView.addObject("bagsHiding",bagsHiding);
		modelAndView.addObject("scratching",scratching);
		modelAndView.addObject("baskets",baskets);
		modelAndView.addObject("foods",foods);
		modelAndView.addObject("chat",chat);
		modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
		
		return modelAndView;
		
		
	}
	@RequestMapping(value="/chat/{idChat}/astuce", method = RequestMethod.POST)
	public ModelAndView AjoutAstuce(@ModelAttribute("astuce") Astuce astuce, BindingResult result,@PathVariable("idChat") int idChat,HttpSession httpSession){
		
		//Teste si il y � des erreus
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("AjoutAstuceForm");
			return model1;
		}
		
		if(astuce.getTitre().equals("")||astuce.getAstuce().equals("")){
			ModelAndView model1 = new ModelAndView("Redirection");
			model1.addObject("error","Erreur : Le corps ou le titre de l'astuce est vide !!");
			model1.addObject("url","/NekoAtsume/chat/"+idChat+"/astuce");
			return model1;
		}
		
		//Associe la vue AjoutSucces avec m�thode
		ModelAndView modelAndView = new ModelAndView("AjoutSucces");
		Objet objet;
		Chat chat;
		CompteInscrit compte;
		
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Liste d'objet a r�cuperer � partir des identifiants transmit par le formulaire
		List<Objet> objets = new ArrayList<Objet>();
		for(int i=0;i<astuce.getListObjetId().size();i++){
			objet = session.get(Objet.class, astuce.getListObjetId().get(i)); 
			objets.add(objet);
		}
		
		//On r�cup�re le chat associ� 
		chat = session.get(Chat.class, idChat);
		Query query= session.getNamedQuery("findCompteByEmail")
				.setString("email", (String) httpSession.getAttribute("emailUser"));
	
		String emailUser = (String) httpSession.getAttribute("emailUser");
		compte = (CompteInscrit) query.uniqueResult();
		//Et on bind les infos � l'astuce 
		astuce.setListObjet(objets);
		astuce.setAuteur(compte);
		astuce.setChat(chat);
		session.save(astuce);
		session.getTransaction().commit();
		session.close();
		modelAndView.addObject("email",compte);
		return modelAndView;
		
		
	}
}
