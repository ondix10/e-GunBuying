package saiz.project.ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import saiz.project.dao.GestionnaireDao;
import saiz.project.metier.GestionnaireForm;
import saiz.project.pojo.Gestionnaire;

/**
 * Servlet implementation class ProfilGest
 */
@WebServlet("/ProfilGest")
public class ProfilGest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Gestionnaire gestionnaire = new Gestionnaire();
	GestionnaireDao gestionnaireDao = new GestionnaireDao();
	GestionnaireForm gestionnaireForm = new GestionnaireForm();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilGest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		gestionnaire = gestionnaireForm.connectGestionnaire(request);
		
		HttpSession sess = request.getSession();
		
		try {
			gestionnaireDao.connectionGestionnaire(gestionnaire);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//doGet(request, response);
		}
		
		sess.setAttribute("gestionnaire", gestionnaire);
		
		this.getServletContext().getRequestDispatcher("/profilGest.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
