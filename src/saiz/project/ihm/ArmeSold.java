package saiz.project.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saiz.project.dao.CommandeDao;
import saiz.project.pojo.Arme;
import saiz.project.pojo.Commande;


/**
 * Servlet implementation class ArmeSold
 */
@WebServlet("/armeSold")
public class ArmeSold extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Arme arme = new Arme();
	CommandeDao commandeDao = new CommandeDao();
	Commande commande = new Commande();
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArmeSold() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/arme.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nArme = request.getParameter("arme");
		arme.setNom(nArme);
		int nQuant = Integer.parseInt(request.getParameter("quantite"));
		commande.setQuantite(nQuant);
		
		
		try {
			commandeDao.selectIdArme(arme);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commande.setArme(arme);
		
		try {
			commandeDao.insertCommande(commande);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		response.sendRedirect(request.getContextPath()+"/Enregistrer.jsp");
	}

}
 