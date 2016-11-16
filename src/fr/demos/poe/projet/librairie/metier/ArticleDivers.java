package fr.demos.poe.projet.librairie.metier;

public class ArticleDivers extends Article {
	
	
	private String type;
	private String caracteristique;

	public ArticleDivers(String ref, double prixHT, String nom, String image, Etat etat, Integer stock, String type, String caracteristique) {
		super(ref, prixHT, nom, image, etat, stock);
		
		this.type=type;
		this.caracteristique=caracteristique;
	
	}
	

	public ArticleDivers(String ref, double prixHT, String nom, String image, String format, String url, String type, String caracteristique) {
		super(ref, prixHT, nom, image, format, url);
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
