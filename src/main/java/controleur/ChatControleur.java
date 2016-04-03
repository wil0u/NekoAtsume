package controleur;
 
import java.util.List;
 





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
@Path("/chatPost")
public class ChatControleur {
   
    @RequestMapping("/chats")
    public ModelAndView listeChat (HttpSession httpSession){
        ModelAndView modelAndView = listeChat(httpSession, "-","NA");
        return modelAndView;
    }
 
    /**
    Obtenir le classement chats ordonnï¿½ par le critï¿½re "TRI". Pas de critï¿½re =  la page sans tri
    @param httpSession La session HTTP
    @param tri Le critï¿½re de tri
    @param admin contient "admin" quand la requï¿½te vient d'une page admin
    @return La page associï¿½e
*/
        public ModelAndView listeChat(HttpSession httpSession, String tri, String admin){
        ModelAndView modelAndView = null;
        
        // vérifier si on demande une page admin ou pas
        if(admin.equals("NA")){
        modelAndView = new ModelAndView("ChatListe");}
        else
        {
        modelAndView = new ModelAndView("AdminChats");}
        
        
       // regarde le tri que l'on demande
        if(tri == null){
            tri="-";
        }
       // ouverture session
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Chat.class);
        List<Chat> chats = null ;
         
        
        // différentes recherches par critéria en fonction de ce que l'on souhaite
        if (tri.equals("UP")) 
        	chats = session.createCriteria(Chat.class).addOrder(Order.asc("nomChat")).list();
        else if (tri.equals("DOWN"))         
        	chats = session.createCriteria(Chat.class).addOrder(Order.desc("nomChat")).list();
        else if (tri.equals("LVLUP"))         
        	chats = session.createCriteria(Chat.class).addOrder(Order.asc("lvlChat")).list();
        else if (tri.equals("LVLDOWN"))      
        	chats = session.createCriteria(Chat.class).addOrder(Order.desc("lvlChat")).list();
        else
        	chats = (List<Chat>)criteria.list();
       
    
    // ajout des infos       
        modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
        modelAndView.addObject("listChat",chats);
        session.close();
        return modelAndView;
       
    }
   
    /**
    Obtenir le classement chats ordonnï¿½ par ordre croissant des noms
    @param httpSession La session HTTP
    @return La page associï¿½e
*/
    @RequestMapping("/chatsNomUP")
    public ModelAndView listeChatNomUP(HttpSession httpSession){
       
         
        ModelAndView modelAndView = listeChat(httpSession, "UP","NA");
        return modelAndView;
       
    }
   
    /**
    Obtenir le classement chats ordonnï¿½ par ordre dï¿½croissant des noms
    @param httpSession La session HTTP
    @return La page associï¿½e
*/
    @RequestMapping("/chatsNomDOWN")
    public ModelAndView listeChatNomDOWN(HttpSession httpSession){
       
         
        ModelAndView modelAndView = listeChat(httpSession, "DOWN","NA");
        return modelAndView;
    }
   
    /**
    Obtenir le classement chats ordonnï¿½ par ordre croissant des lvl
    @param httpSession La session HTTP
    @return La page associï¿½e
*/
    @RequestMapping("/chatsLvlUP")
    public ModelAndView listeChatLvlUP(HttpSession httpSession){
       
         
        ModelAndView modelAndView = listeChat(httpSession, "LVLUP","NA");
               
        return modelAndView;
       
    }
   
    /**
    Obtenir le classement chats ordonnï¿½ par ordre dï¿½croissant des lvl
    @param httpSession La session HTTP
    @return La page associï¿½e
*/
    @RequestMapping("/chatsLvlDOWN")
    public ModelAndView listeChatLvlDOWN(HttpSession httpSession){
       
         
        ModelAndView modelAndView = listeChat(httpSession, "LVLDOWN","NA");
        return modelAndView;
       
    }
   
   
    /**
    Obtenir la page dï¿½taillï¿½e du chat idChat
    @param idChat IdChat recherchï¿½
    @param httpSession La session HTTP
    @return La page associï¿½e
*/
    @RequestMapping("/chat/{idChat}")
    public ModelAndView detailChat(@PathVariable("idChat") int idChat,HttpSession httpSession){
    	//creation d'un Chat
        ModelAndView modelAndView = new ModelAndView("Chat");
        Chat chat = new Chat();
        
        // ouverture session
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        // recherche chat
        chat = session.get(Chat.class,idChat);
       
        // recherche par critère, recherche d'un chat par son nom
        Criteria criteria = session.createCriteria(Astuce.class);
        criteria.add(Restrictions.eq("chat",chat));
        
        //liste des astuces
        List<Astuce> astuces = (List<Astuce>)criteria.list();
        
        for (int i = 1 ; i < astuces.size(); i++){
            System.out.println("Astuce :"+astuces.get(i).getAstuce());}
        
        // ajout des infos 
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
    @return La page associï¿½e
*/
     @RequestMapping("/AdminChats")
     public ModelAndView affichePanneauAdminChats(HttpSession httpSession){
    	 if(httpSession.getAttribute("Admin")==null){
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
				return model1;
			}
         ModelAndView modelAndView = listeChat(httpSession, "-","admin");
          return modelAndView;
     }
     
     /**
     ADMIN Afficher la liste des chats nom UP
    @param httpSession La session HTTP
    @return La page associï¿½e
*/
     @RequestMapping("/AdminChatsNomUP")
     public ModelAndView affichePanneauAdminChatsUP(HttpSession httpSession){
    	 if(httpSession.getAttribute("Admin")==null){
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
				return model1;
			}
         ModelAndView modelAndView = listeChat(httpSession, "UP","admin");
          return modelAndView;
     }
     /**
     ADMIN Afficher la liste des chats nom DOWN
    @param httpSession La session HTTP
    @return La page associï¿½e
*/
     @RequestMapping("/AdminChatsNomDOWN")
     public ModelAndView affichePanneauAdminChatsDOWN(HttpSession httpSession){
    	 if(httpSession.getAttribute("Admin")==null){
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
				return model1;
			}
         ModelAndView modelAndView = listeChat(httpSession, "DOWN","admin");
          return modelAndView;
     }
     
     /**
     ADMIN Afficher la liste des chats LVL UP
    @param httpSession La session HTTP
    @return La page associï¿½e
*/
     @RequestMapping("/AdminChatsLvlUP")
     public ModelAndView affichePanneauAdminChatsLVLUP(HttpSession httpSession){
    	 if(httpSession.getAttribute("Admin")==null){
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
				return model1;
			}
         ModelAndView modelAndView = listeChat(httpSession, "LVLUP","admin");
          return modelAndView;
     }
       
     /**
     ADMIN Afficher la liste des chats nom DOWN
    @param httpSession La session HTTP
    @return La page associï¿½e
*/
     @RequestMapping("/AdminChatsLvlDOWN")
     public ModelAndView affichePanneauAdminChatsLVLDOWN(HttpSession httpSession){
    	 if(httpSession.getAttribute("Admin")==null){
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
				return model1;
			}
         ModelAndView modelAndView = listeChat(httpSession, "LVLDOWN","admin");
          return modelAndView;
     }
       
     
       
     /**
        Rechercher un chat par son nom ou par son niveau
        @param request Requï¿½te HTTP associï¿½e
        @param httpSession La session HTTP
        @return La page associï¿½e
    */
    public ModelAndView recherche_Chat(HttpSession httpSession, HttpServletRequest request, String admin){
       
    	// check si on demande une page admin ou pas
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
 
            modelAndView.addObject("error", "Il n'y a pas de chat associÃ© Ã  ce nom");
            return modelAndView;
        }
       
        // ouverture de session
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
       
       
       
         try {
            // RECH LVL CHAT
            int lvlChat = Integer.parseInt(RechChat);
            Criteria criteria = session.createCriteria(Chat.class);
            criteria.add(Restrictions.eq("lvlChat", lvlChat));
            List<Chat> chats = (List<Chat>) criteria.list();
            
           // ajout des infos
            modelAndView.addObject("email", httpSession.getAttribute("emailUser"));
            modelAndView.addObject("Admin", httpSession.getAttribute("Admin"));
            modelAndView.addObject("listChat", chats);
            session.close();
            return modelAndView;
       
        } catch (NumberFormatException nfe) {
            // RECH NOM CHAT
               
            Query query = session.getNamedQuery("findCatbyName").setString("nom", RechChat);
                Chat chat = (Chat) query.uniqueResult();
 
                // si le chat n'est pas null, on renvoie la page
                if (chat != null) {
                    modelAndView = detailChat(chat.getIdChat(), httpSession);
                    session.close();
                    return modelAndView;
                }else{// sinon on renvoie la page au normal ou à l'admin
                    if(admin.equals("NA")){
                        modelAndView = listeChat(httpSession);}
                        else
                        {
                        modelAndView = affichePanneauAdminChats(httpSession);}
 
                    modelAndView.addObject("error", "Il n'y a pas de chat associï¿½ ï¿½ ce nom");
                    session.close();
                    return modelAndView;
                   
                }
 
            }
        }
               
     
    /**
    Obtenir la liste des chats ï¿½ un niveau donnï¿½
    @param lvl Lvl du ou des chats recherchï¿½s
    @param httpSession La session HTTP
    @return La page associï¿½e
*/
       
    @RequestMapping("chat/chatsRech")
        public ModelAndView recherche_Chat(HttpSession httpSession, HttpServletRequest request){
        ModelAndView modelAndView = recherche_Chat(httpSession, request,"NA");
        return modelAndView;
       
       
    }
   
    /**
     * Enclenche la recherche administrateur
     *@param httpSession donne les info de l'utilisateur connecté
     *@param request donne la requête http
     *@return la page associée
     * */
    @RequestMapping("chat/AdminChatsRech")
       public ModelAndView Admin_Recherche_Chat(HttpSession httpSession, HttpServletRequest request){
        ModelAndView modelAndView = recherche_Chat(httpSession, request,"ADMIN");
        return modelAndView;
       
    }
   
     /**
      * affiche la page pour modifier un Chat
      * @param idChat id du chat concerné
      * @param httpSession donne les info de l'utilisateur connecté
      * */
       @RequestMapping("/chat/{idChat}/moderer")
        public ModelAndView AdminModererChat(@PathVariable("idChat") int idChat,HttpSession httpSession){
    	   
    	   // ondoit être admin pour voir la page
    	   if(httpSession.getAttribute("Admin")==null){
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
				return model1;
			}
    	   
            ModelAndView modelAndView = new ModelAndView("AdminChatsModeration");
            Chat chat = new Chat();
            
            //ouverture de session
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            chat = session.get(Chat.class,idChat);
            
           // criteria, recherche d'un chat par son nom
            Criteria criteria = session.createCriteria(Astuce.class);
            criteria.add(Restrictions.eq("chat",chat));
            List<Astuce> astuces = (List<Astuce>)criteria.list();
            
            for (int i = 1 ; i < astuces.size(); i++){
                System.out.println("Astuce :"+astuces.get(i).getAstuce());}
            
            // Ajout des infos
            modelAndView.addObject("Chat",chat);
            modelAndView.addObject("ListeAstuces",astuces);
            modelAndView.addObject("Admin",httpSession.getAttribute("Admin"));
            modelAndView.addObject("email",httpSession.getAttribute("emailUser"));
            session.close();
           
            return modelAndView;
           
           
        }
       
       /**
        * Permet à l'admin d'ajouter un chat
        * @param httpSession donne les info de l'utilisateur connecté
        * */
	   @RequestMapping("/AdminAjoutChat")
		public ModelAndView AdminAjoutChat(HttpSession httpSession){
		   if(httpSession.getAttribute("Admin")==null){
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
				return model1;
			}
			ModelAndView modelAndView = new ModelAndView("AdminAjoutChat");
		
			return modelAndView;
			
			
		}
	
	   /**
	    * Modifier un chat (admin)
	    * @param chat Chat à modifier
	    * @param result permet de gérer les erreurs de modelattribute
	    * @param httpSession donne les info de l'utilisateur connecté
	    * */
	   @RequestMapping("/modifierChat")
		public ModelAndView AdminModifierChat(@ModelAttribute("chat") Chat chat, BindingResult result,HttpSession httpSession){
		   
		   // regarde si c'est un admin
		   if(httpSession.getAttribute("Admin")==null){
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
				return model1;
			}
			ModelAndView modelAndView;
			
			//les erreurs viennent de l'introduction de lettres dans le lvl
			if(result.hasErrors()){
				ModelAndView model1;
				model1 = affichePanneauAdminChats(httpSession);
				model1.addObject("error","La modification a échouée. (Le lv chat. ne doit contenir que des chiffres)");
				return model1;
			}	
			 
			
			Chat chatRetour;
			
			//ouverture de session
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//recherche d'un chat par son id
			chatRetour = session.get(Chat.class, chat.getIdChat());
			
			//modifications
			chatRetour.setCaractereChat(chat.getCaractereChat());
			chatRetour.setCouleurChat(chat.getCouleurChat());
			chatRetour.setLvlChat(chat.getLvlChat());
			chatRetour.setMemorialChat(chat.getMemorialChat());
			chatRetour.setNomChat(chat.getNomChat());
			chatRetour.setNomJaponnaisChat(chat.getNomJaponnaisChat());
			
			//sauvegarde des modifs
			session.save(chatRetour);
			session.getTransaction().commit();
			session.close();
			
			modelAndView = affichePanneauAdminChats(httpSession);
			modelAndView.addObject("Succes","La modification du chat a Ã©tÃ© fait avec succÃ¨s.");
			return modelAndView;
			
			
		}
	
	 
	   /** Permet de supprimer un chat
	    * @param idChat IdChat concerné par la suppression
	    * @param httpSession donne les info de l'utilisateur connecté
	    * */
	   @RequestMapping(value="/chat/{idChat}/supprimer")
		public ModelAndView AdminSupprimerChat(@PathVariable("idChat") int idChat, HttpSession httpSession){
		  
		   if(httpSession.getAttribute("Admin")==null){
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
				return model1;
			}
		   
			ModelAndView modelAndView;
				
			Chat chatRetour;
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			chatRetour = session.get(Chat.class, idChat);
			
			session.delete(chatRetour);

			session.getTransaction().commit();
			session.close();
			
			modelAndView = affichePanneauAdminChats(httpSession);
			modelAndView.addObject("Succes","La suppression du chat a ï¿½tï¿½ fait avec succï¿½s.");
			return modelAndView;
		
			
			
		}
	   
	   /** Ajoute un chat
	    * @param chat chat créé par modelattribue
	    * @param httpSession donne les info de l'utilisateur connecté
	    * @param result permet de gérer les erreurs
	    * @param requête http
	    * */
	    @RequestMapping(value="/chat/AdminAjoutChat",method = RequestMethod.POST)
	       public ModelAndView AdminAjoutChat(@ModelAttribute("chat") Chat chat, HttpSession httpSession,BindingResult result,HttpServletRequest request){
	    	int lvlChat;
	    	if(httpSession.getAttribute("Admin")==null){
				ModelAndView model1 = new ModelAndView("ConnexionForm");
				model1.addObject("Info","Vous devez etre connecte en tant qu'admin !");
				return model1;
			}
	    	 ModelAndView modelAndView;
			if(result.hasErrors()){
				ModelAndView model1;
				model1 = affichePanneauAdminChats(httpSession);
				model1.addObject("Error","L'ajout a Ã©chouÃ©. (Le lv chat. ne doit contenir que des chiffres)");
				return model1;
			}
		    try {
		      lvlChat = Integer.parseInt(request.getParameter("levelChat"));
		     } catch (NumberFormatException ex) {
		    	 ModelAndView model1;
					model1 = affichePanneauAdminChats(httpSession);
					model1.addObject("Error","L'ajout a Ã©chouÃ©. (Le lv chat. ne doit contenir que des chiffres)");
					return model1;
		     }
		
	       
	    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			chat.setLvlChat(lvlChat);
	        session.save(chat);
			session.getTransaction().commit();
			modelAndView = affichePanneauAdminChats(httpSession);
			modelAndView.addObject("Succes","L'ajout du chat a Ã©tÃ© fait avec succÃ¨s.");
			return modelAndView;
	       
	    }

	  

}
