package run;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modele.Astuce;
import modele.Categorie;
import modele.Chat;
import modele.CompteAdmin;
import modele.CompteInscrit;
import modele.Monnaie;
import modele.Objet;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chat chat = new Chat();
		chat.setNomChat("salut");
		chat.setCouleurChat("yo");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(chat);
		session.getTransaction().commit();
		session.close();
		chat = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		chat = (Chat) session.get(Chat.class, 1);
		System.out.println("La couleur du chat est : "+chat.getCouleurChat());
		session.close();
		
		
		
		Categorie c = new Categorie();
		c.setNomCategorie("Général");
		Objet obj1 = new Objet();
		obj1.setNomObjet("Ballon de foot");
		Objet obj2 = new Objet();
		obj2.setNomObjet("Ballon de basket");
		
		Collection<Objet> listObjet = new ArrayList<Objet>();
		listObjet.add(obj1);
		listObjet.add(obj2);
		
		CompteInscrit ci = new CompteInscrit();
		ci.setPseudo("beep");
		ci.setMdp("xDdeLol");
		Astuce as = new Astuce();
		as.setAstuce("Snowball vient facilement avec un ballon de foot et un ballon de basket");
		as.setListObjet(listObjet);
		as.setAuteur(ci);
		as.setCategorie(c);
		
		CompteAdmin ca = new CompteAdmin();
		ca.setEmail("willeme.verdeaux@gmail.com");
		ca.setPseudo("wil0u");
		ca.setMdp("coucou");
		
		Astuce as2 = new Astuce();
		as2.setAuteur(ci);
		as2.setCategorie(c);
		as2.setAstuce("Jean michel le chat vient facilement avec un ballon de foot et un ballon de basket lol c'est pas énorme ça ? ");
		as2.setListObjet(listObjet);
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.save(obj1);
		session.save(obj2);
		session.save(ci);
		session.save(as);
		session.save(as2);
		session.save(ca);
		session.getTransaction().commit();
		session.close();
		
	}

}
