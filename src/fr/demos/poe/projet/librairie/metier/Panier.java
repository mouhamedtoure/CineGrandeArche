package fr.demos.poe.projet.librairie.metier;

import java.util.ArrayList;

public class Panier {

	private Compte compte;
	private ArrayList<LignePanier> listeAchat;
	private double prixTotal;

	public Panier() {
		// TODO Auto-generated constructor
		this.listeAchat = new ArrayList<LignePanier>();

	}

	public Panier(Compte compte) {

		this.compte = compte;
		this.listeAchat = new ArrayList<LignePanier>();

	}

	public void ajouterArticle(Article a, int quantite) {

		LignePanier lp = new LignePanier(a, quantite);
		this.listeAchat.add(lp);
	}

	public void supprimerLigne(Article a, int quantite) {

		LignePanier lp = new LignePanier(a, quantite);
		this.listeAchat.remove(lp);
	}
	
	

	public void diminuerQuantite(Article a) {
		LignePanier lpArticleRecherche = new LignePanier(a,0);
		if(this.listeAchat.contains(lpArticleRecherche)){
			int i= this.listeAchat.indexOf(lpArticleRecherche);
			int k= this.listeAchat.get(i).getQuantite();
			this.listeAchat.get(i).setQuantite(k-1);
		}
			

		

	}
	public void augmenterQuantite(Article a){
		
		LignePanier lpArticleRecherche = new LignePanier(a,0);
		if(this.listeAchat.contains(lpArticleRecherche)){
			int i= this.listeAchat.indexOf(lpArticleRecherche);
			int k= this.listeAchat.get(i).getQuantite();
			this.listeAchat.get(i).setQuantite(k+1);
		
		}
		}

	public ArrayList<LignePanier> getListeAchat() {
		return listeAchat;
	}

	public void setListeAchat(ArrayList<LignePanier> listeAchat) {
		this.listeAchat = listeAchat;
	}

	public Compte getCompte() {
		return compte;
	}

	@Override
	public String toString() {
		return "Panier [compte=" + compte + ", listeAchat=" + listeAchat + "]";
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

}
