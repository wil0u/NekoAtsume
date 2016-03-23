package run;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

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
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Chat chat = new Chat();
		
		chat.setNomChat("Snowball");
		chat.setCaractereChat("Mellow");
		chat.setLvlChat(80);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Snowball.png");
		chat.setCouleurChat("Solid White");
		chat.setMemorialChat("Flowered collar");
		chat.setNomJaponnaisChat("Pas encore supporté");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Smokey");
		chat.setCaractereChat("Hot and Cold");
		chat.setLvlChat(140);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Snowball.png");
		chat.setCouleurChat("Solid Black");
		chat.setMemorialChat("Soft brush");
		chat.setNomJaponnaisChat("Pas encore supporté");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Spots");
		chat.setCaractereChat("Joker");
		chat.setLvlChat(75);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Spots.png");
		chat.setCouleurChat("Black and white");
		chat.setMemorialChat("Glow Bracelet");
		chat.setNomJaponnaisChat("Pas encore supporté");
		session.save(chat);
		
		chat.setNomChat("Shadow");
		chat.setCaractereChat("Peculiar");
		chat.setLvlChat(50);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Shadow.png");
		chat.setCouleurChat("Solid Grey");
		chat.setMemorialChat("Cicada Skin");
		chat.setNomJaponnaisChat("Pas encore supporté");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Sunny");
		chat.setCaractereChat("Mischievous");
		chat.setLvlChat(120);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Sunny.png");
		chat.setCouleurChat("Turkish Calico");
		chat.setMemorialChat("Shiny Acom");
		chat.setNomJaponnaisChat("Pas encore supporté");
		session.save(chat);
		
		chat.setNomChat("Pumpkin");
		chat.setCaractereChat("Spacey");
		chat.setLvlChat(90);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Pumpkin.png");
		chat.setCouleurChat("Orange and White Tabby");
		chat.setMemorialChat("Aluminium Pins");
		chat.setNomJaponnaisChat("Pas encore supporté");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Tabitha");
		chat.setCaractereChat("Leisurely");
		chat.setLvlChat(40);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Tabitha.png");
		chat.setCouleurChat("Calico Tabby");
		chat.setMemorialChat("Random Seeds");
		chat.setNomJaponnaisChat("Pas encore supporté");
		session.save(chat);
		
		session.getTransaction().commit();
		session.close();

		
		
		
		Categorie c = new Categorie();
		c.setNomCategorie("Général");
		Objet obj1 = new Objet();
		obj1.setNomObjet("Ballon de foot");
		obj1.setPrix(15);
		Objet obj2 = new Objet();
		obj2.setNomObjet("Ballon de basket");
		obj2.setPrix(17);
		Objet obj3 = new Objet();
		obj3.setNomObjet("Ballon de foot");
		obj3.setPrix(8);
		Objet obj4 = new Objet();
		obj4.setNomObjet("Ballon de basket");
		obj4.setPrix(100);
		Objet obj5= new Objet();
		obj5.setNomObjet("Ballon de foot");
		obj5.setPrix(35);
		Objet obj6 = new Objet();
		obj6.setNomObjet("Ballon de basket");
		obj6.setPrix(19);
		
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
		as.setTitre("La fourberie de snowball !");
		as.setCategorie(c);
		as.setChat(chat);
		
		CompteAdmin ca = new CompteAdmin();
		ca.setEmail("willeme.verdeaux@gmail.com");
		ca.setPseudo("wil0u");
		ca.setMdp("coucou");
		
		Astuce as2 = new Astuce();
		as2.setAuteur(ci);
		as2.setCategorie(c);
		as2.setTitre("Attirer jean michel");
		as2.setAstuce("Jean michel le chat vient facilement avec un ballon de foot et un ballon de basket lol c'est pas énorme ça ? ");
		as2.setListObjet(listObjet);
		as2.setChat(chat);
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.save(obj1);
		session.save(obj2);
		session.save(obj3);
		session.save(obj4);
		session.save(obj5);
		session.save(obj6);
		session.save(ci);
		session.save(as);
		session.save(as2);
		session.save(ca);
		session.getTransaction().commit();
		session.close();
		
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		
		// POUR OPHELIE faire du order by reported
		Criteria criteria = session.createCriteria(Objet.class);
		criteria.addOrder(Order.asc("prix"));
		List<Objet> objets = (List<Objet>)criteria.list();
		for (int i = 0; i<objets.size();i++){
			System.out.println("Objet"+objets.get(i).getIdObjet()+" a pour prix : "+ objets.get(i).getPrix());
		}
		
	}

}
