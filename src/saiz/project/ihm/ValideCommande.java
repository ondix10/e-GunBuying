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
import saiz.project.pojo.Arme;
import saiz.project.pojo.Commande;

/**
 * Servlet implementation class ValideCommande
 */
@WebServlet("/ValideCommande")
public class ValideCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Arme arme = new Arme();
	Commande commande = new Commande();
	GestionnaireForm gestionnaireForm = new GestionnaireForm();
	GestionnaireDao gestionnaireDao = new GestionnaireDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValideCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath()+"/statutCommande.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		gestionnaireForm.achatCommande(request, commande);
		
		try {
			gestionnaireDao.valideCommande(commande,arme);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			doGet(request, response);
		}
		
		int idC = commande.getIdCommande();
		int idA = arme.getIdArme();
		String dC = commande.getDateCommande();
		String doc = commande.getDocument();
		
		/*System.out.println(idC);
		System.out.println(idA);
		System.out.println(dC);
		System.out.println(doc);*/
		
		request.setAttribute("idc", idC);
		request.setAttribute("ida", idA);
		request.setAttribute("dc", dC);
		request.setAttribute("doc", doc);
		
		this.getServletContext().getRequestDispatcher("/statutCommande.jsp").forward(request, response);
		
		
	}

}
