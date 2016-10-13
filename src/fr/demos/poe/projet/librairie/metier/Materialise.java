package fr.demos.poe.projet.librairie.metier;

public class Materialise {

	private Etat etat;
	private Integer stock;
	private double delai;
	
	public Materialise(Etat etat, int stock,double delai ) {
		// TODO Auto-generated constructor stub
		
		this.etat=etat;
		this.stock=stock;
		this.delai=delai;
		
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getDelai() {
		return delai;
	}

	public void setDelai(double delai) {
		this.delai = delai;
	}

	@Override
	public String toString() {
		return "Materialise [etat=" + etat + ", stock=" + stock + ", delai=" + delai + "]";
	}

	
	
	
}
