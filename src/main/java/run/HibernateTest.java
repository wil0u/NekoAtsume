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
		chat.setNomJaponnaisChat("しろねこさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Smokey");
		chat.setCaractereChat("Hot and Cold");
		chat.setLvlChat(140);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Snowball.png");
		chat.setCouleurChat("Solid Black");
		chat.setMemorialChat("Soft brush");
		chat.setNomJaponnaisChat("くろねこさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Spots");
		chat.setCaractereChat("Joker");
		chat.setLvlChat(75);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Spots.png");
		chat.setCouleurChat("Black and white");
		chat.setMemorialChat("Glow Bracelet");
		chat.setNomJaponnaisChat("しろくろさん");
		session.save(chat);
		
		chat.setNomChat("Shadow");
		chat.setCaractereChat("Peculiar");
		chat.setLvlChat(50);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Shadow.png");
		chat.setCouleurChat("Solid Grey");
		chat.setMemorialChat("Cicada Skin");
		chat.setNomJaponnaisChat("はいいろさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Sunny");
		chat.setCaractereChat("Mischievous");
		chat.setLvlChat(120);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Sunny.png");
		chat.setCouleurChat("Turkish Calico");
		chat.setMemorialChat("Shiny Acom");
		chat.setNomJaponnaisChat("とびみけさん");
		session.save(chat);
		
		chat.setNomChat("Pumpkin");
		chat.setCaractereChat("Spacey");
		chat.setLvlChat(90);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Pumpkin.png");
		chat.setCouleurChat("Orange and White Tabby");
		chat.setMemorialChat("Aluminium Pins");
		chat.setNomJaponnaisChat("しろちゃとらさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Tabitha");
		chat.setCaractereChat("Leisurely");
		chat.setLvlChat(40);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Tabitha.png");
		chat.setCouleurChat("Calico Tabby");
		chat.setMemorialChat("Random Seeds");
		chat.setNomJaponnaisChat(" しまみけさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Fred");
		chat.setCaractereChat("Lady-Killer");
		chat.setLvlChat(150);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Fred.png");
		chat.setCouleurChat("Orange Tabby");
		chat.setMemorialChat("Seashell Earring");
		chat.setNomJaponnaisChat("ちゃとらさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Callie");
		chat.setCaractereChat("Spacey");
		chat.setLvlChat(50);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Callie.png");
		chat.setCouleurChat("Calico");
		chat.setMemorialChat("Damp Machbox");
		chat.setNomJaponnaisChat("みけさん");
		session.save(chat);
		
		
		chat = new Chat();
		chat.setNomChat("Bandit");
		chat.setCaractereChat("Wild at Heart");
		chat.setLvlChat(180);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Bandit.png");
		chat.setCouleurChat("Tortoiseshell");
		chat.setMemorialChat("Damp Machbox");
		chat.setNomJaponnaisChat("さびがらさん");
		session.save(chat);
		
		
		chat = new Chat();
		chat.setNomChat("Gabriel");
		chat.setCaractereChat("Diligent");
		chat.setLvlChat(150);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Gabriel.png");
		chat.setCouleurChat("Tuxedo");
		chat.setMemorialChat("Raffle Ticket");
		chat.setNomJaponnaisChat("はちわれさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Marshmallow");
		chat.setCaractereChat("Aloof");
		chat.setLvlChat(170);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Marshmellow.png");
		chat.setCouleurChat("Pointed");
		chat.setMemorialChat("Flower Bookmark");
		chat.setNomJaponnaisChat("ぽいんとさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Socks");
		chat.setCaractereChat("Adventurous");
		chat.setLvlChat(70);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Socks.png");
		chat.setCouleurChat("Black w/ White Mitts");
		chat.setMemorialChat("Small Mittens");
		chat.setNomJaponnaisChat("くつしたさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Lexy");
		chat.setCaractereChat("Expensive Tastes");
		chat.setLvlChat(100);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Lexy.png");
		chat.setCouleurChat("Grey & White");
		chat.setMemorialChat("Dirty Toy Animal");
		chat.setNomJaponnaisChat("はいしろさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Bolt");
		chat.setCaractereChat("Insatiable");
		chat.setLvlChat(140);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Bolt.png");
		chat.setCouleurChat("Brown Tabby");
		chat.setMemorialChat("Fish-stick Board");
		chat.setNomJaponnaisChat("きじとらさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Breezy");
		chat.setCaractereChat("Laid Back");
		chat.setLvlChat(30);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Breezy.png");
		chat.setCouleurChat("Brown & White Tabby");
		chat.setMemorialChat("Hourglass");
		chat.setNomJaponnaisChat("しろきじさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Misty");
		chat.setCaractereChat("Lazy");
		chat.setLvlChat(160);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Misty.png");
		chat.setCouleurChat("Mackerel Tabby");
		chat.setMemorialChat("Used Hand Warmer");
		chat.setNomJaponnaisChat("さばとらさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Pickles");
		chat.setCaractereChat("Faint-Hearted");
		chat.setLvlChat(0);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Pickles.png");
		chat.setCouleurChat("Gray & White Tabby");
		chat.setMemorialChat("Silent Bell");
		chat.setNomJaponnaisChat("しろさばさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Pepper");
		chat.setCaractereChat("Shy");
		chat.setLvlChat(165);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Pepper.png");
		chat.setCouleurChat("Black w/ Odd Eyes");
		chat.setMemorialChat("Toy Mirror");
		chat.setNomJaponnaisChat("おっどさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Pepper");
		chat.setCaractereChat("Shy");
		chat.setLvlChat(165);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Pepper.png");
		chat.setCouleurChat("Black w/ Odd Eyes");
		chat.setMemorialChat("Toy Mirror");
		chat.setNomJaponnaisChat("おっどさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Patches");
		chat.setCaractereChat("Jealous");
		chat.setLvlChat(80);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Patches.png");
		chat.setCouleurChat("Orange Patches");
		chat.setMemorialChat("Colored Candles");
		chat.setNomJaponnaisChat("ぶちさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Gozer");
		chat.setCaractereChat("Sore Loser");
		chat.setLvlChat(155);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Gozer.png");
		chat.setCouleurChat("Tortoiseshell Tabby");
		chat.setMemorialChat("Scuffed Dime");
		chat.setNomJaponnaisChat("とーびーさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Cocoa");
		chat.setCaractereChat("Indecisive");
		chat.setLvlChat(45);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Cocoa.png");
		chat.setCouleurChat("Brown Tuxedo");
		chat.setMemorialChat("Dice");
		chat.setNomJaponnaisChat("ちゃはちさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Princess");
		chat.setCaractereChat("Ditzy");
		chat.setLvlChat(125);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Princess.png");
		chat.setCouleurChat("Striped Torbie");
		chat.setMemorialChat("Bird Feather");
		chat.setNomJaponnaisChat("むぎわらさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Ginger");
		chat.setCaractereChat("Bashful");
		chat.setLvlChat(60);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Ginger.png");
		chat.setCouleurChat("Red w/ White Mitts");
		chat.setMemorialChat("Clean Handkerchief");
		chat.setNomJaponnaisChat("あかげさん ");
		session.save(chat);
		
		
		chat = new Chat();
		chat.setNomChat("Peaches");
		chat.setCaractereChat("Capricious");
		chat.setLvlChat(45);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Peaches.png");
		chat.setCouleurChat("Tan & Orange");
		chat.setMemorialChat("Bendy Straw");
		chat.setNomJaponnaisChat("くリーむさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Spud");
		chat.setCaractereChat("Cautious");
		chat.setLvlChat(80);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Spud.png");
		chat.setCouleurChat("Red Tortoiseshell");
		chat.setMemorialChat("Eyeglass Lens");
		chat.setNomJaponnaisChat("あかさびさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Mack");
		chat.setCaractereChat("Determined");
		chat.setLvlChat(130);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Mack.png");
		chat.setCouleurChat("White Mackerel");
		chat.setMemorialChat("Child’s Wristband");
		chat.setNomJaponnaisChat("しろとらさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Speckles");
		chat.setCaractereChat("Lonely");
		chat.setLvlChat(40);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Speckles.png");
		chat.setCouleurChat("Black Patches");
		chat.setMemorialChat("Damaged Spoon");
		chat.setNomJaponnaisChat("くろぶちさん ");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Willie");
		chat.setCaractereChat("Crafty");
		chat.setLvlChat(75);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Willie.png");
		chat.setCouleurChat("Black Tabby");
		chat.setMemorialChat("Worn Postcard");
		chat.setNomJaponnaisChat("くろとらさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Rascal");
		chat.setCaractereChat("Selfish");
		chat.setLvlChat(140);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Rascal.png");
		chat.setCouleurChat("Grey Tuxedo");
		chat.setMemorialChat("Warped Container");
		chat.setNomJaponnaisChat("はいはちさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Dottie");
		chat.setCaractereChat("Friendly");
		chat.setLvlChat(195);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Dottie.png");
		chat.setCouleurChat("White Calico");
		chat.setMemorialChat("Bottle Cap");
		chat.setNomJaponnaisChat("しろみけさん");
		session.save(chat);

		chat = new Chat();
		chat.setNomChat("Spooky");
		chat.setCaractereChat("Reserved");
		chat.setLvlChat(35);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Spooky.png");
		chat.setCouleurChat("Grey Tortoiseshell");
		chat.setMemorialChat("Gift Wrap Ribbon");
		chat.setNomJaponnaisChat("はいさびさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Apricot");
		chat.setCaractereChat("Slacker");
		chat.setLvlChat(10);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Apricot.png");
		chat.setCouleurChat("Tan & Orange Tabby");
		chat.setMemorialChat("Non référencé");
		chat.setNomJaponnaisChat("Non référencé");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Ganache");
		chat.setCaractereChat("Pragmatic");
		chat.setLvlChat(90);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Ganache.png");
		chat.setCouleurChat("Chocolate");
		chat.setMemorialChat("Non référencé");
		chat.setNomJaponnaisChat("Non référencé");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Joe DiMeowgio");
		chat.setCaractereChat("Team Player");
		chat.setLvlChat(28);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Joe_DiMeowgio.png");
		chat.setCouleurChat("Baseball Jersey");
		chat.setMemorialChat("Signed Baseball");
		chat.setNomJaponnaisChat("たてじまさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Senor Don Gato");
		chat.setCaractereChat("Scheming");
		chat.setLvlChat(30);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Senor_don_gato.png");
		chat.setCouleurChat("Mustachioed");
		chat.setMemorialChat("Feathered Hat");
		chat.setNomJaponnaisChat("ながぐつさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Xerxes IX");
		chat.setCaractereChat("Regal");
		chat.setLvlChat(70);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Xerxes.png");
		chat.setCouleurChat("Persian");
		chat.setMemorialChat("Pretty Stones");
		chat.setNomJaponnaisChat("ぷりんすさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Chairman Meow");
		chat.setCaractereChat("Boorish");
		chat.setLvlChat(111);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Chair.png");
		chat.setCouleurChat("Camouflage");
		chat.setMemorialChat("Dog Tags");
		chat.setNomJaponnaisChat("なべねこさん");
		session.save(chat);
		
		
		chat = new Chat();
		chat.setNomChat("Saint Purrtrick");
		chat.setCaractereChat("Awe-Inspiring");
		chat.setLvlChat(222);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Saint.png");
		chat.setCouleurChat("Ethereal");
		chat.setMemorialChat("Mysterious Stone");
		chat.setNomJaponnaisChat("ねこまたさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Saint Purrtrick");
		chat.setCaractereChat("Awe-Inspiring");
		chat.setLvlChat(222);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Saint.png");
		chat.setCouleurChat("Ethereal");
		chat.setMemorialChat("Mysterious Stone");
		chat.setNomJaponnaisChat("ねこまたさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Ms. Fortune");
		chat.setCaractereChat("Charismatic");
		chat.setLvlChat(20);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Ms_Fortune.png");
		chat.setCouleurChat("Gold");
		chat.setMemorialChat("Gold Coin");
		chat.setNomJaponnaisChat("こいこいさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Bob the Cat");
		chat.setCaractereChat("Outdoorsy");
		chat.setLvlChat(40);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Bob_the_Cat.png");
		chat.setCouleurChat("Adventurer");
		chat.setMemorialChat("Antique Compass");
		chat.setNomJaponnaisChat("やまねこさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Conductor Whiskers");
		chat.setCaractereChat("Vigilant");
		chat.setLvlChat(50);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Conductor.png");
		chat.setCouleurChat("Railway Uniform");
		chat.setMemorialChat("Hand-drawn ticket");
		chat.setNomJaponnaisChat("えきちょうさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Conductor Whiskers");
		chat.setCaractereChat("Vigilant");
		chat.setLvlChat(50);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Conductor.png");
		chat.setCouleurChat("Railway Uniform");
		chat.setMemorialChat("Hand-drawn ticket");
		chat.setNomJaponnaisChat("えきちょうさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Tubbs");
		chat.setCaractereChat("Finicky Feaster");
		chat.setLvlChat(130);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Tabb.png");
		chat.setCouleurChat("Fluffy");
		chat.setMemorialChat("Fish Jerky");
		chat.setNomJaponnaisChat("まんぞくさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Mr.Meowgi");
		chat.setCaractereChat("Mentoring");
		chat.setLvlChat(250);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Meowgi.png");
		chat.setCouleurChat("Ronin");
		chat.setMemorialChat("Old Wooden Charm");
		chat.setNomJaponnaisChat("おさむらいさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Lady Meow-Meow");
		chat.setCaractereChat("Diva");
		chat.setLvlChat(100);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Meow.png");
		chat.setCouleurChat("American Shorthair");
		chat.setMemorialChat("Novelty Sunglasses");
		chat.setNomJaponnaisChat("> あめしょさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Guy Furry");
		chat.setCaractereChat("Artisan");
		chat.setLvlChat(30);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Guy.png");
		chat.setCouleurChat("Apron");
		chat.setMemorialChat("Custom Rolling Pin");
		chat.setNomJaponnaisChat("びすとろさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Kathmandu");
		chat.setCaractereChat("Refined");
		chat.setLvlChat(150);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Kathmandu.png");
		chat.setCouleurChat("Hunting Coat");
		chat.setMemorialChat("Elegant Paint Brush");
		chat.setNomJaponnaisChat("まろまゆさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Ramses the Great");
		chat.setCaractereChat("Riddler");
		chat.setLvlChat(230);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Ramses.png");
		chat.setCouleurChat("Sphinx");
		chat.setMemorialChat("Elegant Staff");
		chat.setNomJaponnaisChat("すふいんさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Sassy Fran");
		chat.setCaractereChat("Enthusiastic");
		chat.setLvlChat(180);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Sassy_Fran.png");
		chat.setCouleurChat("Waitress");
		chat.setMemorialChat("Coffee Cup");
		chat.setNomJaponnaisChat("かふぇさん");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Billy the Kitten");
		chat.setCaractereChat("Nihilistic");
		chat.setLvlChat(250);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Billy-0.png");
		chat.setCouleurChat("Western Wear");
		chat.setMemorialChat("Lucky Coin");
		chat.setNomJaponnaisChat("きっどさん ");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Frosty");
		chat.setCaractereChat("Sensitive");
		chat.setLvlChat(5);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Frosty.png");
		chat.setCouleurChat("Straw Coat");
		chat.setMemorialChat("Non référencié");
		chat.setNomJaponnaisChat("Non référencié");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Sapphire");
		chat.setCaractereChat("Naive");
		chat.setLvlChat(20);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Sapphire.png");
		chat.setCouleurChat("Classic Siamese");
		chat.setMemorialChat("Non référencié");
		chat.setNomJaponnaisChat("Non référencié");
		session.save(chat);
		
		chat = new Chat();
		chat.setNomChat("Jeeves");
		chat.setCaractereChat("Nimble");
		chat.setLvlChat(210);
		chat.setCheminPhotoChat("/NekoAtsume/resources/imagesChat/Jeeves.png");
		chat.setCouleurChat("Neatly Parted");
		chat.setMemorialChat("Non référencié");
		chat.setNomJaponnaisChat("Non référencié");
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
