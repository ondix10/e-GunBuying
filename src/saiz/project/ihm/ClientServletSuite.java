package saiz.project.ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import saiz.project.dao.ClientDao;
import saiz.project.metier.ClientForm;
import saiz.project.pojo.Client;

/**
 * Servlet implementation class ClientServletSuite
 */
@WebServlet("/creationClientSuite")
public class ClientServletSuite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String FORM = "form";
	
	private static final String CONNECT2 = "/createAccount2.jsp";
	private static final String SUCCES = "http://localhost:8080/e-GunBuying/Enregistrer.jsp";
	
	
	Client client = new Client();
	ClientDao clientDao = new ClientDao();
	ClientForm clientForm = new ClientForm();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServletSuite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( CONNECT2 ).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		clientForm.getErreur().clear();
		
		client = clientForm.updateInsertClient(request);
		HttpSession s = request.getSession();
		
		String id = client.getIdentifiant();
		
		request.setAttribute(FORM, clientForm);
		s.setAttribute("id", id);
		
		
		if (clientForm.getErreur().isEmpty()) {
			try {
				clientDao.updateInsertClient(client);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			response.sendRedirect(SUCCES);
			
		}else {
			doGet(request, response);
		}
		
	}

}
