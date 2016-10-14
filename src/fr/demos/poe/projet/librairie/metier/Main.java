package fr.demos.poe.projet.librairie.metier;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Livre l1 = new Livre("123456", 10.99, "L'etranger", Etat.COMME_NEUF, 10, "Camus", "Hachette");
		Livre l2 = new Livre("234567", 15.99, "Madame Bovary", "pdf", "url de telechargement", "Flaubert", "Belin");
		// System.out.println(l1);
		// System.out.println(l2);

		Panier p1 = new Panier();

		try {

			p1.ajouterArticle(l1, 4);

		} catch (StockException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage() + " ," + " Stock restant:" +e1.stockRestant);
		}
		

		try {

			p1.ajouterArticle(l1, 7);

		} catch (StockException e2) {
			System.out.println(e2.getMessage() + " ," + " Stock restant:" +e2.stockRestant);
		}
	

		System.out.println(l1.getMateriel());

		try {

			p1.ajouterArticle(l2, 3);
		} catch (StockException e3) {
			System.out.println(e3.getMessage() + " ," + " Stock restant:" +e3.stockRestant);
		}

		System.out.println(p1);

		p1.diminuerQuantite(l2);

		System.out.println(p1);

		p1.modifierQuantite(l1, 10);

		System.out.println(p1);

	}

}
