package fr.demos.poe.projet.librairie.metier;

public class ArticleDivers extends Article {
	
	
	private String type;
	private String caracteristique;

	
	// Constructeur d'un article divers materialise 
	
	public ArticleDivers(String ref, double prixHT, String nom, String description, String image, Etat etat, int stock, double delaiLivraison, String type, String caracteristique) {
		super(ref, prixHT, nom, description, image, etat, stock, delaiLivraison);
		
		this.type=type;
		this.caracteristique=caracteristique;
	
	}
	
	// Constructeur d'un article divers dematerialise
	
	public ArticleDivers(String ref, double prixHT, String nom, String description, String image, String format, String url, String type, String caracteristique) {
		super(ref, prixHT, nom, description, image, format, url);
		this.type=type;
		this.caracteristique=caracteristique;
	
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}

	

}
