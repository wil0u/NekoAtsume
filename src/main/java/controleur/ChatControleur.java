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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatControleur {
	
	@RequestMapping("/chats")
	public ModelAndView listeChat (HttpSession httpSession){
		ModelAndView modelAndView = listeChat(httpSession, "-","NA");
		return modelAndView;
	}

	/**
    Obtenir le classement chats ordonn� par le crit�re "TRI". Pas de crit�re =  la page sans tri
    @param httpSession La session HTTP
    @param tri Le crit�re de tri
    @param admin contient "admin" quand la requ�te vient d'une page admin
    @return La page associ�e
*/
		public ModelAndView listeChat(HttpSession httpSession, String tri, String admin){
		ModelAndView modelAndView = null;
		
		if(admin.equals("NA")){
	    modelAndView = new ModelAndView("ChatListe");}
		else
		{
		modelAndView = new ModelAndView("AdminChats");}
		
		if(tri == null){
			tri="-";
		}
		
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Chat.class);
		List<Chat> chats = null ;
		 
	    switch (tri) {
        case "UP": chats = session.createCriteria(Chat.class).addOrder(Order.asc("nomChat")).list();
                 break;
        case "DOWN": chats = session.createCriteria(Chat.class).addOrder(Order.desc("nomChat")).list();
                 break;
        case "LVLUP":  chats = session.createCriteria(Chat.class).addOrder(Order.asc("lvlChat")).list();
                 break;
        case "LVLDOWN":  chats = session.createCriteria(Chat.class).addOrder(Order.desc("lvlChat")).list();
                 break;
        default: 
		chats = (List<Chat>)criteria.list();
        break;
        }
  			
		modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
		modelAndView.addObject("listChat",chats);
		session.close();
		return modelAndView;
		
	}
	
	/**
    Obtenir le classement chats ordonn� par ordre croissant des noms
    @param httpSession La session HTTP
    @return La page associ�e
*/
	@RequestMapping("/chatsNomUP")
	public ModelAndView listeChatNomUP(HttpSession httpSession){
		
		 
		ModelAndView modelAndView = listeChat(httpSession, "UP","NA");
		return modelAndView;
		
	}
	
	/**
    Obtenir le classement chats ordonn� par ordre d�croissant des noms
    @param httpSession La session HTTP
    @return La page associ�e
*/
	@RequestMapping("/chatsNomDOWN")
	public ModelAndView listeChatNomDOWN(HttpSession httpSession){
		
		 
		ModelAndView modelAndView = listeChat(httpSession, "DOWN","NA");
		return modelAndView;
	}
	
	/**
    Obtenir le classement chats ordonn� par ordre croissant des lvl
    @param httpSession La session HTTP
    @return La page associ�e
*/
	@RequestMapping("/chatsLvlUP")
	public ModelAndView listeChatLvlUP(HttpSession httpSession){
		
		 
		ModelAndView modelAndView = listeChat(httpSession, "LVLUP","NA");
			 	
		return modelAndView;
		
	}
	
	/**
    Obtenir le classement chats ordonn� par ordre d�croissant des lvl
    @param httpSession La session HTTP
    @return La page associ�e
*/
	@RequestMapping("/chatsLvlDOWN")
	public ModelAndView listeChatLvlDOWN(HttpSession httpSession){
		
		 
		ModelAndView modelAndView = listeChat(httpSession, "LVLDOWN","NA");
		return modelAndView;
		
	}
	
	
	/**
    Obtenir la page d�taill�e du chat idChat
    @param idChat IdChat recherch�
    @param httpSession La session HTTP
    @return La page associ�e
*/
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
		modelAndView.addObject("Admin",httpSession.getAttribute("Admin"));
		session.close();
		return modelAndView;
		
		
	}
	
	 /**
     ADMIN Afficher la liste des chats
    @param httpSession La session HTTP
    @return La page associ�e
*/
	 @RequestMapping("/AdminChats")
	 public ModelAndView affichePanneauAdminChats(HttpSession httpSession){
		 ModelAndView modelAndView = listeChat(httpSession, "-","admin");
		  return modelAndView;
	 }
	 
	 /**
     ADMIN Afficher la liste des chats nom UP
    @param httpSession La session HTTP
    @return La page associ�e
*/
	 @RequestMapping("/AdminChatsNomUP")
	 public ModelAndView affichePanneauAdminChatsUP(HttpSession httpSession){
		 ModelAndView modelAndView = listeChat(httpSession, "UP","admin");
		  return modelAndView;
	 }
	 /**
     ADMIN Afficher la liste des chats nom DOWN
    @param httpSession La session HTTP
    @return La page associ�e
*/
	 @RequestMapping("/AdminChatsNomDOWN")
	 public ModelAndView affichePanneauAdminChatsDOWN(HttpSession httpSession){
		 ModelAndView modelAndView = listeChat(httpSession, "DOWN","admin");
		  return modelAndView;
	 }
	 
	 /**
     ADMIN Afficher la liste des chats LVL UP
    @param httpSession La session HTTP
    @return La page associ�e
*/
	 @RequestMapping("/AdminChatsLvlUP")
	 public ModelAndView affichePanneauAdminChatsLVLUP(HttpSession httpSession){
		 ModelAndView modelAndView = listeChat(httpSession, "LVLUP","admin");
		  return modelAndView;
	 }
		
	 /**
     ADMIN Afficher la liste des chats nom DOWN
    @param httpSession La session HTTP
    @return La page associ�e
*/
	 @RequestMapping("/AdminChatsLvlDOWN")
	 public ModelAndView affichePanneauAdminChatsLVLDOWN(HttpSession httpSession){
		 ModelAndView modelAndView = listeChat(httpSession, "LVLDOWN","admin");
		  return modelAndView;
	 }
		
	  
		
	 /**
	    Rechercher un chat par son nom ou par son niveau
	    @param request Requ�te HTTP associ�e
	    @param httpSession La session HTTP
	    @return La page associ�e
	*/
	public ModelAndView recherche_Chat(HttpSession httpSession, HttpServletRequest request, String admin){
		
		ModelAndView modelAndView = null;
		if(admin.equals("NA")){
		    modelAndView = new ModelAndView("ChatListe");}
			else
			{
			modelAndView = new ModelAndView("AdminChats");}
			
		//Si le truc est vide :
		String RechChat = request.getParameter("RechChat");
		if (RechChat == "null"){
			if(admin.equals("NA")){
			    modelAndView = listeChat(httpSession);}
				else
				{
				modelAndView = affichePanneauAdminChats(httpSession);}

			modelAndView.addObject("error", "Il n'y a pas de chat associé à ce nom");
			return modelAndView;
		}
		
	    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
    	
    	
    	 try {
			// RECH LVL CHAT
			int lvlChat = Integer.parseInt(RechChat);
			Criteria criteria = session.createCriteria(Chat.class);
			criteria.add(Restrictions.eq("lvlChat", lvlChat));
			List<Chat> chats = (List<Chat>) criteria.list();
			
			modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
			modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
			modelAndView.addObject("listChat", chats);
			session.close();
			return modelAndView;
 	    
 	    } catch (NumberFormatException nfe) {
 	        // RECH NOM CHAT
 	       		
 	    	Query query = session.getNamedQuery("findCatbyName").setString("nom", RechChat);
				Chat chat = (Chat) query.uniqueResult();

				if (chat != null) {
					modelAndView = detailChat(chat.getIdChat(), httpSession);
					session.close();
					return modelAndView;
				}else{
					if(admin.equals("NA")){
					    modelAndView = listeChat(httpSession);}
						else
						{
						modelAndView = affichePanneauAdminChats(httpSession);}

					modelAndView.addObject("error", "Il n'y a pas de chat associé à ce nom");
					session.close();
					return modelAndView;
					
				}

 	    	}
 	    }
    	    	
    	
    	
    		
    	
	
	  
	/**
    Obtenir la liste des chats � un niveau donn�
    @param lvl Lvl du ou des chats recherch�s
    @param httpSession La session HTTP
    @return La page associ�e
*/
		
	@RequestMapping("chat/chatsRech")
		public ModelAndView recherche_Chat(HttpSession httpSession, HttpServletRequest request){
		ModelAndView modelAndView = recherche_Chat(httpSession, request,"NA");
		return modelAndView;
		
		
	}
	
	@RequestMapping("chat/AdminChatsRech")
       public ModelAndView Admin_Recherche_Chat(HttpSession httpSession, HttpServletRequest request){
		ModelAndView modelAndView = recherche_Chat(httpSession, request,"ADMIN");
		return modelAndView;
		
	}
	
