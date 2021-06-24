package saiz.project.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saiz.project.dao.ClientDao;
import saiz.project.dao.CommandeDao;
import saiz.project.metier.ClientForm;
import saiz.project.metier.CommandeForm;
import saiz.project.pojo.Arme;
import saiz.project.pojo.Client;
import saiz.project.pojo.Commande;

/**
 * Servlet implementation class ConfirmationCommande
 */
@WebServlet("/ConfirmationCommande")
public class ConfirmationCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Arme arme = new Arme();
	Client client = new Client();
	ClientDao clientDao = new ClientDao();
	ClientForm clientForm = new ClientForm();	
	Commande commande = new Commande();
	CommandeDao commandeDao = new CommandeDao();
	CommandeForm commandeForm = new CommandeForm();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmationCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		double tva,total,som;
		
		commandeForm.confirmationCommande(request, commande, arme);
		
		total = (arme.getPrix() * commande.getQuantite());
		tva = 16 * total / 100;
		som = total + tva; 
		
		request.setAttribute("nom", arme.getNom());
		request.setAttribute("prix", arme.getPrix());
		request.setAttribute("quantite", commande.getQuantite());
		request.setAttribute("taxe", tva);
		request.setAttribute("somme", som);
		
		this.getServletContext().getRequestDispatcher("/confirmation.jsp").forward(request, response);
				
	}

}
