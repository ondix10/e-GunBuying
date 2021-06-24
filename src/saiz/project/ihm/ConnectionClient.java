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
 * Servlet implementation class ConnectionClient
 */
@WebServlet("/ConnectionClient")
public class ConnectionClient extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ClientDao dao = new ClientDao();
	Client client = new Client();
	ClientForm clientForm = new ClientForm();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/toConnecte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		client = clientForm.connectInsertClient(request);
		
		HttpSession ss = request.getSession();
		
		try {
			dao.connectClient(client);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			//this.getServletContext().getRequestDispatcher("/toConnecte.jsp").forward(request, response);
			doGet(request, response);
		}		
		
		ss.setAttribute("client", client);
		
		//response.sendRedirect("http://localhost:8080/e-GunBuying/profil.jsp");
		response.sendRedirect(request.getContextPath()+"/Profil");
	}

}
