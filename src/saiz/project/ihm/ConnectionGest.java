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
 * Servlet implementation class ConnectionGest
 */
@WebServlet("/ConnectionGest")
public class ConnectionGest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Gestionnaire gestionnaire = new Gestionnaire();
	GestionnaireDao gestionnaireDao = new GestionnaireDao();
	GestionnaireForm gestionnaireForm = new GestionnaireForm();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionGest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/toConnecteGest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		gestionnaire = gestionnaireForm.connectInsertGestionnaire(request);
		
		HttpSession sess = request.getSession(true);
		
		try {
			gestionnaireDao.connectionGestionnaire(gestionnaire);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			doGet(request, response);
		
		}
		
		String nom = gestionnaire.getNom() ;
		
		if( nom  != null) {
			sess.setAttribute("gestionnaire", gestionnaire);
			response.sendRedirect(request.getContextPath()+"/ProfilGest");
		}else {doGet(request, response);}
		
		
		
		//response.sendRedirect("http://localhost:8080/e-GunBuying/profil.jsp");
		
		
		
		
	}

}
