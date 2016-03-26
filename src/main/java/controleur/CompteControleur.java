package controleur;

import java.util.List;

import javax.servlet.http.HttpSession;

import modele.Astuce;
import modele.Chat;
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

	
	
	@RequestMapping(value="/compte", method = RequestMethod.GET)
	public ModelAndView Inscription(){
		
		 
		ModelAndView modelAndView = new ModelAndView("InscriptionForm");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/monProfile", method = RequestMethod.GET)
	public ModelAndView voirProfile(HttpSession sessionHttp){
		
		 
		ModelAndView modelAndView = new ModelAndView("CompteProfile");
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String email = (String)sessionHttp.getAttribute("emailUser");
		Query query= session.getNamedQuery("findCompteByEmail")
				.setString("email", email);
		CompteInscrit compte= (CompteInscrit) query.uniqueResult();
		modelAndView.addObject("compte",compte);
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
		Criteria criteria = session.createCriteria(CompteInscrit.class);  
		criteria.add( Restrictions.like("email", compte.getEmail()));
		List<CompteInscrit> comptesEmail = criteria.list();
		if(comptesEmail.size()>0){
			ModelAndView model1 = new ModelAndView("InscriptionForm");
			model1.addObject("error","Erreur : Cet email est deja utilisé !");
			return model1;
		}
		criteria = session.createCriteria(CompteInscrit.class);  
		criteria.add( Restrictions.like("pseudo", compte.getPseudo()));
		List<CompteInscrit> comptesPseudo = criteria.list();
		if(comptesPseudo.size()>0){
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
		
		Query query= sessionHibernate.getNamedQuery("findCompteByEmail")
				.setString("email", compte.getEmail());
		compteRetour = (CompteInscrit) query.uniqueResult();
		
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
	
	@RequestMapping(value="/submitMotPass", method = RequestMethod.POST)
	public ModelAndView ChangerMdpSubmit(HttpSession httpSession,@RequestParam("pass1") String pass1,@RequestParam("pass2") String pass2){
		ModelAndView modelAndView = new ModelAndView("Redirection");
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
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session sessionHibernate = sessionFactory.openSession();
		sessionHibernate.beginTransaction();
		CompteInscrit compteRetour = null;
		String email = (String)httpSession.getAttribute("emailUser");
		Query query= sessionHibernate.getNamedQuery("findCompteByEmail")
				.setString("email",email);
		compteRetour = (CompteInscrit) query.uniqueResult();
		System.out.println(compteRetour.getMdp());
		compteRetour.setMdp(pass1);
		System.out.println(compteRetour.getMdp());
		sessionHibernate.save(compteRetour);
		sessionHibernate.getTransaction().commit();
		modelAndView.addObject("url","/NekoAtsume/index");
		modelAndView.addObject("succes","Changement de mot de passe effectué avec succes.");
        return modelAndView;
	}
	@RequestMapping(value="/changerMotPass")
	public ModelAndView changerMdp(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView("ChangerDeMotDePassForm");
		   
        return modelAndView;
	}
	
}
