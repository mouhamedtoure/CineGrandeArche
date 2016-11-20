package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/PanierVue.jsp");
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
			
		
		
		
		String reference = request.getParameter("Reference");
		String action = request.getParameter("action");
		Map<String, String> erreurs0 = new HashMap<String, String>();

		@SuppressWarnings("unchecked")
		ArrayList<Article> articlesP = (ArrayList<Article>) session.getAttribute("mesArticles");

		if (action != null && action.equals("Ajouter")) {

			// le panier existe peut-�tre d�j� , utiliser une session

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
