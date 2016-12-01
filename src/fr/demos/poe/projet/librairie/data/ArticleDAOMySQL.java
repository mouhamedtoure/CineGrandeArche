package fr.demos.poe.projet.librairie.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.DataSource;

import fr.demos.poe.projet.librairie.metier.Article;
import fr.demos.poe.projet.librairie.metier.ArticleDivers;
import fr.demos.poe.projet.librairie.metier.Etat;
import fr.demos.poe.projet.librairie.metier.Livre;

public class ArticleDAOMySQL implements ArticleDAO {

	private Context context;
	private DataSource dataSource;

	public ArticleDAOMySQL() throws Exception {
		context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/CineGrandeArche");
	}

	@Override
	public void insert(Article a) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Article a) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Article a) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Article> select(String critere) {
		// TODO Auto-generated method stub
		ArrayList<Article> mesArticles = new ArrayList<Article>();

		try {
			Connection cx = dataSource.getConnection();

			// Prepared statement pour les donnees dans la table livre
			PreparedStatement contexteRequete = cx
					.prepareStatement("SELECT * FROM Livre l INNER JOIN Article a ON (l.reference=a.reference)");
			ResultSet rs = contexteRequete.executeQuery();

			// Prepared statement pour les donnees dans la table article divers
			PreparedStatement contexteRequete2 = cx.prepareStatement(
					"SELECT * FROM articledivers d INNER JOIN Article a ON (d.reference=a.reference)");
			ResultSet rs2 = contexteRequete2.executeQuery();

			while (rs.next()) {

				// On récupère dans les bases les attributs communs à tous les
				// livres

				String ref = rs.getString("reference");

				Double prixHT = rs.getDouble("prixHT");

				String nom = rs.getString("nom");

				String description = rs.getString("description");

				String image = rs.getString("image");

				LocalDate dateParution = rs.getDate("dateParution").toLocalDate();
				String auteur = rs.getString("auteur");
				String editeur = rs.getString("editeur");
				String genre = rs.getString("genre");

				// Si l'article est un livre materialise
				if (rs.getString("format") == null) {

					String isbn = rs.getString("isbn");

					Etat etat = Etat.valueOf(rs.getString("etat"));
					int stock = rs.getInt("stock");
					double delaiLivraison = rs.getDouble("delaiLivraison");

					Livre livre = new Livre(ref, prixHT, nom, description, image, etat, stock, delaiLivraison, isbn,
							dateParution, auteur, editeur, genre);
					mesArticles.add(livre);

				}
				// Si le livre est un livre dematerialise
				else {

					String format = rs.getString("format");

					String url = rs.getString("url");

					Livre livre = new Livre(ref, prixHT, nom, description, image, format, url, dateParution, auteur,
							editeur, genre);
					mesArticles.add(livre);

				}

			}

			while (rs2.next()) {

				String ref = rs2.getString("reference");

				Double prixHT = rs2.getDouble("prixHT");

				String nom = rs2.getString("nom");

				String description = rs2.getString("description");

				String image = rs2.getString("image");

				// Si l'article n'est pas un livre: article divers

				String caracteristique = rs2.getString("caracteristique");

				// article divers dematerialise

				if (rs2.getString("format") == null) {

					String format = rs2.getString("format");

					String url = rs2.getString("url");

					ArticleDivers divers = new ArticleDivers(ref, prixHT, nom, description, image, format, url,
							caracteristique);
					mesArticles.add(divers);

				}
				// Si l'article divers est materialise

				else {
					Etat etat = Etat.valueOf(rs2.getString("etat"));
					int stock = rs2.getInt("stock");
					double delaiLivraison = rs2.getDouble("delaiLivraison");

					ArticleDivers divers = new ArticleDivers(ref, prixHT, nom, description, image, etat, stock,
							delaiLivraison, caracteristique);
					mesArticles.add(divers);

				}

			}

		} catch (

		Exception ex) {

			ex.printStackTrace();
		}

		return mesArticles;
	}

}
