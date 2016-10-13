package fr.demos.poe.projet.librairie.metier;

import java.util.ArrayList;

public class Panier {

	
	Compte compte;
	ArrayList <lignePanier> listeAchat;
	
	public Panier() {
		// TODO Auto-generated constructor 
		this.listeAchat= new ArrayList<lignePanier>();
		
		
	}
	public Panier(Compte compte){
		
		this.compte=compte;
		this.listeAchat=new ArrayList<lignePanier>();
		
	}
}
