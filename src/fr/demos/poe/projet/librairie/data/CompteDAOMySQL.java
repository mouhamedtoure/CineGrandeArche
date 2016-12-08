package fr.demos.poe.projet.librairie.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.demos.poe.projet.librairie.metier.Compte;

public class CompteDAOMySQL implements CompteDAO {

	private Context context;
	private DataSource dataSource;

	public CompteDAOMySQL() throws Exception {

		context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/CineGrandeArche");

	}

	@Override
	public void insert(Compte c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Compte c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Compte c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Compte select(String mail, String pwd) {

		
		Compte compte = new Compte();
		try {
			Connection cx = dataSource.getConnection();

			// Prepared statement pour les donnees dans la table livre
			PreparedStatement contexteRequete = cx.prepareStatement("SELECT * FROM Compte WHERE email='%"
								+ mail + "%'");

			ResultSet rs = contexteRequete.executeQuery();

			while (rs.next()) {

				String email = rs.getString("email");
				String motdepasse = rs.getString("motdepasse");
				String nom= rs.getString("nom");
				String prenom= rs.getString("prenom");
				String adresse= rs.getString("adresse");
	

				 compte = new Compte(email, motdepasse, nom, prenom, adresse);
				
			}
		

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return compte;

		
	}

}
