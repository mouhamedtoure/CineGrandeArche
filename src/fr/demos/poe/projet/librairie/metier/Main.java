package fr.demos.poe.projet.librairie.metier;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Livre l1= new Livre("123456",10.99, "TomTom", "lien image", new Materialise( Etat.COMME_NEUF,10,1), true);
	
	Livre l2= new Livre("234567", 9.99, "Martine au village", "lien image", new Dematerialise("pdf","url de telechargement"));
	
	System.out.println(l1);
	System.out.println(l2);
	
	Panier p1=new Panier();
	
	
	
	
	
	p1.ajouterArticle(l1,2);
	p1.ajouterArticle(l2,3);
	
	System.out.println(p1);
	
	p1.diminuerQuantite(l2);
	
	System.out.println(p1);
	
	
	
	
	
	
	}

}
