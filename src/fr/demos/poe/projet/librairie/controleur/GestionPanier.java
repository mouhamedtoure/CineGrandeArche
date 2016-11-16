package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.poe.projet.librairie.metier.*;

/**
 * Servlet implementation class GestionPanier
 */
@WebServlet("/GestionPanier")
public class GestionPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Livre l1 = new Livre("123456", 10.99, "L'etranger", "src=", Etat.COMME_NEUF, 10, "Camus", "Hachette");
		Livre l2 = new Livre("234567", 15.99, "Madame Bovary", "src=" , "pdf", "url de telechargement", "Flaubert", "Belin");
		Livre l3= new Livre("345678", 19.99, "Jurassic Park", "src=" ,Etat.NEUF, 50, "Michael Crichton", "Pocket");
		
		
		Panier panier= new Panier();
		
		try {

			panier.ajouterArticle(l1, 5);

		} catch (StockException e1) {

			System.out.println(e1.getMessage() + " ," + " Stock restant:" + e1.stockRestant);
		}
		
		try {

			panier.ajouterArticle(l3, 5);

		} catch (StockException e5) {

			System.out.println(e5.getMessage() + " ," + " Stock restant:" + e5.stockRestant);
		}
		

		try {

			panier.ajouterArticle(l2, 3);
		} catch (StockException e3) {
			System.out.println(e3.getMessage() + " ," + " Stock restant:" + e3.stockRestant);
		}

		System.out.println(panier);

		try {
			panier.modifierQuantite(l1, 10);

		} catch (IllegalArgumentException qe1) {

			System.out.println(qe1.getMessage());

		}

		try {
			panier.modifierQuantite(l1, -10);

		} catch (IllegalArgumentException qe1) {

			System.out.println(qe1.getMessage());

		}
		
		
				request.setAttribute("monPanier", panier);
				
				
				
				
				// appel de la jsp
				RequestDispatcher rd=request.getRequestDispatcher("Panier.jsp");
				rd.forward(request, response);
			
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
