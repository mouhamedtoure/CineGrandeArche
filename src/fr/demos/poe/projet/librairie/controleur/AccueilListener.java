package fr.demos.poe.projet.librairie.controleur;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.demos.poe.projet.librairie.metier.Panier;

/**
 * Application Lifecycle Listener implementation class AccueilListener
 *
 */
@WebListener
public class AccueilListener implements ServletContextListener, HttpSessionListener {

	
	private Panier panier= new Panier();
	int compteurPanier = 0;
    /**
     * Default constructor. 
     */
    public AccueilListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
       

    	arg0.getSession().setAttribute("monPanier", panier);
    	arg0.getSession().setAttribute("compteurPanier", compteurPanier);
    	
    	
    	
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    	panier.vider();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
       
    	
    	arg0.getServletContext().setAttribute("monPanier",panier);
    	arg0.getServletContext().setAttribute("compteurPanier",compteurPanier);
    	}
	
}
