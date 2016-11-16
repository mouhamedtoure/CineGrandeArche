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

		LignePanier lp = new LignePanier(a, quantite);
		if (this.lignesPanier.contains(lp)) {
			int index = lignesPanier.indexOf(lp);
			lignesPanier.get(index).quantite += quantite;
		} else {

			if (a.getDemat() == null) {
				int stockDispo = a.getMateriel().getStock();

				if (stockDispo < quantite) {

					StockException se = new StockException(a, a.getMateriel().getStock(),
							"La quantite demandee est superieure au stock disponible");

					throw se;

				}

				else {

					this.lignesPanier.add(lp);

				}
			}
			if (a.getDemat() != null) {
				this.lignesPanier.add(lp);

			}
		}

	}

	public void modifierQuantite(Article a, int quantite) throws IllegalArgumentException {

		if (quantite < 0) {
			IllegalArgumentException qe = new IllegalArgumentException("Quantite saisie non autorisee");

			throw qe;
		}

		LignePanier lpArticleRecherche = new LignePanier(a, quantite);
		if (this.lignesPanier.contains(lpArticleRecherche)) {
			int i = this.lignesPanier.indexOf(lpArticleRecherche);
			this.lignesPanier.get(i).setQuantite(quantite);

		}

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

		return "compte=" + compte + lignesPanier + "\n";

	}

	public double getPrixTotal() {
		
		double prixTotal=0;
		
	 for(LignePanier lp: this.lignesPanier){
		 
		 prixTotal+= lp.article.getPrixHT()*lp.quantite;
	 }

		return prixTotal;
	}

}
