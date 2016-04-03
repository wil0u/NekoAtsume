package controleur;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	
//	/**Retourne la page d'accueil
//	 * @param httpSession donne les info de l'utilisateur connecté
//	 * */
//	@RequestMapping("/index")
//	public ModelAndView listeAstuce(HttpSession httpSession){
//		ModelAndView modelAndView = new ModelAndView("index");
//		modelAndView.addObject("Admin",httpSession.getAttribute("Admin"));
//		modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
//		
//		return modelAndView;
//		
//		
//	}
}
