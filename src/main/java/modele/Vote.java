package modele;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Vote {
	@Id 
	@GeneratedValue
	int idVote;
	
	@ManyToOne
	Astuce astuce;
	@ManyToOne 
	CompteInscrit compte;
	String valeur;
	public Astuce getAstuce() {
		return astuce;
	}
	public void setAstuce(Astuce astuce) {
		this.astuce = astuce;
	}
	public CompteInscrit getCompte() {
		return compte;
	}
	public void setCompte(CompteInscrit compte) {
		this.compte = compte;
	}
	public int getIdVote() {
		return idVote;
	}
	public void setIdVote(int idVote) {
		this.idVote = idVote;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	
	
}
