package meissa.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meissa.beans.Client;
import meissa.managers.ClientManager;
import meissa.metier.ClientValidator;

/**
 * @author papihack
 * @since 07/02/20
 * @version 0.1.0
 * 
 *          Cette servlet représente le controller de l'application.
 */
@WebServlet(description = "Servlet or Controller that allow CRUD operations on client entity", urlPatterns =
{ "/home", "/client", "/about", "/client/add", "/client/list", "/client/update", "/client/delete" })
public class ClientController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private String VUE_AJOUT_AND_UPDATE = "/WEB-INF/client/addClient.jsp";
	private String VUE_LIST = "/WEB-INF/client/listClient.jsp";
	private String VUE_ACCUEIL = "/WEB-INF/Accueil.jsp";
	private String VUE_ABOUT = "/WEB-INF/About.jsp";
	
	private ClientManager clientManager = new ClientManager();
	private HashMap<String, String> validationResult = null;
	private ClientValidator clientValidator = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String path = request.getServletPath();
		// System.out.println("PATH == " + path);
		switch (path)
		{
			case "/home":
			case "/client":
			case "/client/":
				this.getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
				break;
			case "/client/add":
				request.setAttribute("update", "add");
				this.getServletContext().getRequestDispatcher(VUE_AJOUT_AND_UPDATE).forward(request, response);
				break;
			case "/client/update":
				request.setAttribute("update", "update");
				Client client = this.clientManager.get(Integer.parseInt(request.getParameter("c")));
				if (client == null)
				{
					request.setAttribute("clients", this.clientManager.getAll());
					this.getServletContext().getRequestDispatcher(VUE_LIST).forward(request, response);
				}
				request.setAttribute("client", client);
				this.getServletContext().getRequestDispatcher(VUE_AJOUT_AND_UPDATE).forward(request, response);
				break;
			case "/client/list":
				request.setAttribute("clients", this.clientManager.getAll());
				this.getServletContext().getRequestDispatcher(VUE_LIST).forward(request, response);
				break;
			case "/about":
				this.getServletContext().getRequestDispatcher(VUE_ABOUT).forward(request, response);
				break;
			case "/client/delete":
				if (this.clientManager.get(Integer.parseInt(request.getParameter("c"))) == null)
				{
					request.setAttribute("clients", this.clientManager.getAll());
					this.getServletContext().getRequestDispatcher(VUE_LIST).forward(request, response);
				}
				this.clientManager.delete(Integer.parseInt(request.getParameter("c")));
				request.setAttribute("clients", this.clientManager.getAll());
				response.sendRedirect("list");
				break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String path = request.getServletPath();
		Client client = null;
		switch (path)
		{
			case "/client/add":
				client = new Client(request.getParameter("nom"), request.getParameter("prenom"),
						request.getParameter("email"), request.getParameter("adresse"),
						request.getParameter("telephone"));
				// Valider le client ici avant insertion
				this.clientValidator = new ClientValidator(client);
				this.validationResult = this.clientValidator.validate();
				if (!this.validationResult.isEmpty())
				{
					request.setAttribute("errors", this.validationResult);
					request.setAttribute("client", client);
					request.setAttribute("update", "add");
					this.getServletContext().getRequestDispatcher(VUE_AJOUT_AND_UPDATE).forward(request, response);
				}
				else
				{
					this.clientManager.add(client);
					request.setAttribute("clients", this.clientManager.getAll());
					response.sendRedirect("list");
				}
				break;
			case "/client/update":
				client = this.clientManager.get(Integer.parseInt(request.getParameter("c")));
				client.setNom(request.getParameter("nom"));
				client.setPrenom(request.getParameter("prenom"));
				client.setEmail(request.getParameter("email"));
				client.setAdresse(request.getParameter("adresse"));
				client.setTelephone(request.getParameter("telephone"));
				// Valider le client ici avant insertion
				this.clientValidator = new ClientValidator(client);
				this.validationResult = this.clientValidator.validate();
				if (!this.validationResult.isEmpty())
				{
					request.setAttribute("errors", this.validationResult);
					request.setAttribute("client", client);
					request.setAttribute("update", "update");
					this.getServletContext().getRequestDispatcher(VUE_AJOUT_AND_UPDATE).forward(request, response);
				}
				else
				{
					this.clientManager.update(client);
					request.setAttribute("clients", this.clientManager.getAll());
					response.sendRedirect("list");
				}
				break;
		}
		
	}
	
}
