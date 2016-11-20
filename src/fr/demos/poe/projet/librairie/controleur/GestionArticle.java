package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.poe.projet.librairie.metier.*;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		ArrayList<Article> mesArticles = new ArrayList<Article>();

		Livre l1 = new Livre("123456", 10.99, "L'etranger", "Letranger.jpeg", Etat.COMME_NEUF, 0, "Camus", "Hachette");
		Livre l2 = new Livre("234567", 15.99, "Madame Bovary", "Bovary.jpg", "pdf", "url de telechargement", "Flaubert",
				"Belin");
		Livre l3 = new Livre("345678", 19.99, "Jurassic Park", "Jurassicpark.jpg", Etat.NEUF, 50, "Michael Crichton",
				"Pocket");
		ArticleDivers ad1 = new ArticleDivers("456789", 50.00, "Retour vers le futur", "Futur.jpg", Etat.BON_ETAT, 10,
				"DVD", "Trilogie");

		mesArticles.add(l1);
		mesArticles.add(l2);
		mesArticles.add(l3);
		mesArticles.add(ad1);

		session.setAttribute("mesArticles", mesArticles);

		RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}