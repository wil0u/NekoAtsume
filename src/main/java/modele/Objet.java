package modele;

public class Objet {
	int idObjet;
	String nomObjet;
	String cheminPhotoObjet;
	MonnaiePrix mp;
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
	public MonnaiePrix getMp() {
		return mp;
	}
	public void setMp(MonnaiePrix mp) {
		this.mp = mp;
	}
	public Objet(int idObjet, String nomObjet, String cheminPhotoObjet,
			MonnaiePrix mp) {
		super();
		this.idObjet = idObjet;
		this.nomObjet = nomObjet;
		this.cheminPhotoObjet = cheminPhotoObjet;
		this.mp = mp;
	}
	
}
