package modele;

public class Categorie {
	int idCategorie;
	String nomCategorie;
	String descriptionCategorie;
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescriptionCategorie() {
		return descriptionCategorie;
	}
	public void setDescriptionCategorie(String descriptionCategorie) {
		this.descriptionCategorie = descriptionCategorie;
	}
	public Categorie(int idCategorie, String nomCategorie,
			String descriptionCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.descriptionCategorie = descriptionCategorie;
	}
	
	
}
