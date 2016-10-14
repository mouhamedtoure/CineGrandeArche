package fr.demos.poe.projet.librairie.metier;

public class StockException extends Exception {
	
	Article article;
	int stockRestant;
	public StockException(Article article,Integer stockRestant, String message ){
		
		super(message);
		this.article=article;
		this.stockRestant=stockRestant;
		
	}

	
	
}
