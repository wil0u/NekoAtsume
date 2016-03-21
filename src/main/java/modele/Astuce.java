package modele;

import java.sql.Date;

public class Astuce {

	int idAstuce;
	Categorie categorie;
	String astuce;
	CompteInscrit Auteur;
	Date date;
	
	public int getIdAstuce() {
		return idAstuce;
	}
	public void setIdAstuce(int idAstuce) {
		this.idAstuce = idAstuce;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getAstuce() {
		return astuce;
	}
	public void setAstuce(String astuce) {
		this.astuce = astuce;
	}
	public CompteInscrit getAuteur() {
		return Auteur;
	}
	public void setAuteur(CompteInscrit auteur) {
		Auteur = auteur;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Astuce(int idAstuce, Categorie categorie, String astuce,
			CompteInscrit auteur, Date date) {
		super();
		this.idAstuce = idAstuce;
		this.categorie = categorie;
		this.astuce = astuce;
		Auteur = auteur;
		this.date = date;
	}
	
	
	

	
	// je suis une pomme de terre


}
