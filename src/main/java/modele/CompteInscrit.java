package modele;

public class CompteInscrit {
	String pseudo;
	String mdp;
	String cheminPhoto;
	String email;
	boolean banned;
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getCheminPhoto() {
		return cheminPhoto;
	}
	public void setCheminPhoto(String cheminPhoto) {
		this.cheminPhoto = cheminPhoto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isBanned() {
		return banned;
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	

}
