package saiz.project.ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saiz.project.dao.GestionnaireDao;
import saiz.project.metier.GestionnaireForm;
import saiz.project.pojo.Commande;

/**
 * Servlet implementation class StatutCommande
 */
@WebServlet("/StatutCommande")
public class StatutCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Commande commande = new Commande();
	GestionnaireDao gestionnaireDao = new GestionnaireDao();
	GestionnaireForm gestionnaireForm = new GestionnaireForm();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatutCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath()+"/ProfilGest");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String valide =request.getParameter("valide");
		commande.setStatut(valide);
		
		gestionnaireForm.recupId(commande);
		
		try {
			gestionnaireDao.udpdateSatut(commande);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
		doGet(request, response);
	}

}
