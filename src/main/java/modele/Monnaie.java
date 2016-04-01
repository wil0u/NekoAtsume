package modele;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Monnaie {
	@Id 
	@GeneratedValue
	int idMonnaie;
	String nomMonnaie;
	String cheminPhotoMonnaie;
	public int getIdMonnaie() {
		return idMonnaie;
	}
	public void setIdMonnaie(int idMonnaie) {
		this.idMonnaie = idMonnaie;
	}
	public String getNomMonnaie() {
		return nomMonnaie;
	}
	public void setNomMonnaie(String nomMonnaie) {
		this.nomMonnaie = nomMonnaie;
	}
	public String getCheminPhotoMonnaie() {
		return cheminPhotoMonnaie;
	}
	public void setCheminPhotoMonnaie(String cheminPhotoMonnaie) {
		this.cheminPhotoMonnaie = cheminPhotoMonnaie;
	}
	public Monnaie(int idMonnaie, String nomMonnaie, String cheminPhotoMonnaie) {
		super();
		this.idMonnaie = idMonnaie;
		this.nomMonnaie = nomMonnaie;
		this.cheminPhotoMonnaie = cheminPhotoMonnaie;
	}
	public Monnaie(){}
	
}
