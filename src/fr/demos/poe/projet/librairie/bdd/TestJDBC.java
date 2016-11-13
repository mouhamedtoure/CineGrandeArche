package fr.demos.poe.projet.librairie.bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class TestJDBC {

	/* La liste qui contiendra tous les résultats de nos essais */

	private List<String> messages = new ArrayList<String>();

	public List<String> executerTests( HttpServletRequest request ) {

	    /* Chargement du driver JDBC pour MySQL */

	    try {

	        messages.add( "Chargement du driver..." );

	        Class.forName( "com.mysql.jdbc.Driver" );

	        messages.add( "Driver chargé !" );

	    } catch ( ClassNotFoundException e ) {

	        messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"

	                + e.getMessage() );

	    }


	    /* Connexion à la base de données */

	    String url = "jdbc:mysql://localhost:3306/bdd_sdzee";

	    String utilisateur = "java";

	    String motDePasse = "NAnette3036";

	    Connection connexion = null;

	    Statement statement = null;

	    ResultSet resultat = null;

	    try {

	        messages.add( "Connexion à la base de données..." );

	        connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );

	        messages.add( "Connexion réussie !" );

	        /* Création de l'objet gérant les requêtes */

	        Statement statement1 = (Statement) connexion.createStatement();
	 
	        /* Création de l'objet gérant la requête préparée définie */

	        PreparedStatement preparedStatement = (PreparedStatement) connexion.prepareStatement( "SELECT id, email, mot_de_passe, nom FROM Utilisateur;" );

	        messages.add( "Objet requête créé !" );


	        /* Exécution d'une requête d'écriture avec renvoi de l'id auto-généré */
	        int statut = statement1.executeUpdate( "INSERT INTO Utilisateur (email, mot_de_passe, nom, date_inscription) VALUES ('jmarc2@mail.fr', MD5('lavieestbelle78'), 'jean-marc', NOW());" , Statement.RETURN_GENERATED_KEYS);

	        /* Formatage pour affichage dans la JSP finale. */
	        messages.add( "Résultat de la requête d'insertion : " + statut + "." );

	        /* Récupération de l'id auto-généré par la requête d'insertion. */
	        resultat = statement1.getGeneratedKeys();
	        /* Parcours du ResultSet et formatage pour affichage de la valeur qu'il contient dans la JSP finale. */
	        while ( resultat.next() ) {
	            messages.add( "ID retourné lors de la requête d'insertion :" + resultat.getInt( 1 ) );
	        }    
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        /* Création de l'objet gérant les requêtes préparées */

	        preparedStatement = (PreparedStatement) connexion.prepareStatement( "SELECT id, email, mot_de_passe, nom FROM Utilisateur;" );

	        messages.add( "Requête préparée créée !" );


	        /* Exécution d'une requête de lecture */

	        resultat = preparedStatement.executeQuery();

	        messages.add( "Requête \"SELECT id, email, mot_de_passe, nom FROM Utilisateur;\" effectuée !" );

	 

	        /* Récupération des données du résultat de la requête de lecture */

	        while ( resultat.next() ) {

	            int idUtilisateur = resultat.getInt( "id" );

	            String emailUtilisateur = resultat.getString( "email" );

	            String motDePasseUtilisateur = resultat.getString( "mot_de_passe" );

	            String nomUtilisateur = resultat.getString( "nom" );

	            /* Formatage des données pour affichage dans la JSP finale. */

	            messages.add( "Données retournées par la requête : id = " + idUtilisateur + ", email = " + emailUtilisateur

	                    + ", motdepasse = "

	                    + motDePasseUtilisateur + ", nom = " + nomUtilisateur + "." );

	        }

	    } catch ( SQLException e ) {

	        messages.add( "Erreur lors de la connexion : <br/>"

	                + e.getMessage() );

	    } finally {

	        messages.add( "Fermeture de l'objet ResultSet." );

	        if ( resultat != null ) {

	            try {

	                resultat.close();

	            } catch ( SQLException ignore ) {

	            }

	        }

	        messages.add( "Fermeture de l'objet Statement." );

	        if ( statement != null ) {

	            try {

	                statement.close();

	            } catch ( SQLException ignore ) {

	            }

	        }

	        messages.add( "Fermeture de l'objet Connection." );

	        if ( connexion != null ) {

	            try {

	                connexion.close();

	            } catch ( SQLException ignore ) {

	            }

	        }

	    }


	    return messages;

	}

}