package modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(
		{
	@NamedQuery(
	name = "findCatbyName",
	query = "from Chat c where c.nomChat = :nom"
	),
	
@NamedQuery(
	name = "findCatbyLvl",
	query = "from Chat c where c.lvlChat = :lvl"
	)
}
		)

@Entity
public class Chat {
	// CLASSE DE CHAT 
	@Id @GeneratedValue
	int idChat;
	String nomChat;
	String cheminPhotoChat;
	String couleurChat;
	String caractereChat;
	String nomJaponnaisChat;
	String memorialChat;
	int lvlChat;
	public int getLvlChat() {
		return lvlChat;
	}
	public void setLvlChat(int lvlChat) {
		this.lvlChat = lvlChat;
	}
	public String getNomChat() {
		return nomChat;
	}
	public int getIdChat() {
		return idChat;
	}
	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}
	public String getMemorialChat() {
		return memorialChat;
	}
	public void setMemorialChat(String memorialChat) {
		this.memorialChat = memorialChat;
	}
	public void setNomChat(String nomChat) {
		this.nomChat = nomChat;
	}
	public String getCheminPhotoChat() {
		return cheminPhotoChat;
	}
	public void setCheminPhotoChat(String cheminPhotoChat) {
		this.cheminPhotoChat = cheminPhotoChat;
	}
	public String getCouleurChat() {
		return couleurChat;
	}
	public void setCouleurChat(String couleurChat) {
		this.couleurChat = couleurChat;
	}
	public String getCaractereChat() {
		return caractereChat;
	}
	public void setCaractereChat(String caractereChat) {
		this.caractereChat = caractereChat;
	}
	public String getNomJaponnaisChat() {
		return nomJaponnaisChat;
	}
	public void setNomJaponnaisChat(String nomJaponnaisChat) {
		this.nomJaponnaisChat = nomJaponnaisChat;
	}

	public Chat(){}	
}
