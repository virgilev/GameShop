package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;
import beans.Client;
import beans.Game;
import dao.GameDao;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cartservlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_CLIENT = "sessionClient";
	public static final String HOME_SERVLET = "homeservlet";
	public static final String ATT_GAME_TITLE = "title"; 
	public static final String ATT_GAME_CONSOLE = "console";
//	public static final String ATT_CLIENT = "client";
	public static final String ATT_FLAG = "flag";
	public static final String VUE = "/panier.jsp";
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute(ATT_SESSION_CLIENT);
		String flag = request.getParameter(ATT_FLAG);
		if (client == null){
			response.sendRedirect(HOME_SERVLET);
		}
		else if (flag.equals("add")){
			String title = request.getParameter(ATT_GAME_TITLE);
			String console = request.getParameter(ATT_GAME_CONSOLE);
			Game game = GameDao.findSQL(title, console);
			Cart cart = client.getCart();
			cart.addGame(game);
			client.setCart(cart);
//			request.setAttribute(ATT_CLIENT, client);
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
		else if (flag.equals("del")){
			String title = request.getParameter(ATT_GAME_TITLE);
			String console = request.getParameter(ATT_GAME_CONSOLE);
			Game game = GameDao.findSQL(title, console);
			Cart cart = client.getCart();
			cart.removeGame(game);
			client.setCart(cart);
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
		else if (flag.equals("view")){
//			String title = request.getParameter(ATT_GAME_TITLE);
//			String console = request.getParameter(ATT_GAME_CONSOLE);
//			Game game = GameDao.findSQL(title, console);
//			Cart cart = client.getCart();
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
