package fr.demos.poe.projet.librairie.metier;

import java.util.Date;

public class Livre extends Article {

	private String isbn;
	private String format;
	private String auteur;
	private Date dateParution;
	private String editeur;
	private String genre;
	
	public Livre(String ref, double prixHT, String nom, String image, Dematerialise demat) {
		super(ref, prixHT, nom, image, demat);
		// TODO Auto-generated constructor stub
	}

	public Livre(String ref, double prixHT, String nom, String image, Materialise materiel, boolean neuf) {
		super(ref, prixHT, nom, image, materiel, neuf);
		// TODO Auto-generated constructor stub
		
		
		
		
		
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	

	
	
}
