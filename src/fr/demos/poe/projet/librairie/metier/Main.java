package fr.demos.poe.projet.librairie.metier;

public class Main {

	public Main() {
	
	}

	public static void main(String[] args) {

		Livre l1 = new Livre("123456", 10.99, "L'etranger", Etat.COMME_NEUF, 10, "Camus", "Hachette");
		Livre l2 = new Livre("234567", 15.99, "Madame Bovary", "pdf", "url de telechargement", "Flaubert", "Belin");

		Panier p1 = new Panier();

		try {

			p1.ajouterArticle(l1, 5);

		} catch (StockException e1) {

			System.out.println(e1.getMessage() + " ," + " Stock restant:" + e1.stockRestant);
		}

		try {

			p1.ajouterArticle(l2, 3);
		} catch (StockException e3) {
			System.out.println(e3.getMessage() + " ," + " Stock restant:" + e3.stockRestant);
		}

		System.out.println(p1);

		try {
			p1.modifierQuantite(l1, 10);

		} catch (QuantiteException qe1) {

			System.out.println(qe1.getMessage());

		}

		try {
			p1.modifierQuantite(l1, -10);

		} catch (QuantiteException qe1) {

			System.out.println(qe1.getMessage());

		}

		System.out.println(p1);
		p1.vider();
		System.out.println(p1);

	}

}
