package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(
	name = "findCompteByEmail",
	query = "from CompteInscrit c where c.email = :email"
	)
})
@Entity
public class CompteInscrit {
	@Id @GeneratedValue
	int compteId;

	String email;
	@Column(unique=true)
	String pseudo;
	String mdp;
	String cheminPhoto;
	boolean banned;
	public int getCompteId() {
		return compteId;
	}
	public void setCompteId(int compteId) {
		this.compteId = compteId;
	}
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
	public CompteInscrit() {
		// TODO Auto-generated constructor stub
	}
	
	

	
}
