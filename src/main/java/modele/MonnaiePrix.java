package modele;


//Classe qui va contenir Un type de monnaie (Exemple : Poisson d'argent) et un prix (Exemple : 325)

public class MonnaiePrix {
	Monnaie monnaie;
	int prix;
	public Monnaie getMonnaie() {
		return monnaie;
	}
	public void setMonnaie(Monnaie monnaie) {
		this.monnaie = monnaie;
	}
	public int getCout() {
		return prix;
	}
	public void setCout(int cout) {
		this.prix = cout;
	}
	
}
