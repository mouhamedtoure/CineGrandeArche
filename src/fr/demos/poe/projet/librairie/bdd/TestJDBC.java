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

	/* La liste qui contiendra tous les r�sultats de nos essais */

	private List<String> messages = new ArrayList<String>();

	public List<String> executerTests( HttpServletRequest request ) {

	    /* Chargement du driver JDBC pour MySQL */

	    try {

	        messages.add( "Chargement du driver..." );

	        Class.forName( "com.mysql.jdbc.Driver" );

	        messages.add( "Driver charg� !" );

	    } catch ( ClassNotFoundException e ) {

	        messages.add( "Erreur lors du chargement : le driver n'a pas �t� trouv� dans le classpath ! <br/>"

	                + e.getMessage() );

	    }


	    /* Connexion � la base de donn�es */

	    String url = "jdbc:mysql://localhost:3306/bdd_sdzee";

	    String utilisateur = "java";

	    String motDePasse = "NAnette3036";

	    Connection connexion = null;

	    Statement statement = null;

	    ResultSet resultat = null;

	    try {

	        messages.add( "Connexion � la base de donn�es..." );

	        connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );

	        messages.add( "Connexion r�ussie !" );

	        /* Cr�ation de l'objet g�rant les requ�tes */

	        Statement statement1 = (Statement) connexion.createStatement();
	 
	        /* Cr�ation de l'objet g�rant la requ�te pr�par�e d�finie */

	        PreparedStatement preparedStatement = (PreparedStatement) connexion.prepareStatement( "SELECT id, email, mot_de_passe, nom FROM Utilisateur;" );

	        messages.add( "Objet requ�te cr�� !" );


	        /* Ex�cution d'une requ�te d'�criture avec renvoi de l'id auto-g�n�r� */
	        int statut = statement1.executeUpdate( "INSERT INTO Utilisateur (email, mot_de_passe, nom, date_inscription) VALUES ('jmarc2@mail.fr', MD5('lavieestbelle78'), 'jean-marc', NOW());" , Statement.RETURN_GENERATED_KEYS);

	        /* Formatage pour affichage dans la JSP finale. */
	        messages.add( "R�sultat de la requ�te d'insertion : " + statut + "." );

	        /* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion. */
	        resultat = statement1.getGeneratedKeys();
	        /* Parcours du ResultSet et formatage pour affichage de la valeur qu'il contient dans la JSP finale. */
	        while ( resultat.next() ) {
	            messages.add( "ID retourn� lors de la requ�te d'insertion :" + resultat.getInt( 1 ) );
	        }    
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        /* Cr�ation de l'objet g�rant les requ�tes pr�par�es */

	        preparedStatement = (PreparedStatement) connexion.prepareStatement( "SELECT id, email, mot_de_passe, nom FROM Utilisateur;" );

	        messages.add( "Requ�te pr�par�e cr��e !" );


	        /* Ex�cution d'une requ�te de lecture */

	        resultat = preparedStatement.executeQuery();

	        messages.add( "Requ�te \"SELECT id, email, mot_de_passe, nom FROM Utilisateur;\" effectu�e !" );

	 

	        /* R�cup�ration des donn�es du r�sultat de la requ�te de lecture */

	        while ( resultat.next() ) {

	            int idUtilisateur = resultat.getInt( "id" );

	            String emailUtilisateur = resultat.getString( "email" );

	            String motDePasseUtilisateur = resultat.getString( "mot_de_passe" );

	            String nomUtilisateur = resultat.getString( "nom" );

	            /* Formatage des donn�es pour affichage dans la JSP finale. */

	            messages.add( "Donn�es retourn�es par la requ�te : id = " + idUtilisateur + ", email = " + emailUtilisateur

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