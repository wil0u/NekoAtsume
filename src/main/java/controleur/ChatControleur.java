package controleur;

import java.util.List;

import javax.servlet.http.HttpSession;

import modele.Astuce;
import modele.Chat;
import modele.Objet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatControleur {

	@RequestMapping("/chats")
	public ModelAndView listeChat(HttpSession httpSession){
		
		 
		ModelAndView modelAndView = new ModelAndView("ChatListe");
		modelAndView.addObject("WelcomeMessage","Hi guys, my name is Ankush Gorav. At the moment i'm riding my elephant and i'm eating some badam dooh!");
		
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
    	Criteria criteria = session.createCriteria(Chat.class);
		List<Chat> chats = (List<Chat>)criteria.list();
		modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
		modelAndView.addObject("listChat",chats);
		return modelAndView;
	}
	@RequestMapping("/chat/{idChat}")
	public ModelAndView detailChat(@PathVariable("idChat") int idChat,HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView("Chat");
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
		modelAndView.addObject("Chat",chat);
		modelAndView.addObject("ListeAstuces",astuces);
		modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
		return modelAndView;
		
		
	}
}