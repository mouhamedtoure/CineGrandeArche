package fr.demos.poe.projet.librairie.metier;

public class LigneCatalogue {
	
	Article article;
	int stock;
	
	
	public LigneCatalogue(Article a, int stock){
		
		if(a.getDemat()==null){
			
			this.article=a;
			this.stock=a.getMateriel().getStock();
			
		}
	}

}
