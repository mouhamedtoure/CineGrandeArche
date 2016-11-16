package fr.demos.poe.projet.librairie.metier;

public class Compte {

	String email;
	String motdepasse;

	public Compte(String email, String motDePasse) {
		this.email = email;
		this.motdepasse = motDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motdepasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motdepasse = motDePasse;
	}

}
