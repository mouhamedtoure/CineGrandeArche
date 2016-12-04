package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;
import java.io.PrintWriter;
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

import fr.demos.poe.projet.librairie.data.ArticleDAOMySQL;
import fr.demos.poe.projet.librairie.metier.Article;
import fr.demos.poe.projet.librairie.metier.StockException;

/**
 * Servlet implementation class GestionRecherche
 */
@WebServlet("/GestionRecherche")
public class GestionRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String CHAMP_RECHERCHE = "rechercher";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionRecherche() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String choix = request.getParameter("choix");
		Map<String, String> erreursR = new HashMap<String, String>();

		out.println("choix : " + choix);

		if (action != null && action.equals("Rechercher")) {

			if (choix != null && choix.equals("auteur")) {

				String rechercher = request.getParameter(CHAMP_RECHERCHE);

				out.println(rechercher);

				try {

					validationRechercheAuteur(rechercher);

				} catch (Exception e) {

					String er1 = e.getMessage();
					erreursR.put(CHAMP_RECHERCHE, er1);

				}
				if (erreursR.isEmpty()) {

					request.setAttribute("erreursR", erreursR);

					try {
						ArticleDAOMySQL articleDAO = new ArticleDAOMySQL();
						session.setAttribute("mesArticles", articleDAO.select(rechercher));

						RequestDispatcher rd = request.getRequestDispatcher("/RechercheVue.jsp");
						rd.forward(request, response);

					} catch (Exception e) {

						e.printStackTrace();
					}

				} else {

					request.setAttribute("erreursR", erreursR);
					RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
					rd.forward(request, response);

				}
			}

			if (choix != null && choix.equals("genre")) {

				String rechercher = request.getParameter(CHAMP_RECHERCHE);

				out.println(rechercher);

				try {

					validationRechercheAuteur(rechercher);

				} catch (Exception e) {

					String er1 = e.getMessage();
					erreursR.put(CHAMP_RECHERCHE, er1);

				}
				if (erreursR.isEmpty()) {

					request.setAttribute("erreursR", erreursR);

					try {
						ArticleDAOMySQL articleDAO = new ArticleDAOMySQL();
						session.setAttribute("mesArticles", articleDAO.select(rechercher));

						RequestDispatcher rd = request.getRequestDispatcher("/RechercheVue.jsp");
						rd.forward(request, response);

					} catch (Exception e) {

						e.printStackTrace();
					}

				} else {

					request.setAttribute("erreursR", erreursR);
					RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
					rd.forward(request, response);

				}
			}

		}

	}

	private void validationRechercheAuteur(String rechercher) throws Exception {

		if (rechercher != null && rechercher.trim().length() < 3) {

			throw new Exception("Mot recherché trop court veuillez compléter !");

		}
	}
}
