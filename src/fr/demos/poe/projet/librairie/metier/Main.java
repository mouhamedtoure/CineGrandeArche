package fr.demos.poe.projet.librairie.metier;

import java.util.Iterator;

public class Main {

	public Main() {

	}

	public static void main(String[] args) {

		Livre l1 = new Livre("123456", 10.99, "L'etranger", Etat.COMME_NEUF, 10, "Camus", "Hachette");
		Livre l2 = new Livre("234567", 15.99, "Madame Bovary", "pdf", "url de telechargement", "Flaubert", "Belin");
		Livre l3 = new Livre("345678", 19.99, "Jurassic Park", 50, "Michael Crichton", "Pocket");

		Panier p1 = new Panier();

		try {
			p1.ajouterArticle(l1, 5);
		} catch (StockException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage() + " ," + " Stock restant:" + e1.stockRestant);
		}

		try {

			p1.ajouterArticle(l1, 3);
		} catch (StockException e3) {
			System.out.println(e3.getMessage() + " ," + " Stock restant:" + e3.stockRestant);
		}

		System.out.println(p1);

		try

		{

			p1.ajouterArticle(l3, 5);

		} catch (

		StockException e5) {

			System.out.println(e5.getMessage() + " ," + " Stock restant:" + e5.stockRestant);
		}

		try {

			p1.ajouterArticle(l2, 3);
		} catch (StockException e3) {
			System.out.println(e3.getMessage() + " ," + " Stock restant:" + e3.stockRestant);
		}

		try {

			p1.ajouterArticle(l1, 3);
		} catch (StockException e3) {
			System.out.println(e3.getMessage() + " ," + " Stock restant:" + e3.stockRestant);
		}

		System.out.println(p1);

		try {
			p1.modifierQuantite(l1, 10);

		} catch (IllegalArgumentException qe1) {

			System.out.println(qe1.getMessage());

		}

		try {
			p1.modifierQuantite(l1, -10);

		} catch (IllegalArgumentException qe1) {

			System.out.println(qe1.getMessage());

		}
		System.out.println(p1);
		
		System.out.println("Prix total:" +p1.getPrixTotal());
		
		
		
	 p1.getListeAchat();
			
			
		}
	}
