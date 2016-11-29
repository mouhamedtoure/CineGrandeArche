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
	public List<Article> select(String critere){
		// TODO Auto-generated method stub
		ArrayList<Article> mesArticles = new ArrayList<Article>();
		

	 
	try {
		Connection cx = dataSource.getConnection();
		
		PreparedStatement contexteRequete = 
		cx.prepareStatement("SELECT * FROM Livre l INNER JOIN Article a ON (l.reference=a.reference)");
		ResultSet rs= contexteRequete.executeQuery();
		
		

		while(rs.next()){
			
		
			
			String ref = rs.getString("reference");
			Double prixHT = rs.getDouble("prixHT");
			String nom = rs.getString("nom");
			String image = rs.getString("image");
			Etat etat=Etat.valueOf(rs.getString("etat"));
			int stock=rs.getInt("stock");
			String isbn= rs.getString("isbn");

			String format= rs.getString("format");
			LocalDate dateParution= rs.getDate("dateParution").toLocalDate();
			String auteur= rs.getString("auteur");
			String editeur = rs.getString("editeur");
			String genre = rs.getString("genre");

		
		
			Livre livre = new Livre(ref, prixHT, nom, image, etat, stock, isbn, format, dateParution, auteur, editeur, genre);
			
			mesArticles.add(livre);	
			
			
		}
	
	} catch(Exception ex) {

		ex.printStackTrace();
	}
		
		
		
		
		return mesArticles;
	}



}
