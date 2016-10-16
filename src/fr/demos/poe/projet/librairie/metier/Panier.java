package fr.demos.poe.projet.librairie.metier;

import java.util.ArrayList;

public class Panier {

	private Compte compte;
	private ArrayList<LignePanier> lignesPanier;
	private double prixTotal;

	public Panier() {
		
		this.lignesPanier = new ArrayList<LignePanier>();

	}

	public Panier(Compte compte) {

		this.compte = compte;
		this.lignesPanier = new ArrayList<LignePanier>();

	}

	public void ajouterArticle(Article a, int quantite) throws StockException {

		if (a.getDemat() == null) {

			int stockDispo = a.getMateriel().getStock();

			if (stockDispo < quantite) {

				StockException se = new StockException(a, a.getMateriel().getStock(),
						"La quantite demandee est superieure au stock disponible");

				throw se;

			}

			else {

				LignePanier lp = new LignePanier(a, quantite);
				this.lignesPanier.add(lp);

			}
		}
		if (a.getDemat() != null) {
			LignePanier lp = new LignePanier(a, quantite);
			this.lignesPanier.add(lp);

		}

	}

	public void modifierQuantite(Article a, int quantite) throws QuantiteException {

		if (quantite < 0) {
			QuantiteException qe = new QuantiteException("Quantite saisie non autorisee");

			throw qe;
		}


			LignePanier lpArticleRecherche = new LignePanier(a, quantite);
			if (this.lignesPanier.contains(lpArticleRecherche)) {
				int i = this.lignesPanier.indexOf(lpArticleRecherche);
				this.lignesPanier.get(i).setQuantite(quantite);

		}

	}
	public void vider(){
		
		this.lignesPanier.clear();
		
	}

	public ArrayList<LignePanier> getListeAchat() {
		return lignesPanier;
	}

	public void setListeAchat(ArrayList<LignePanier> listeAchat) {
		this.lignesPanier = listeAchat;
	}

	public Compte getCompte() {
		return compte;
	}

	@Override

	public String toString() {

		return "compte=" + compte + lignesPanier + "\n";

	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

}
