package modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CategorieAstuce {
	@Id @GeneratedValue
	int idCategorieAstuce;
	String nomCategorieAstuce;
	String descriptionCategorieAstuce;

	public int getIdCategorieAstuce() {
		return idCategorieAstuce;
	}

	public void setIdCategorieAstuce(int idCategorieAstuce) {
		this.idCategorieAstuce = idCategorieAstuce;
	}

	public String getNomCategorieAstuce() {
		return nomCategorieAstuce;
	}

	public void setNomCategorieAstuce(String nomCategorieAstuce) {
		this.nomCategorieAstuce = nomCategorieAstuce;
	}

	public String getDescriptionCategorieAstuce() {
		return descriptionCategorieAstuce;
	}

	public void setDescriptionCategorieAstuce(String descriptionCategorieAstuce) {
		this.descriptionCategorieAstuce = descriptionCategorieAstuce;
	}

	public CategorieAstuce(){}
}
