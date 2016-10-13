package fr.demos.poe.projet.librairie.metier;

public class lignePanier {
	
	Article article;
	int quantite;
	
	public lignePanier(Article article, int quantite){
		this.article=article;
		this.quantite=quantite;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
