package fr.demos.poe.projet.librairie.metier;

public class Compte {

	String email;
	String motDePasse;

	public Compte(String email, String motDePasse) {
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
