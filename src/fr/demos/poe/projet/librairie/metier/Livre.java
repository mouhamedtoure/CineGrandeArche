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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result + ((dateParution == null) ? 0 : dateParution.hashCode());
		result = prime * result + ((editeur == null) ? 0 : editeur.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		if (dateParution == null) {
			if (other.dateParution != null)
				return false;
		} else if (!dateParution.equals(other.dateParution))
			return false;
		if (editeur == null) {
			if (other.editeur != null)
				return false;
		} else if (!editeur.equals(other.editeur))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	

	
	
}
