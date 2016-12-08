package fr.demos.poe.projet.librairie.data;

import fr.demos.poe.projet.librairie.metier.Compte;

public interface CompteDAO {
	
	void insert(Compte c) throws Exception;
	void update(Compte c) throws Exception;
	void delete(Compte c) throws Exception;
	Compte select(String mail, String pwd);

}
