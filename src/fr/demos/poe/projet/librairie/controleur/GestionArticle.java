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

import fr.demos.poe.projet.librairie.metier.*;

/**
 * Servlet implementation class GestionArticle
 */
@WebServlet("/GestionArticle")
public class GestionArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String CHAMP_EMAIL = "email";
	String CHAMP_MOTDEPASSE = "motdepasse";
	String ERR = "erreurs";
	String RES = "resultat";

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
		
		
		ArrayList <Article> mesArticles= new ArrayList <Article>();
		

		Livre l1 = new Livre("123456", 10.99, "L'etranger", "Letranger.jpeg", Etat.COMME_NEUF, 10, "Camus", "Hachette");
		Livre l2 = new Livre("234567", 15.99, "Madame Bovary", "Bovary.jpg", "pdf", "url de telechargement", "Flaubert",
				"Belin");
		Livre l3 = new Livre("345678", 19.99, "Jurassic Park", "Jurassicpark.jpg", Etat.NEUF, 50, "Michael Crichton", "Pocket");
		ArticleDivers ad1 = new ArticleDivers("456789", 50.00, "Retour vers le futur", "Futur.jpg", Etat.BON_ETAT, 10, "DVD",
				"Trilogie");
		
		
		mesArticles.add(l1);
		mesArticles.add(l2);
		mesArticles.add(l3);
		mesArticles.add(ad1);
		
		
		
		request.setAttribute("mesArticles", mesArticles);
	

		RequestDispatcher rd = request.getRequestDispatcher("/Accueil.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Compte compte = new Compte("monemail@email.com", "motdepasse");
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();

		String action = request.getParameter("action");

		if (action != null && action.equals("Connexion")) {

			String email = request.getParameter(CHAMP_EMAIL);
			String motdepasse = request.getParameter(CHAMP_MOTDEPASSE);

			try {

				validationEmail(email);

			} catch (Exception e) {

				String er1 = e.getMessage();
				erreurs.put(CHAMP_EMAIL, er1);

			}

			try {
				validationMotdepasse(motdepasse);
			} catch (Exception e) {

				String er2 = e.getMessage();

				erreurs.put(CHAMP_MOTDEPASSE, er2);

			}

			if (erreurs.isEmpty()) {

				resultat = "OK: Succes de l'identification";
				request.setAttribute(ERR, erreurs);
				request.setAttribute(RES, resultat);

				RequestDispatcher rd = request.getRequestDispatcher("/Accueil.jsp");
				rd.forward(request, response);
				return;

			} else {

				resultat = "KO: Echec de l'identification";

				request.setAttribute(ERR, erreurs);
				request.setAttribute(RES, resultat);

				RequestDispatcher rd = request.getRequestDispatcher("/Accueil.jsp");
				rd.forward(request, response);
				return;
			}
		}
	}

	private void validationEmail(String email) throws Exception {

		if (email != null && email.trim().length() != 0) {

			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {

				throw new Exception("! Merci de saisir une adresse mail valide.");

			}

		} else {

			throw new Exception("! Merci de saisir une adresse mail.");

		}
	

	}

	private void validationMotdepasse(String motdepasse) throws Exception {

		if (motdepasse != null && motdepasse.trim().length() < 1) {

			throw new Exception("! Veuillez vérifier votre mot de passe");

		}
	}
}
