package fr.demos.poe.projet.librairie.metier;

public class ArticleDivers extends Article {
	
	
	String type;

	public ArticleDivers(String ref, double prixHT, String nom, String image, Dematerialise demat, String type) {
		super(ref, prixHT, nom, image, demat);
		// TODO Auto-generated constructor stub
		
		this.type=type;
	}

	public ArticleDivers(String ref, double prixHT, String nom, String image, Materialise materiel,
			boolean neuf, String type) {
		super(ref, prixHT, nom, image, materiel, neuf);
		// TODO Auto-generated constructor stub
		
		this.type=type;
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
