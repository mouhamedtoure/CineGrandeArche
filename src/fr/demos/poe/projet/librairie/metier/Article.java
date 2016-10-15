package fr.demos.poe.projet.librairie.metier;

public abstract class Article {

	private String ref;
	private double prixHT;
	private String nom;
	private String description;
	private String image;
	private Dematerialise demat;
	private Materialise materiel;
	private Etat etat;

	// Constructeur d'un article demateralise

	public Article(String ref, double prixHT, String nom, String format, String url) {
		// TODO Auto-generated constructor stub
		super();
		this.ref = ref;
		this.prixHT = prixHT;
		this.nom = nom;
		this.demat = new Dematerialise(format, url);

	}

	// Constructeur d'un article materialise d'occasion

	public Article(String ref, double prixHT, String nom, Etat etat, Integer stock) {

		super();
		this.ref = ref;
		this.prixHT = prixHT;
		this.nom = nom;
		this.materiel = new Materialise(stock);

	}

	// Constructeur d'un article materialise neuf

	public Article(String ref, double prixHT, String nom, Integer stock) {

		super();
		this.ref = ref;
		this.prixHT = prixHT;
		this.nom = nom;
		this.materiel = new Materialise(stock);

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

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "ref=" + ref + ", prixHT=" + prixHT + ", " + nom + " ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (ref == null) {
			if (other.ref != null)
				return false;
		} else if (!ref.equals(other.ref))
			return false;
		return true;
	}

	public Dematerialise getDemat() {
		return demat;
	}

	public void setDemat(Dematerialise demat) {
		this.demat = demat;
	}

	public Materialise getMateriel() {
		return materiel;
	}

	public void setMateriel(Materialise materiel) {
		this.materiel = materiel;
	}

}
