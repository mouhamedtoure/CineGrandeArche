package fr.demos.poe.projet.librairie.metier;

public class ArticleDivers extends Article {
	
	
	String type;

	public ArticleDivers(String ref, double prixHT, String nom, Etat etat, Integer stock, String type) {
		super(ref, prixHT, nom, etat, stock);
		
		this.type=type;
	
	}

	public ArticleDivers(String ref, double prixHT, String nom, Integer stock, String type) {
		super(ref, prixHT, nom, stock);
		this.type=type;
	
	}

	public ArticleDivers(String ref, double prixHT, String nom, String format, String url, String type) {
		super(ref, prixHT, nom, format, url);
		this.type=type;
	
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
