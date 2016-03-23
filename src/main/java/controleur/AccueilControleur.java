package controleur;

import java.util.List;

import modele.Astuce;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccueilControleur {

	@RequestMapping("/index")
	public ModelAndView listeAstuce(){
		ModelAndView modelAndView = new ModelAndView("index");
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		return modelAndView;
		
		
	}
}
