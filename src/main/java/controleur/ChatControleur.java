package controleur;

import java.util.List;

import modele.Chat;
import modele.Objet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatControleur {

	@RequestMapping("/chats")
	public ModelAndView coucouLol(){
		
		 
		ModelAndView modelAndView = new ModelAndView("ChatListe");
		modelAndView.addObject("WelcomeMessage","Hi guys, my name is Ankush Gorav. At the moment i'm riding my elephant and i'm eating some badam dooh!");
		
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
    	Criteria criteria = session.createCriteria(Chat.class);
		List<Chat> chats = (List<Chat>)criteria.list();
		modelAndView.addObject("listChat",chats);
		return modelAndView;
	}
}