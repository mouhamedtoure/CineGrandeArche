package fr.demos.poe.projet.librairie.metier;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Livre l1= new Livre("123456",10.99, "TomTom", "lien image", new Materialise( Etat.COMME_NEUF,10,1), true);
	
	System.out.println(l1);
	}

}
