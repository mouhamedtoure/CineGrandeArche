package fr.demos.poe.projet.librairie.bdd;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionTestJDBC
 */
@WebServlet("/GestionTestJDBC")
public class GestionTestJDBC extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	 public static final String ATT_MESSAGES ="messages";

	    public static final String VUE="/test_jdbc.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionTestJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Initialisation de l'objet Java et r�cup�ration des messages */

        TestJDBC test = new TestJDBC();

        List<String> messages = test.executerTests( request );


        /* Enregistrement de la liste des messages dans l'objet requ�te */

        request.setAttribute( ATT_MESSAGES, messages );


        /* Transmission vers la page en charge de l'affichage des r�sultats */

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
