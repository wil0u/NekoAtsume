package modele;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
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
	List<Objet> listObjet = new ArrayList<Objet>();
	@ManyToOne
	Chat chat;
	String titre;
	boolean publie;
	
	public boolean isPublie() {
		return publie;
	}
	public void setPublie(boolean publie) {
		this.publie = publie;
	}

	@Transient
	List<Integer> listObjetId = new ArrayList<Integer>();

	public List<Integer> getListObjetId() {
		return listObjetId;
	}
	public void setListObjetId(List<Integer> listObjetId) {
		this.listObjetId = listObjetId;
	}
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
	
	public List<Objet> getListObjet() {
		return listObjet;
	}
	public void setListObjet(List<Objet> listObjet) {
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
