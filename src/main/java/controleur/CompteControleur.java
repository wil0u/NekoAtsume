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

	
	
	@RequestMapping(value="/compte", method = RequestMethod.GET)
	public ModelAndView Inscription(){
		
		 
		ModelAndView modelAndView = new ModelAndView("InscriptionForm");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/monProfil", method = RequestMethod.GET)
	public ModelAndView voirProfile(HttpSession sessionHttp){
		
		 
		ModelAndView modelAndView = new ModelAndView("CompteProfil");
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String email = (String)sessionHttp.getAttribute("emailUser");
		Query query= session.getNamedQuery("findCompteByEmail")
				.setString("email", email);
		CompteInscrit compte= (CompteInscrit) query.uniqueResult();
		modelAndView.addObject("compte",compte);
		modelAndView.addObject("Admin",sessionHttp.getAttribute("Admin"));
		return modelAndView;
	}
	
	
	@RequestMapping(value="/compte", method = RequestMethod.POST)
	public ModelAndView AjoutCompte(@ModelAttribute("compte") CompteInscrit compte, BindingResult result, HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		   

        String resultat;

        Map<String, String> erreurs = new HashMap<String, String>();
		
		/* R�cup�ration des champs du formulaire. */

		ModelAndView modelAndView = new ModelAndView("AjoutSucces");
		if(result.hasErrors()){
			ModelAndView model1 = new ModelAndView("InscriptionForm");
			return model1;
		}
		
		
		String pseudo = compte.getPseudo() ;
		String email =compte.getEmail() ;
		String motDePasse = compte.getMdp();
		String confirmation = request.getParameter("confirmation");
		
		CompteInscrit compteRetour;
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(CompteInscrit.class);  
		criteria.add( Restrictions.like("email", compte.getEmail()));
		List<CompteInscrit> comptesEmail = criteria.list();
		
		ModelAndView model1=null;
				
		if(comptesEmail.size()>0){
			model1 = new ModelAndView("InscriptionForm");
			model1.addObject("error1","Cet email est deja utilis� !");
			
		}
		
		criteria = session.createCriteria(CompteInscrit.class);  
		criteria.add( Restrictions.like("pseudo", compte.getPseudo()));
		List<CompteInscrit> comptesPseudo = criteria.list();
		
		if(comptesPseudo.size()>0){
			model1 = new ModelAndView("InscriptionForm");
			model1.addObject("error2","Ce pseudo est d�ja utilis� !");
		}
		
		if(compte.getEmail().equals("")||compte.getPseudo().equals("")||compte.getMdp().equals("") ){
			model1 = new ModelAndView("InscriptionForm");
			model1.addObject("error3","Un ou plusieurs champs sont vides !");
		}
		
		     /* Validation des champs mot de passe et confirmation. */

        try {

            validationMotsDePasse( motDePasse, confirmation );

        } catch ( Exception e ) {
          erreurs.put( "motdepasse", e.getMessage() );
          	model1 = new ModelAndView("InscriptionForm");
        	model1.addObject("error4","Votre mot de passe n'est pas identique ou trop court.");
	  }


        /* Validation du champ nom. */

        try {

            validationNom( pseudo );

        } catch ( Exception e ) {
 
        	model1.addObject("error5","Le nom d'utilisateur doit contenir au moins 3 caract�res.");
		  }
		
        // s'il y a une quelconque erreur
    	if (model1 != null){
			return model1;
		}
		else{
			
		session.save(compte);
		session.getTransaction().commit();
		session.close();
		
	
		return modelAndView;}
	}


	/**
	 * 
	 * Valide les mots de passe saisis.
	 * 
	 */

	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {

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
	 * 
	 * Valide le nom d'utilisateur saisi.
	 * 
	 */

	private void validationNom(String nom) throws Exception {

		if (nom != null && nom.trim().length() < 3) {

			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caract�res.");

		}

	}
	
	
	
	
	@RequestMapping(value="/connexion", method = RequestMethod.GET)
	public ModelAndView ConnexionForm(){
		ModelAndView modelAndView = new ModelAndView("ConnexionForm");		
		return modelAndView;
	}
	
	@RequestMapping(value="/connexion", method = RequestMethod.POST)
	public ModelAndView Connexion(@ModelAttribute("compte") CompteInscrit compte, BindingResult result,HttpSession httpSession){
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
			if(compteRetour instanceof CompteAdmin){
				httpSession.setAttribute("Admin", "Admin");
				System.out.println("je suis un admin");
			}
			System.out.println("le user existe  et son mdp coincide!");
			httpSession.setAttribute("emailUser", compte.getEmail());
			
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
		
		ModelAndView modelAndView = voirProfile(httpSession);
		
		modelAndView.addObject("Succes","Changement de mot de passe effectu� avec succ�s.");
        return modelAndView;
	}
	
	@RequestMapping(value="/changerMotPass")
	public ModelAndView changerMdp(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView("ChangerDeMotDePassForm");
		   
        return modelAndView;
	}
	
	@RequestMapping(value="/AdminPanneau")
	public ModelAndView affichePanneauAdmin(HttpSession httpSession){
ModelAndView modelAndView = new ModelAndView("AdminPanneau");
		
		return modelAndView;
	}

	
	@RequestMapping(value="/AdminMembres")
	public ModelAndView affichePanneauAdminMembres(HttpSession httpSession){
ModelAndView modelAndView = new ModelAndView("AdminMembres");


SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session session = sessionFactory.openSession();
session.beginTransaction();


Criteria criteria = session.createCriteria(CompteInscrit.class);
List<CompteInscrit> inscrits = (List<CompteInscrit>) criteria.list();
modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
modelAndView.addObject("listInscrit", inscrits);



//List results = session.createCriteria(Cat.class)
//.setProjection( Projections.alias( Projections.groupProperty("color"), "colr" ) )
//.addOrder( Order.asc("colr") )
//.list();
//
//Example example = Example.create(cat)
//.excludeZeroes()           //exclude zero valued properties
//.excludeProperty("color")  //exclude the property named "color"
//.ignoreCase()              //perform case insensitive string comparisons
//.enableLike();             //use like for string comparisons
//List results = session.createCriteria(Cat.class)
//.add(example)
//.list();
		return modelAndView;
	}
	
	
}
