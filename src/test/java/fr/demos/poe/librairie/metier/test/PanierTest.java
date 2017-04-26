package fr.demos.poe.librairie.metier.test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.demos.poe.projet.librairie.metier.*;

public class PanierTest {

	Panier p;
	Livre l1, l2;
	ArticleDivers DVD1;
	ArticleDivers mp3;
	ArrayList<LignePanier> listep;

	@Before
	public void setUp() throws Exception {

		p = new Panier();
		l1 = new Livre("1234567", 15.99, "Bovary", "bon livre", "image.jpg", Etat.NEUF, 10, 2, "123",
				LocalDate.of(2012, 12, 12), "Flaubert", "Hachette", "roman");
		l2 = new Livre("2345678", 4.99, "Letranger", "tres bon livre", "image2.jpg", Etat.TRES_BON_ETAT, 20, 2, "234",
				LocalDate.of(2010, 01, 13), "Camus", "Hachette", "roman");
		DVD1 = new ArticleDivers("3456789", 5.45, "DVD Copolla", "bon dvd", "image3.jpg", Etat.NEUF, 7, 5, "Trilogie");

		mp3 = new ArticleDivers("4567890", 3.99, "mp3 star wars", "tres bonne qualite", "image4.jpg", "mp3", "url.com",
				"demat");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrixTotal() throws StockException {

		p.ajouterArticle(l1, 3);
		p.ajouterArticle(l2, 2);
		p.ajouterArticle(DVD1, 1);

		Assert.assertEquals(63.4, p.getPrixTotal(), 0.001);
	}

	@Test
	public void testNombreArticle() throws StockException {

		p.ajouterArticle(l1, 1);
		p.ajouterArticle(l2, 3);
		p.ajouterArticle(DVD1, 2);
		p.ajouterArticle(mp3, 10);

		Assert.assertEquals(16, p.getCompteur(), 0.001);
	}

	@Test
	public void testNombreLigne() throws StockException {

		p.ajouterArticle(l1, 4);
		p.ajouterArticle(l1, 1);
		p.ajouterArticle(l2, 7);
		p.ajouterArticle(DVD1, 7);

		int i = 0;
		Iterator<LignePanier> it = p.getListeAchat();
		while (it.hasNext()) {
			i++;
			it.next();

		}

		Assert.assertEquals(3, i, 0.001);
	}

	@Test
	public void testAugmentationQuantiteLigne() throws StockException {

		p.ajouterArticle(l1, 4);
		p.ajouterArticle(l1, 1);
		p.ajouterArticle(l2, 7);
		p.ajouterArticle(DVD1, 7);
		p.ajouterArticle(l1, 2);
		p.ajouterArticle(l2, 2);
		p.ajouterArticle(mp3, 2);

		int i = 0;
		int quantiteLigne = 0;

		LignePanier currentLigne = null;
		Iterator<LignePanier> it = p.getListeAchat();
		while (it.hasNext()) {
			currentLigne = it.next();
			if (currentLigne.getArticle().equals(l2)) {
				quantiteLigne = currentLigne.getQuantite();
				break;
			}
		}

		Assert.assertEquals(9, quantiteLigne, 0.001);
	}
	
	@Test
	public void testAjoutArticle() throws StockException {

		p.ajouterArticle(l1, 4);
		p.ajouterArticle(l1, 1);
		p.ajouterArticle(l2, 7);
		p.ajouterArticle(DVD1, 7);
		p.ajouterArticle(l1, 2);
		p.ajouterArticle(l2, 2);
		p.ajouterArticle(mp3, 2);

		

		LignePanier currentLigne = null;
		Article article = null;
		Iterator<LignePanier> it = p.getListeAchat();
		while (it.hasNext()) {
			currentLigne = it.next();
			if (currentLigne.getArticle().equals(l2)) {
				article = currentLigne.getArticle();
				break;
			}
		}

		Assert.assertNotNull(article);
	}


}
