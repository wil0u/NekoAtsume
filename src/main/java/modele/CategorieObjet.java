package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class CategorieObjet {
	@Id @GeneratedValue
	int idCategorieObjet;
	@Column(unique=true)
	String nomCategorieObjet;
	String descriptionCategorie;
	
	public int getIdCategorieObjet() {
		return idCategorieObjet;
	}
	public void setIdCategorieObjet(int idCategorieObjet) {
		this.idCategorieObjet = idCategorieObjet;
	}
	public String getNomCategorieObjet() {
		return nomCategorieObjet;
	}
	public void setNomCategorieObjet(String nomCategorieObjet) {
		this.nomCategorieObjet = nomCategorieObjet;
	}
	public String getDescriptionCategorie() {
		return descriptionCategorie;
	}
	public void setDescriptionCategorie(String descriptionCategorie) {
		this.descriptionCategorie = descriptionCategorie;
	}
	public CategorieObjet(){}
}
