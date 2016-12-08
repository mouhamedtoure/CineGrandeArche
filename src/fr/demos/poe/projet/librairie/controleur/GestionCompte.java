package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;
import java.io.PrintWriter;
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
import fr.demos.poe.projet.librairie.data.CompteDAO;
import fr.demos.poe.projet.librairie.data.CompteDAOMySQL;
import fr.demos.poe.projet.librairie.metier.Compte;

/**
 * Servlet implementation class GestionCompte
 */
@WebServlet("/GestionCompte")
public class GestionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String CHAMP_EMAIL = "email";
	String CHAMP_MOTDEPASSE = "motdepasse";
	String ERR = "erreurs";
	String RES = "resultat";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionCompte() {
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
		CompteDAOMySQL compteDAO = new CompteDAOMySQL();

		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();

		PrintWriter out = response.getWriter();


		if (action != null && action.equals("Deconnexion")) {

			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
			rd.forward(request, response);

		}

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

				try {
					Authentification(email, motdepasse);

					session.setAttribute("monCompte", compteDAO.select(email, motdepasse));

				}

				catch (Exception e1) {

					e1.printStackTrace();
				}

				RequestDispatcher rd = request.getRequestDispatcher("/CompteVue.jsp");
				rd.forward(request, response);

			} else {

				resultat = "KO: Echec de l'identification";

				request.setAttribute(ERR, erreurs);
				request.setAttribute(RES, resultat);

				RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
				rd.forward(request, response);

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

	private void Authentification(String email, String motdepasse) throws Exception {

		Compte compteTest = CompteDAO.select(email, motdepasse);
		if (!compteTest.getEmail().equals(email) && !compteTest.getMotdepasse().equals(motdepasse)) {

			throw new Exception("Combinaison mot de passe invalide!");

		}
	}

}
