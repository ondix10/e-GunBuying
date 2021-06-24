package saiz.project.ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saiz.project.dao.ClientDao;
import saiz.project.metier.ClientForm;
import saiz.project.pojo.Client;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/creationClient")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONNECT = "/createAccount.jsp";
	private static final String CONNECT2 = "/createAccount2.jsp";
	private static final String FORM = "form";
	
	Client client = new Client();
	ClientDao clientDao = new ClientDao();
	ClientForm clientForm = new ClientForm();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(CONNECT).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		clientForm.getErreur().clear();
		
		client = clientForm.insertClient(request);
		
		request.setAttribute(FORM, clientForm);
		
		if (clientForm.getErreur().isEmpty()) {
			try {
				clientDao.insertClient(client);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			this.getServletContext().getRequestDispatcher( CONNECT2 ).forward( request, response );
		}else {
			doGet(request, response);
		}
		 
	}

}
