package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import controllers.GestionConnexion;

@WebServlet("/connexion")
public class Connexion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_CLIENT = "client";
	public static final String ATT_CONNEXION = "connexion";
	public static final String ATT_SESSION_CLIENT = "sessionClient";
	public static final String VUE = "/connexion.jsp";
	public static final String HOME_SERVLET = "homeservlet";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet de gestion du formulaire de connexion */
		GestionConnexion gestionConnexion = new GestionConnexion();

		/* Traitement de la requête et récupération du bean */
		Client client = gestionConnexion.connectClient(request);

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();

		
		/* Stockage du formulaire et du bean dans l'objet request */
		request.setAttribute( ATT_CONNEXION, gestionConnexion );
		request.setAttribute( ATT_CLIENT, client );
		/**
		 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
		 * Utilisateur à la session, sinon suppression du bean de la session.
		 */
		if (gestionConnexion.getErreurs().isEmpty()) {
			session.setAttribute(ATT_SESSION_CLIENT, client);
			response.sendRedirect(HOME_SERVLET);
		} else {
			session.setAttribute(ATT_SESSION_CLIENT, null);
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}

		request.setAttribute(ATT_CONNEXION, gestionConnexion);
		request.setAttribute(ATT_CLIENT, client);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}
}
