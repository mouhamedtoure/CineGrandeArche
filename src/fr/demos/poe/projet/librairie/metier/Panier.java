package fr.demos.poe.projet.librairie.metier;

import java.util.ArrayList;

public class Panier {

	private Compte compte;
	private ArrayList<LignePanier> lignePaniers;
	private double prixTotal;

	public Panier() {
		
		this.lignePaniers = new ArrayList<LignePanier>();

	}

	public Panier(Compte compte) {

		this.compte = compte;
		this.lignePaniers = new ArrayList<LignePanier>();

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
				this.lignePaniers.add(lp);

			}
		}
		if (a.getDemat() != null) {
			LignePanier lp = new LignePanier(a, quantite);
			this.lignePaniers.add(lp);

		}

	}

	public void modifierQuantite(Article a, int quantite) throws QuantiteException {

		if (quantite < 0) {
			QuantiteException qe = new QuantiteException("Quantite saisie non autorisee");

			throw qe;
		}


			LignePanier lpArticleRecherche = new LignePanier(a, quantite);
			if (this.lignePaniers.contains(lpArticleRecherche)) {
				int i = this.lignePaniers.indexOf(lpArticleRecherche);
				this.lignePaniers.get(i).setQuantite(quantite);

		}

	}
	public void vider(){
		
		this.lignePaniers.clear();
		
	}

	public ArrayList<LignePanier> getListeAchat() {
		return lignePaniers;
	}

	public void setListeAchat(ArrayList<LignePanier> listeAchat) {
		this.lignePaniers = listeAchat;
	}

	public Compte getCompte() {
		return compte;
	}

	@Override

	public String toString() {

		return "compte=" + compte + lignePaniers + "\n";

	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

}