/**POSSIBILITE DE FAIRE MIEUX */
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
			modelAndView.addObject("Admin",httpSession.getAttribute("Admin"));
			modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
			session.close();
			
			return modelAndView;
			
			
		}
	   
	   /**
	    Obtenir la page d'ajout de chat de l'admin
	    @param httpSession La session HTTP
	    @return La page associ�e
	*/
	   @RequestMapping("/AdminAjoutChat")
		public ModelAndView AdminAjoutChat(HttpSession httpSession){
			ModelAndView modelAndView = new ModelAndView("AdminAjoutChat");
		
			return modelAndView;
			
			
		}
	
	   @RequestMapping("/modifierChat")
		public ModelAndView AdminModifierChat(@ModelAttribute("chat") Chat chat, BindingResult result,HttpSession httpSession){
			ModelAndView modelAndView;
			if(result.hasErrors()){
				ModelAndView model1 = new ModelAndView("AdminChatsModeration");
				return model1;
			}	
			 
			
			Chat chatRetour;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			chatRetour = session.get(Chat.class, chat.getIdChat());
			chatRetour.setCaractereChat(chat.getCaractereChat());
			chatRetour.setCouleurChat(chat.getCouleurChat());
			chatRetour.setLvlChat(chat.getLvlChat());
			chatRetour.setMemorialChat(chat.getMemorialChat());
			chatRetour.setNomChat(chat.getNomChat());
			chatRetour.setNomJaponnaisChat(chat.getNomJaponnaisChat());
			session.save(chatRetour);

			session.getTransaction().commit();
			session.close();
			
			modelAndView = affichePanneauAdminChats(httpSession);
			modelAndView.addObject("Succes","La modification du chat a été fait avec succès.");
			return modelAndView;
			
			
		}
	   @RequestMapping("/supprimerChat")
		public ModelAndView AdminSupprimerChat(@ModelAttribute("chat") Chat chat, BindingResult result,HttpSession httpSession){
			ModelAndView modelAndView;
			if(result.hasErrors()){
				ModelAndView model1 = new ModelAndView("AdminChatsModeration");
				return model1;
			}	
			 
			
			Chat chatRetour;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			chatRetour = session.get(Chat.class, chat.getIdChat());
			session.delete(chatRetour);

			session.getTransaction().commit();
			session.close();
			
			modelAndView = affichePanneauAdminChats(httpSession);
			modelAndView.addObject("Succes","La suppression du chat a été fait avec succès.");
			return modelAndView;
			
			
		}
	
	
}
