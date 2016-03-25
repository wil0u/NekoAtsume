package modele;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Astuce {

	// Jesus Fucking Christ
	@Id @GeneratedValue
	int idAstuce;
	@ManyToOne
	CategorieAstuce categorie;
	String astuce;
	@ManyToOne
	CompteInscrit Auteur;
	Date date;
	@ManyToMany
	Collection<Objet> listObjet = new ArrayList();
	@ManyToOne
	Chat chat;
	String titre;
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	public Collection<Objet> getListObjet() {
		return listObjet;
	}
	public void setListObjet(Collection<Objet> listObjet) {
		this.listObjet = listObjet;
	}
	public int getIdAstuce() {
		return idAstuce;
	}
	public void setIdAstuce(int idAstuce) {
		this.idAstuce = idAstuce;
	}
	public CategorieAstuce getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieAstuce categorie) {
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

	public Astuce() {
		// TODO Auto-generated constructor stub
	}
	
	// NBLBLBLLBLBLBL
	

	
	
	// je suis une pomme de terre


}
