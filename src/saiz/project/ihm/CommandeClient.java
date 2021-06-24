package saiz.project.ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saiz.project.dao.CommandeDao;
import saiz.project.metier.ArmeForm;
import saiz.project.metier.ClientForm;
import saiz.project.pojo.Arme;
import saiz.project.pojo.Client;
import saiz.project.pojo.Commande;

/**
 * Servlet implementation class CommandeClient
 */
@WebServlet("/commandeClient")
public class CommandeClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	Client client = new Client();
	ClientForm clientForm = new ClientForm();
	ArmeForm armeForm = new ArmeForm();
	ArrayList<Commande> commande = new ArrayList<Commande>();
	CommandeDao commandeDao = new CommandeDao();
	ArrayList<Arme> arme = new ArrayList<Arme>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect(request.getContextPath()+"/afficheCommande.jsp");
		this.getServletContext().getRequestDispatcher("/afficheCommande.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			try {
				clientForm.getIDC(client);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			arme.clear();
			commande.clear();
			try {
				commandeDao.selectCommande(commande, client, arme);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		request.setAttribute("arme", arme);
		request.setAttribute("commande", commande);
		
		doGet(request, response);
	}

}
