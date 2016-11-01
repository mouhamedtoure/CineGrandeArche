package fr.demos.poe.projet.librairie.metier;

public class StockException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Article article;
	int stockRestant;

	public StockException(Article article, Integer stockRestant, String message) {

		super(message);
		this.article = article;
		this.stockRestant = stockRestant;

	}

}