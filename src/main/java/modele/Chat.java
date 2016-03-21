package modele;

public class Chat {
	
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
	public Chat(String nomChat, String cheminPhotoChat, String couleurChat,
			String caractereChat, String nomJaponnaisChat, String memorialChat) {
		super();
		this.nomChat = nomChat;
		this.cheminPhotoChat = cheminPhotoChat;
		this.couleurChat = couleurChat;
		this.caractereChat = caractereChat;
		this.nomJaponnaisChat = nomJaponnaisChat;
		this.memorialChat = memorialChat;
	}
	
	
}
