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
import modele.CategorieAstuce;
import modele.CategorieObjet;
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
		
		CategorieObjet categorieObjet = new CategorieObjet();
		categorieObjet.setNomCategorieObjet("Balls");
		session.save(categorieObjet);
		
		CategorieObjet categorieObjet2 = new CategorieObjet();
		categorieObjet2.setNomCategorieObjet("Boxes");
		session.save(categorieObjet2);
		
		CategorieObjet categorieObjet3 = new CategorieObjet();
		categorieObjet3.setNomCategorieObjet("Beds");
		session.save(categorieObjet3);
		
		CategorieObjet categorieObjet4 = new CategorieObjet();
		categorieObjet4.setNomCategorieObjet("Furniture");
		session.save(categorieObjet4);
		
		CategorieObjet categorieObjet5 = new CategorieObjet();
		categorieObjet5.setNomCategorieObjet("Tunnels");
		session.save(categorieObjet5);
		
		CategorieObjet categorieObjet6 = new CategorieObjet();
		categorieObjet6.setNomCategorieObjet("Toys");
		session.save(categorieObjet6);
		
		CategorieObjet categorieObjet7 = new CategorieObjet();
		categorieObjet7.setNomCategorieObjet("Heating");
		session.save(categorieObjet7);		
		
		CategorieObjet categorieObjet8 = new CategorieObjet();
		categorieObjet8.setNomCategorieObjet("Bags/Hiding");
		session.save(categorieObjet8);
		
		CategorieObjet categorieObjet9 = new CategorieObjet();
		categorieObjet9.setNomCategorieObjet("Scratching");
		session.save(categorieObjet9);
		
		CategorieObjet categorieObjet10 = new CategorieObjet();
		categorieObjet10.setNomCategorieObjet("Baskets");
		session.save(categorieObjet10);
		
		CategorieObjet categorieObjet11 = new CategorieObjet();
		categorieObjet11.setNomCategorieObjet("Food");
		session.save(categorieObjet11);
		
		Monnaie monnaie1 = new Monnaie();
		monnaie1.setNomMonnaie("Poisson d'argent");
		monnaie1.setCheminPhotoMonnaie("/NekoAtsume/resources/imagesObjet/Argent.png");
		session.save(monnaie1);
		
		Monnaie monnaie2 = new Monnaie();
		monnaie2.setNomMonnaie("Poisson d'or");
		monnaie2.setCheminPhotoMonnaie("/NekoAtsume/resources/imagesObjet/Or.png");
		session.save(monnaie2);
		
		
		Objet objet = new Objet();
		objet.setNomObjet("Baseball");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Baseball.png");
		objet.setPrix(90);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Rubber Ball Yellow");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Rubber_Ball_Yellow.png");
		objet.setPrix(60);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Rubber Ball Red");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Rubber_Ball_Red.png");
		objet.setPrix(60);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Rubber Ball Blue");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Rubber_Ball_Blue.png");
		objet.setPrix(60);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Watermelon Ball");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Watermelon_Ball.png");
		objet.setPrix(80);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Ping Pong Ball");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Ping_Pong_Ball.png");
		objet.setPrix(50);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Soccer Ball");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Soccer_Ball.png");
		objet.setPrix(10);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Stress Reliever");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Stress_Reliever.png");
		objet.setPrix(80);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Ball of Yarn");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Ball_of_Yarn.png");
		objet.setPrix(120);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Toy Capsule");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Toy_Capsule.png");
		objet.setPrix(30);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Temari Ball");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Temari_Ball.png");
		objet.setPrix(25);
		objet.setCategorieObjet(categorieObjet);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cake Box");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cake_Box.png");
		objet.setPrix(40);
		objet.setCategorieObjet(categorieObjet2);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Gift Box");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Gift_Box.png");
		objet.setPrix(5);
		objet.setCategorieObjet(categorieObjet2);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Shopping Box Small");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Shopping_Box_Small.png");
		objet.setPrix(70);
		objet.setCategorieObjet(categorieObjet2);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Shopping Box Large");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Shopping_Box_Large.png");
		objet.setPrix(100);
		objet.setCategorieObjet(categorieObjet2);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cardboard Truck");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cardboard_Truck.png");
		objet.setPrix(15);
		objet.setCategorieObjet(categorieObjet2);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cardboard House");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cardboard_House.png");
		objet.setPrix(40);
		objet.setCategorieObjet(categorieObjet2);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cardboard Café");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cardboard_Cafe.png");
		objet.setPrix(50);
		objet.setCategorieObjet(categorieObjet2);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cardboard Choo-Choo");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cardboard_Choo_Choo.png");
		objet.setPrix(60);
		objet.setCategorieObjet(categorieObjet2);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Pillow Purple");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Pillow_Purple.png");
		objet.setPrix(120);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Pillow Yellow");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Pillow_Yellow.png");
		objet.setPrix(120);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Pillow Green");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Pillow_Green.png");
		objet.setPrix(120);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Silk Crepe Pillow");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Silk_Crepe_Pillow.png");
		objet.setPrix(20);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Sakura Pillow");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Sakura_Pillow.png");
		objet.setPrix(220);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Maple Pillow");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Maple_Pillow.png");
		objet.setPrix(220);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Snowy Pillow");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Snowy_Pillow.png");
		objet.setPrix(220);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cushion Beige");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cushion_Beige.png");
		objet.setPrix(100);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cushion Pink");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cushion_Pink.png");
		objet.setPrix(100);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cushion Brown");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cushion_Brown.png");
		objet.setPrix(100);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cushion Green");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cushion_Green.png");
		objet.setPrix(100);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Lucky Cushion");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Lucky_Cushion.png");
		objet.setPrix(120);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);

		objet = new Objet();
		objet.setNomObjet("Fluffy Bed White");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Fluffy_Bed_White.png");
		objet.setPrix(160);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Fluffy Bed Pink");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Fluffy_Bed_Pink.png");
		objet.setPrix(160);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Fluffy Bed Brown");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Fluffy_Bed_Brown.png");
		objet.setPrix(160);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Orange Cube");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Orange_Cube.png");
		objet.setPrix(320);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Navy-blue Cube");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Navy_blue_Cube.png");
		objet.setPrix(320);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Tiramisu Cube");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Tiramisu_Cube.png");
		objet.setPrix(28);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Dice Cube");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Dice_Cube.png");
		objet.setPrix(32);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Stump House");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Stump_House.png");
		objet.setPrix(400);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Thick Cooling Pad");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Thick_Cooling_Pad.png");
		objet.setPrix(130);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cool Aluminum Pad");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cool_Aluminum_Pad.png");
		objet.setPrix(150);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Marble Pad");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Marble_Pad.png");
		objet.setPrix(30);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Large Cooling Mat");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Large_Cooling_Mat.png");
		objet.setPrix(390);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Fluffy Cushion");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Fluffy_Cushion.png");
		objet.setPrix(170);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Sheep Cushion");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Sheep_Cushion.png");
		objet.setPrix(250);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Sakuramochi Cushion");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Sakuramochi_Cushion.png");
		objet.setPrix(12);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Burger Cushion");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Burger_Cushion.png");
		objet.setPrix(14);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Pancake Cushion");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Pancake_Cushion.png");
		objet.setPrix(15);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Head Space");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Head_Space.png");
		objet.setPrix(15);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Black Head Space");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Black_Head_Space.png");
		objet.setPrix(17);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Basket Case");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Basket_Case.png");
		objet.setPrix(380);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		

		objet = new Objet();
		objet.setNomObjet("Chestnut Cushion");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Chestnut_Cushion.png");
		objet.setPrix(320);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Zanzibar Cushion");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Zanzibar_Cushion.png");
		objet.setPrix(20);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Bean Bag");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Bean_Bag.png");
		objet.setPrix(10);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Giant Cushion");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Giant_Cushion.png");
		objet.setPrix(25);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Hammock Yellow");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Hammock_Yellow.png");
		objet.setPrix(210);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Hammock Pink");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Hammock_Pink.png");
		objet.setPrix(210);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Hammock Woven");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Hammock_Woven.png");
		objet.setPrix(220);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);

		objet = new Objet();
		objet.setNomObjet("Luxurious Hammock");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Luxurious_Hammock.png");
		objet.setPrix(35);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Tent Nature");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Tent_Nature.png");
		objet.setPrix(170);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Tent Modern Red");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Tent_Modern_Red.png");
		objet.setPrix(22);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Tent Blizzard");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Tent_Blizzard.png");
		objet.setPrix(190);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Tent Pyramid");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Tent_Pyramid.png");
		objet.setPrix(190);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Warm Sock");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Warm_Sock.png");
		objet.setPrix(110);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Pom-pom Sock");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Pom_pom_Sock.png");
		objet.setPrix(12);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Colorful Sock");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Colorful_Sock.png");
		objet.setPrix(15);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Arabesque Blanket");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Arabesque_Blanket.png");
		objet.setPrix(18);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cozy Blanket Red");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cozy_Blanket_Red.png");
		objet.setPrix(110);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cozy Blanket Yellow");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cozy_Blanket_Yellow.png");
		objet.setPrix(110);
		objet.setCategorieObjet(categorieObjet3);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Paper_Umbrella");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Paper_Umbrella.png");
		objet.setPrix(50);
		objet.setCategorieObjet(categorieObjet4);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Beach_Umbrella");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Beach_Umbrella.png");
		objet.setPrix(340);
		objet.setCategorieObjet(categorieObjet4);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Two-tier Cat Tree");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Two_tier_Cat_Tree.png");
		objet.setPrix(200);
		objet.setCategorieObjet(categorieObjet4);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Three-tier Cat Tree");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Three_tier_Cat_Tree.png");
		objet.setPrix(320);
		objet.setCategorieObjet(categorieObjet4);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cat Condo Complex");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cat_Condo_Complex.png");
		objet.setPrix(500);
		objet.setCategorieObjet(categorieObjet4);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cat Metropolis");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cat_Metropolis.png");
		objet.setPrix(50);
		objet.setCategorieObjet(categorieObjet4);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Art Deco Cat Tree");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Art_Deco_Cat_Tree.png");
		objet.setPrix(800);
		objet.setCategorieObjet(categorieObjet4);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Bureau with Pot");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Bureau_with_Pot.png");
		objet.setPrix(950);
		objet.setCategorieObjet(categorieObjet4);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Tunnel (I Piece)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Tunnel_I_Piece.png");
		objet.setPrix(160);
		objet.setCategorieObjet(categorieObjet5);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Tunnel (U Piece)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Tunnel_U_Piece.png");
		objet.setPrix(160);
		objet.setCategorieObjet(categorieObjet5);
		objet.setMonnaie(monnaie1);
		session.save(objet);

		objet = new Objet();
		objet.setNomObjet("Tunnel (T Piece)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Tunnel_T_Piece.png");
		objet.setPrix(200);
		objet.setCategorieObjet(categorieObjet5);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Tunnel (3D Piece)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Tunnel_3D_Piece.png");
		objet.setPrix(20);
		objet.setCategorieObjet(categorieObjet5);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Carp Tunnel");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Carp_Tunnel.png");
		objet.setPrix(18);
		objet.setCategorieObjet(categorieObjet5);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Fish-stick Tunnel");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Fish_stick_Tunnel.png");
		objet.setPrix(240);
		objet.setCategorieObjet(categorieObjet5);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cow Tunnel");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cow_Tunnel.png");
		objet.setPrix(300);
		objet.setCategorieObjet(categorieObjet5);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Doughnut Tunnel");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Doughnut_Tunnel.png");
		objet.setPrix(330);
		objet.setCategorieObjet(categorieObjet5);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Tail-thing Teaser");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Tail_thing_Teaser.png");
		objet.setPrix(80);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Wing-thing Teaser");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Wing_thing_Teaser.png");
		objet.setPrix(100);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Wild-thing Teaser");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Wild_thing_Teaser.png");
		objet.setPrix(100);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Zebra Grass Gadget");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Zebra_Grass_Gadget.png");
		objet.setPrix(90);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Fluff-thing Teaser");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Fluff_thing_Teaser.png");
		objet.setPrix(100);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Mister Mouse");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Mister_Mouse.png");
		objet.setPrix(140);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		

		objet = new Objet();
		objet.setNomObjet("Mister Dragonfly");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Mister_Dragonfly.png");
		objet.setPrix(120);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Kick Toy (Mouse)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Kick_Toy_Mouse.png");
		objet.setPrix(170);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Kick Toy (Fish)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Kick_Toy_Fish.png");
		objet.setPrix(170);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		

		objet = new Objet();
		objet.setNomObjet("Kick Toy (Bunny)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Kick_Toy_Bunny.png");
		objet.setPrix(170);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Kick Toy (Saury)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Kick_Toy_Saury.png");
		objet.setPrix(200);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		

		objet = new Objet();
		objet.setNomObjet("Busy Bee");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Busy_Bee.png");
		objet.setPrix(15);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Butterfly Swarm");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Butterfly_Swarm.png");
		objet.setPrix(12);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Twisty Rail");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Twisty_Rail.png");
		objet.setPrix(15);
		objet.setCategorieObjet(categorieObjet6);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Kotatsu");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Kotatsu.png");
		objet.setPrix(60);
		objet.setCategorieObjet(categorieObjet7);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Sunken Fireplace");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Sunken_Fireplace.png");
		objet.setPrix(70);
		objet.setCategorieObjet(categorieObjet7);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Hot-Water Bottle");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Hot_Water_Bottle.png");
		objet.setPrix(120);
		objet.setCategorieObjet(categorieObjet7);
		objet.setMonnaie(monnaie1);
		session.save(objet);

		objet = new Objet();
		objet.setNomObjet("Hot Mat (Small)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Hot_Mat_Small.png");
		objet.setPrix(240);
		objet.setCategorieObjet(categorieObjet7);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Hot Mat (Large)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Hot_Mat_Large.png");
		objet.setPrix(36);
		objet.setCategorieObjet(categorieObjet7);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Heating Stove");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Heating_Stove.png");
		objet.setPrix(600);
		objet.setCategorieObjet(categorieObjet7);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Panel Heater");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Panel_Heater.png");
		objet.setPrix(20);
		objet.setCategorieObjet(categorieObjet7);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Space Heater");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Space_Heater.png");
		objet.setPrix(32);
		objet.setCategorieObjet(categorieObjet7);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Pile of Leaves");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Pile_of_Leaves.png");
		objet.setPrix(400);
		objet.setCategorieObjet(categorieObjet8);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Paper Bag");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Paper_Bag.png");
		objet.setPrix(30);
		objet.setCategorieObjet(categorieObjet8);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Plastic Bag");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Plastic_Bag.png");
		objet.setPrix(10);
		objet.setCategorieObjet(categorieObjet8);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
	


	
		
		objet = new Objet();
		objet.setNomObjet("Scratching Board");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Scratching_Board.png");
		objet.setPrix(180);
		objet.setCategorieObjet(categorieObjet9);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Scratching Post");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Scratching_Post.png");
		objet.setPrix(240);
		objet.setCategorieObjet(categorieObjet9);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Scratching Log");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Scratching_Log.png");
		objet.setPrix(30);
		objet.setCategorieObjet(categorieObjet9);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Fruit Basket");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Fruit_Basket.png");
		objet.setPrix(80);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Earthenware Pot");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Earthenware_Pot.png");
		objet.setPrix(20);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Rice Kettle");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Rice_Kettle.png");
		objet.setPrix(27);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Lacquered Bowl");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Lacquered_Bowl.png");
		objet.setPrix(25);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Clay Pot");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Clay_Pot.png");
		objet.setPrix(15);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Pickling Pot");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Pickling_Pot.png");
		objet.setPrix(18);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Planter");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Planter.png");
		objet.setPrix(130);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		

		objet = new Objet();
		objet.setNomObjet("Bucket (Blue)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Bucket_Blue.png");
		objet.setPrix(60);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Bucket (Pink)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Bucket_Pink.png");
		objet.setPrix(60);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Snow Sled");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Snow_Sled.png");
		objet.setPrix(140);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Goldfish Bowl");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Goldfish_Bowl.png");
		objet.setPrix(10);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Glass Vase");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Glass_Vase.png");
		objet.setPrix(750);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Wood Pail");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Wood_Pail.png");
		objet.setPrix(340);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cowboy Hat");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cowboy_Hat.png");
		objet.setPrix(400);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cat Macaroon (Pink)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cat_Macaroon_Pink.png");
		objet.setPrix(210);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cat Macaroon (Green)");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cat_Macaroon_Green.png");
		objet.setPrix(210);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Cat Pancake");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cat_Pancake.png");
		objet.setPrix(24);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Cat Pancake");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Cat_Pancake.png");
		objet.setPrix(24);
		objet.setCategorieObjet(categorieObjet10);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Thrifty Bitz");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Thrifty_Bitz.png");
		objet.setPrix(0);
		objet.setCategorieObjet(categorieObjet11);
		session.save(objet);
		
		
		objet = new Objet();
		objet.setNomObjet("Frisky Bitz");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Frisky_Bitz.png");
		objet.setPrix(30);
		objet.setCategorieObjet(categorieObjet11);
		objet.setMonnaie(monnaie1);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Bonito Bitz");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Bonito_Bitz.png");
		objet.setPrix(7);
		objet.setCategorieObjet(categorieObjet11);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Ritzy Bitz");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Ritzy_Bitz.png");
		objet.setPrix(3);
		objet.setCategorieObjet(categorieObjet11);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Deluxe Tuna Bitz");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Deluxe_Tuna_Bitz.png");
		objet.setPrix(12);
		objet.setCategorieObjet(categorieObjet11);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		objet = new Objet();
		objet.setNomObjet("Sashimi");
		objet.setCheminPhotoObjet("/NekoAtsume/resources/imagesObjet/Sashimi.png");
		objet.setPrix(5);
		objet.setCategorieObjet(categorieObjet11);
		objet.setMonnaie(monnaie2);
		session.save(objet);
		
		CompteAdmin compteAdmin = new CompteAdmin();
		compteAdmin.setEmail("dieu@gmail.com");
		compteAdmin.setMdp("dieu");
		compteAdmin.setPseudo("dieu");
		session.save(compteAdmin);
		
		List<Objet> listObj = new ArrayList<Objet>();
		listObj.add(objet);
		listObj.add(objet);
		Astuce as = new Astuce();
		as.setListObjet(listObj);
		as.setAstuce("ccoucoucocu ocutestsfstsdsrt");
		as.setChat(chat);
		session.save(as);
		
		
		session.getTransaction().commit();
		session.close();

		
	}

}
