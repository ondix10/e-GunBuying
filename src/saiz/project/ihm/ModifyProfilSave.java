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
 * Servlet implementation class ModifyProfilSave
 */
@WebServlet("/ModifyProfilSave")
public class ModifyProfilSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Client client = new Client();
	ClientDao clientDao = new ClientDao();
	ClientForm clientForm = new ClientForm();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyProfilSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		try {
			clientForm.getMedia(client);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		ss.setAttribute("client", client);
		
		response.sendRedirect(request.getContextPath()+"/profil.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
