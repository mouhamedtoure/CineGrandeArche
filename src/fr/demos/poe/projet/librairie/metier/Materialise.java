package fr.demos.poe.projet.librairie.metier;

public class Materialise {

	private Integer stock;
	private double delai;
	
	public Materialise(Integer stock, double delaiLivraison) {
		// TODO Auto-generated constructor stub
	
		this.stock=stock;
		this.delai=delaiLivraison;
		
	}





	public Materialise(Integer stock) {
		super();
		this.stock = stock;
	}

	public double getDelai() {
		return delai;
	}

	public void setDelai(double delai) {
		this.delai = delai;
	}





	public Integer getStock() {
		return stock;
	}





	public void setStock(Integer stock) {
		this.stock = stock;
	}





	@Override
	public String toString() {
		return "Materialise [stock=" + stock + ", delai=" + delai + "]";
	}


	
	
	
}
