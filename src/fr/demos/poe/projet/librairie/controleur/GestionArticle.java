package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.poe.projet.librairie.metier.Etat;
import fr.demos.poe.projet.librairie.metier.Livre;

/**
 * Servlet implementation class GestionArticle
 */
@WebServlet("/GestionArticle")
public class GestionArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionArticle() {
        super();
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Livre l1 = new Livre("123456", 10.99, "L'etranger", Etat.COMME_NEUF, 10, "Camus", "Hachette");
		Livre l2 = new Livre("234567", 15.99, "Madame Bovary", "pdf", "url de telechargement", "Flaubert", "Belin");
		Livre l3= new Livre("345678", 19.99, "Jurassic Park", 50, "Michael Crichton", "Pocket");
		
		
		
		request.setAttribute("livre1", l1);
		request.setAttribute("livre2", l2);
		request.setAttribute("livre3", l3);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Accueil.jsp");
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
