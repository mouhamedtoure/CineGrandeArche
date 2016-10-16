package fr.demos.poe.projet.librairie.metier;

import java.util.ArrayList;

public class Catalogue {

	private Article article;
	private ArticleDivers divers;
	private ArrayList<LigneCatalogue> lignesCatalogue;

	public Catalogue(Article article) {

		super();

		this.article = article;

	}

	public Catalogue(ArticleDivers divers) {

		super();
		this.divers = divers;

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
