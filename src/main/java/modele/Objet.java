package modele;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Objet {
	@Id 	@GeneratedValue(strategy=GenerationType.AUTO)
	int idObjet;
	String nomObjet;
	String cheminPhotoObjet;
	@OneToOne
	Monnaie monnaie;
	@javax.persistence.OrderBy("prix asc")
	int prix;
	
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	//MonnaiePrix mp;
	public int getIdObjet() {
		return idObjet;
	}
	public void setIdObjet(int idObjet) {
		this.idObjet = idObjet;
	}
	public String getNomObjet() {
		return nomObjet;
	}
	public void setNomObjet(String nomObjet) {
		this.nomObjet = nomObjet;
	}
	public String getCheminPhotoObjet() {
		return cheminPhotoObjet;
	}
	public void setCheminPhotoObjet(String cheminPhotoObjet) {
		this.cheminPhotoObjet = cheminPhotoObjet;
	}
	public Objet() {
		// TODO Auto-generated constructor stub
	}
	
	
}
