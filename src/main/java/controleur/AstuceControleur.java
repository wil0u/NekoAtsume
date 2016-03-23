package controleur;

import java.util.List;

import modele.Astuce;
import modele.Chat;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AstuceControleur {
	@RequestMapping("/astuces")
	public ModelAndView listeAstuce(){
		ModelAndView modelAndView = new ModelAndView("AstuceListe");
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
    	Criteria criteria = session.createCriteria(Astuce.class);
		List<Astuce> astuces = (List<Astuce>)criteria.list();
		modelAndView.addObject("ListeAstuce",astuces);
		return modelAndView;
		
		
	}
	
	@RequestMapping("/astuce/{idAstuce}")
	public ModelAndView detailChat(@PathVariable("idAstuce") int idAstuce){
		ModelAndView modelAndView = new ModelAndView("Astuce");
		Astuce astuce = new Astuce();
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		astuce = session.get(Astuce.class,idAstuce);
		
		modelAndView.addObject("Astuce",astuce);
		return modelAndView;
		
		
	}
}
