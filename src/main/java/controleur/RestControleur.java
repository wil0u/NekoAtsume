package controleur;

import java.util.List;

import modele.Chat;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControleur {
    @RequestMapping(value = "/restChats", method = RequestMethod.GET)
    public ResponseEntity<List<Chat>> listAllUsers() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Chat.class);
        List<Chat> chats =  (List<Chat>)criteria.list();
         
        if(chats.isEmpty()){
            return new ResponseEntity<List<Chat>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Chat>>(chats, HttpStatus.OK);
    }
 

}
