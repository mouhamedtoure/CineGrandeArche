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

import fr.demos.poe.projet.librairie.data.*;
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

//		ArrayList<Article> mesArticles = new ArrayList<Article>();

//		Livre l1 = new Livre("123456", 10.99, "L'etranger", "Letranger.jpeg", Etat.COMME_NEUF, 0, "Camus", "Hachette");
//		Livre l2 = new Livre("234567", 15.99, "Madame Bovary", "Bovary.jpg", "pdf", "url", "Flaubert",
//				"Belin");
//		Livre l3 = new Livre("345678", 19.99, "Jurassic Park", "Jurassicpark.jpg", Etat.NEUF, 50, "Michael Crichton",
//				"Pocket");
//		ArticleDivers ad1 = new ArticleDivers("456789", 50.00, "Retour vers le futur", "Futur.jpg", Etat.BON_ETAT, 10,
//				"DVD", "Trilogie");
//
//		mesArticles.add(l1);
//		mesArticles.add(l2);
//		mesArticles.add(l3);
//		mesArticles.add(ad1);
		
		try {
			
			ArticleDAOMySQL articleDAO= new ArticleDAOMySQL();
			session.setAttribute("mesArticles", articleDAO.select(null));
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		

		RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("monPanier");
		@SuppressWarnings("unchecked")
		ArrayList<Article> articlesP = (ArrayList<Article>) session.getAttribute("mesArticles");

		String reference = request.getParameter("Reference");
		String action = request.getParameter("action");
		Map<String, String> erreurs0 = new HashMap<String, String>();

		if (action != null && action.equals("Ajouter")) {

			// le panier existe peut-être déjà , utiliser une session

			for (Article a : articlesP) {

				if (a.getRef().equals(reference)) {

					int index = articlesP.indexOf(a);

					try {
						panier.ajouterArticle(articlesP.get(index), 1);

					} catch (StockException e1) {

						erreurs0.put(reference, e1.getMessage());

					}

					break;

				}
			}

		}

		request.setAttribute("erreurs0", erreurs0);
		session.setAttribute("compteurPanier", panier.getCompteur());
		RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
		rd.forward(request, response);
	}

}