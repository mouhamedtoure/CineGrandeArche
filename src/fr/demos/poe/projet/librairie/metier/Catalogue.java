package fr.demos.poe.projet.librairie.metier;

import java.util.ArrayList;

public class Catalogue {

	private Article article;
	private ArticleDivers divers;
	private ArrayList<LigneCatalogue> lignesCatalogue;

	public Catalogue() {

		this.lignesCatalogue= new ArrayList<LigneCatalogue>();
	}

	
	public void ajouter(Article a, int stock){
		
		LigneCatalogue lc= new LigneCatalogue(a, stock);
		this.lignesCatalogue.add(lc);
		
		
	}
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public ArticleDivers getDivers() {
		return divers;
	}

	public void setDivers(ArticleDivers divers) {
		this.divers = divers;
	}

	public ArrayList<LigneCatalogue> getLignesCatalogue() {
		return lignesCatalogue;
	}

	public void setLignesCatalogue(ArrayList<LigneCatalogue> lignesCatalogue) {
		this.lignesCatalogue = lignesCatalogue;
	}

}
