package fr.demos.poe.projet.librairie.metier;

import java.util.ArrayList;
import java.util.Iterator;

public class Panier {

	private Compte compte;
	private ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();

	public Panier() {

	}

	public Panier(Compte compte) {

		this.compte = compte;
	
	}

	public void ajouterArticle(Article a, int quantite) throws StockException {

		// Initialisation d'un nouveau panier avec les paramètres en argument
		LignePanier lp = new LignePanier(a, quantite);

		// l'article était déjà dans le panier
		if (this.lignesPanier.contains(lp)) {

			// On stocke l'index de l'article dans une variable

			int index = lignesPanier.indexOf(lp);

			// Test si l'article est matérialisé

			if (a.getDemat() == null) {

				// On teste pour voir si le stock est superieur a la quantite

				if ((a.getMateriel().getStock()) >= quantite) {

					// On augmente la quantite dans le panier
					lignesPanier.get(index).quantite += quantite;

					// Diminution du stock
					a.getMateriel().setStock(a.getMateriel().getStock() - quantite);

				}

				// Sinon le stock est inferieur a la quantite
				else {

					StockException se = new StockException(a, a.getMateriel().getStock(),
							"La quantite demandee est superieure au stock disponible");

					throw se;
				}
			}
			// Sinon l'article est dématérialisé
			else {

				// On augmente la quantite
				lignesPanier.get(index).quantite += quantite;
				// Pas de diminution de stock ici
			}

		}
		// Sinon nouvel article à ajouter au panier
		else {

			// Si l'article est matérialisé

			if (a.getDemat() == null) {

				// Si le stock dispo est inferieur a la quantite

				if (a.getMateriel().getStock() < quantite) {

					StockException se = new StockException(a, a.getMateriel().getStock(),
							"La quantite demandee est superieure au stock disponible");

					throw se;

				}

				// Sinon on ajoute au panier

				else {

					this.lignesPanier.add(lp);
					a.getMateriel().setStock(a.getMateriel().getStock() - quantite);

				}

			}
			// Sinon l'article est dematerialise
			else {
				this.lignesPanier.add(lp);

			}
		}

	}

	public int modifierQuantite(Article a, int quantite) throws IllegalArgumentException {

		if (quantite < 0) {
			IllegalArgumentException qe = new IllegalArgumentException("Quantite saisie non autorisee");

			throw qe;
		}

		LignePanier lpArticleRecherche = new LignePanier(a, quantite);
		if (this.lignesPanier.contains(lpArticleRecherche)) {
			int i = this.lignesPanier.indexOf(lpArticleRecherche);
			this.lignesPanier.get(i).setQuantite(quantite);

		}
		return quantite;

	}

	public void vider() {

		this.lignesPanier.clear();

	}

	// retourner plutôt un iterator

	public Iterator<LignePanier> getListeAchat() {

		Iterator<LignePanier> iter = this.lignesPanier.iterator();
		return iter;

	}

	public Compte getCompte() {
		return compte;
	}

	@Override

	public String toString() {

		return lignesPanier + "\n";
		
	}

	public double getPrixTotal() {

		double prixTotal = 0;

		for (LignePanier lp : this.lignesPanier) {

			prixTotal += lp.article.getPrixHT()* ((double)lp.quantite);
		}

		return prixTotal;
	}

	public int getCompteur() {
		int compteur = 0;
		for (LignePanier lp : this.lignesPanier) {

			compteur += lp.getQuantite();

		}

		return compteur;
	}
	public int getNbArticles(){
		int nbArticles=0;
		for (Iterator<LignePanier> iterator = this.lignesPanier.iterator(); iterator.hasNext();) {
			iterator.next();
			nbArticles++;
		}
		return nbArticles;
			
	}
}
