package fr.demos.poe.projet.librairie.metier;

public abstract class Article {

	private String ref;
	private double prixHT;
	private String nom;
	private String description;
	private String image;
	private Dematerialise demat;
	private Materialise materiel;
	private boolean neuf;
	private Etat etat;
	
	public Article(String ref, double prixHT, String nom, String image, Dematerialise demat) {
		// TODO Auto-generated constructor stub
		super();
		this.ref = ref;
		this.prixHT = prixHT;
		this.nom = nom;
		this.image = image;
		this.demat = demat;

	}
	public Article(String ref, double prixHT, String nom, String image, Materialise materiel,
			boolean neuf) {
		// TODO Auto-generated constructor stub
		super();
		this.ref = ref;
		this.prixHT = prixHT;
		this.nom = nom;
		this.image = image;
		this.materiel = materiel;
		this.neuf = true;

	}

	public Article(String ref, double prixHT, String nom, String image, Materialise materiel, boolean neuf, Etat etat) {
		// TODO Auto-generated constructor stub
		super();
		this.ref = ref;
		this.prixHT = prixHT;
		this.nom = nom;
		this.image = image;
		this.materiel = materiel;
		this.neuf = false;
		this.etat=etat;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isNeuf() {
		return neuf;
	}
	
	
	

	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	@Override
	public String toString() {

		if (demat == null) {

			return "Article [ref=" + ref + ", prixHT=" + prixHT + ", nom=" + nom + ", image=" + image + ", materiel=" + materiel + ", neuf=" + neuf + "]";
		}

		else {
			return "Article [ref=" + ref + ", prixHT=" + prixHT + ", nom=" + nom + ", image=" + image + ", demat=" + demat + "]";
		}

	}

}
