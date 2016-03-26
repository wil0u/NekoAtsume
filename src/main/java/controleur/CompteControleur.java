package controleur;

import java.util.List;

import javax.servlet.http.HttpSession;

import modele.Astuce;
import modele.Chat;
import modele.CompteInscrit;

import org.hibernate.Criteria;
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
public class CompteControleur {

	
	
	@RequestMapping(value="/compte", method = RequestMethod.GET)
	public ModelAndView Inscription(){
		
		 
		ModelAndView modelAndView = new ModelAndView("InscriptionForm");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/compte", method = RequestMethod.POST)
	public ModelAndView AjoutCompte(@ModelAttribute("compte") CompteInscrit compte, BindingResult result){
		ModelAndView modelAndView = new ModelAndView("AjoutSucces");
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("InscriptionForm");
			return model1;
		}
		CompteInscrit compteRetour;
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		compteRetour = session.get(CompteInscrit.class,compte.getEmail());
		if(compteRetour!=null){
			ModelAndView model1 = new ModelAndView("InscriptionForm");
			model1.addObject("error","Erreur : Cet email est deja utilisé !");
			return model1;
		}
		Criteria criteria = session.createCriteria(CompteInscrit.class);  
		criteria.add( Restrictions.like("pseudo", compte.getPseudo()));
		List<CompteInscrit> comptes = criteria.list();
		if(comptes.size()>0){
			ModelAndView model1 = new ModelAndView("InscriptionForm");
			model1.addObject("error","Erreur : Ce pseudo est déja utilisé !");
			return model1;
		}
		
		if(compte.getEmail().equals("")||compte.getPseudo().equals("")||compte.getMdp().equals("") ){
			ModelAndView model1 = new ModelAndView("InscriptionForm");
			model1.addObject("error","Erreur : Un ou plusieurs champs sont vides !");
			return model1;
		}
		session.save(compte);
		session.getTransaction().commit();
		session.close();
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/connexion", method = RequestMethod.GET)
	public ModelAndView ConnexionForm(){
		ModelAndView modelAndView = new ModelAndView("ConnexionForm");		
		return modelAndView;
	}
	
	@RequestMapping(value="/connexion", method = RequestMethod.POST)
	public ModelAndView Connexion(@ModelAttribute("compte") CompteInscrit compte, BindingResult result,HttpSession session){
		ModelAndView modelAndView = new ModelAndView("index");
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			return model1;
		}	
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session sessionHibernate = sessionFactory.openSession();
		sessionHibernate.beginTransaction();
		CompteInscrit compteRetour = null;
		compteRetour = sessionHibernate.get(CompteInscrit.class, compte.getEmail());
		
		if(compteRetour != null && compte.getMdp().equals(compteRetour.getMdp())){
			System.out.println("le user existe  et son mdp coincide!");
			session.setAttribute("emailUser", compte.getEmail());
		}else{
			ModelAndView model1 = new ModelAndView("ConnexionForm");
			model1.addObject("error","Erreur : Email ou mot de passe incorrect.");
			return model1;
		}
		
		return modelAndView;
	}
	@RequestMapping(value="/deconnexion")
	public ModelAndView Deconnexion(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView("index");
		   httpSession.invalidate(); 
           return modelAndView;
	}
	
	
}
