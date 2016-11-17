package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();

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
