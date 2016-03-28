package controleur;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modele.Astuce;
import modele.Chat;
import modele.CompteInscrit;
import modele.Objet;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatControleur {

	@RequestMapping("/chats")
	public ModelAndView listeChat(HttpSession httpSession){
		
		 
		ModelAndView modelAndView = new ModelAndView("ChatListe");
		
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
	
	 @RequestMapping("/AdminChats")
	 public ModelAndView affichePanneauAdminChats(HttpSession httpSession){
		 ModelAndView modelAndView = new ModelAndView("AdminChats");
			
		 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
	    	Criteria criteria = session.createCriteria(Chat.class);
			List<Chat> chats = (List<Chat>)criteria.list();
			modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
			modelAndView.addObject("listChat",chats);
		
			return modelAndView;
	 }
		
	@RequestMapping("/chat/chatsRech")
	public ModelAndView recherche_Chat_Nom(HttpSession httpSession,  HttpServletRequest request){
		
	    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
    	String nomChat = request.getParameter("NomChat");
    	String lvlChat = request.getParameter("LvlChat");
    	System.out.println("Nom chat : " +nomChat);
    	System.out.println("Lvl Chat : " +lvlChat);
    	
    	// si nom chat pas vide
    	if(!(nomChat.equals(""))){
    		System.out.println("Dans la recherhe Chat par Nom");
   	 	Query query = session.getNamedQuery("findCatbyName").setString("nom", nomChat);
        Chat chat = (Chat) query.uniqueResult();
	 
    	if(chat != null){
    	  ModelAndView modelAndView = detailChat(chat.getIdChat(), httpSession);
    	  return modelAndView ;
    	}
    	else{
    	
    	ModelAndView modelAndView = listeChat(httpSession);
    	modelAndView.addObject("error","Il n'y a pas de chat associé à ce nom");
    	return modelAndView;
    	
    	}
    	}
    	// si on veut rechercher par Lvl, il peut y avoir plusieurs chats.
    	else{
    		System.out.println("Rechercher Chat par Lvl");
    		ModelAndView modelAndView = listeChatLvl(httpSession, Integer.parseInt(lvlChat));
    		System.out.println("Reussi");
    		return modelAndView;	
       	}

    		
    	}
		
	   public ModelAndView listeChatLvl(HttpSession httpSession, int lvl){
		
		 
		ModelAndView modelAndView = new ModelAndView("ChatListe");
				
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
        Criteria criteria = session.createCriteria(Chat.class);
    	criteria.add(Restrictions.eq("lvlChat",lvl));
    	List<Chat> chats= (List<Chat>)criteria.list();
    	System.out.println("FONCTIONNE ?");

		modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
		modelAndView.addObject("listChat",chats);
		return modelAndView;
		
	}
	   
	  
	   @RequestMapping("/chat/{idChat}/moderer")
		public ModelAndView AdminModererChat(@PathVariable("idChat") int idChat,HttpSession httpSession){
			ModelAndView modelAndView = new ModelAndView("AdminChatsModeration");
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
	   
	   @RequestMapping("/AdminAjoutChat")
		public ModelAndView AdminAjoutChat(HttpSession httpSession){
			ModelAndView modelAndView = new ModelAndView("AdminAjoutChat");
						
			return modelAndView;
			
			
		}
	
	
	
}
