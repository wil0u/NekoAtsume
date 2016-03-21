package modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	public String getNomChat() {
		return nomChat;
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
