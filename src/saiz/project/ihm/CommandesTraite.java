package saiz.project.ihm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saiz.project.dao.GestionnaireDao;
import saiz.project.pojo.Arme;
import saiz.project.pojo.Commande;

/**
 * Servlet implementation class CommandeTraite
 */
@WebServlet("/CommandeTraite")
public class CommandesTraite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<Commande> commande = new ArrayList<Commande>();
	GestionnaireDao gestionnaireDao = new GestionnaireDao();
	ArrayList<Arme> arme = new ArrayList<Arme>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandesTraite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/afficheCommandeTraite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		arme.clear();
		commande.clear();
		try {
			gestionnaireDao.afficherCommandeTraite(commande, arme);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("arme", arme);
		request.setAttribute("commande", commande);
	
		doGet(request, response);
	}

}
