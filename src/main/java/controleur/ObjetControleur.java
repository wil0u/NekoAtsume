package controleur;

import java.util.List;

import javax.servlet.http.HttpSession;

import modele.CategorieAstuce;
import modele.CategorieObjet;
import modele.Objet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ObjetControleur {
	
	/**
	 * Renvoie la liste des objets
	 * @param httpSession
	 * @return modelandview la page
	 */
	@RequestMapping("/objets")
	public ModelAndView listeObjet(HttpSession httpSession){
		
		// cr�ation model
		ModelAndView modelAndView = new ModelAndView("ObjetList");
		
		//ouverture session
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//requ�te avec criteria qui prends toutes les infos objets
		Criteria criteriaCategorieObjet = session.createCriteria(CategorieObjet.class);
		List<CategorieObjet> categorieObjets = (List<CategorieObjet>)criteriaCategorieObjet.list();
		
		// tri des r�sultats selon cat�gorie		
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
    	session.close();
    	//mise dans le modele
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
		modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
		modelAndView.addObject("Admin",httpSession.getAttribute("Admin"));
		return modelAndView;
		
		
	}
}
