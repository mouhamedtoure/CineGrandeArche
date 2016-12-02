package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;
import java.util.ArrayList;

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
	
	
	String CHAMP_RECHERCHE = "recherche";

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

		
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		if (action != null && action.equals("Rechercher")) {

		
		String rechercher = request.getParameter(CHAMP_RECHERCHE);
		
		try {
			
			ArticleDAOMySQL articleDAO= new ArticleDAOMySQL();
			session.setAttribute("mesArticles", articleDAO.select("camus"));
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		}
		RequestDispatcher rd = request.getRequestDispatcher("/RechercheVue.jsp");
		rd.forward(request, response);

	
	

}
}