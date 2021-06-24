package saiz.project.ihm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import saiz.project.dao.CommandeDao;
import saiz.project.metier.ClientForm;
import saiz.project.metier.CommandeForm;
import saiz.project.pojo.Arme;
import saiz.project.pojo.Client;
import saiz.project.pojo.Commande;

/**
 * Servlet implementation class FinalisationCommande
 */
@WebServlet("/FinalisationCommande")
@MultipartConfig
public class FinalisationCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Arme arme = new Arme();
	CommandeDao commandeDao = new CommandeDao();
	Commande commande = new Commande();
	Client client = new Client();
	ClientForm form = new ClientForm();
	CommandeForm commandeForm = new CommandeForm();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalisationCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.sendRedirect(request.getContextPath()+"/CreationCommande");
		this.getServletContext().getRequestDispatcher("/arme.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Part pdf = request.getPart("permis");
		String pdfFileName = pdf.getSubmittedFileName();
				
		String uploadFile = "C:/Users/Sabwe Saiz/eclipse-workspaceJavaEE3/e-GunBuying/WebContent/docPdf/"+ pdfFileName;
		
		try {
			FileOutputStream fos = new FileOutputStream(uploadFile);
			InputStream ips = pdf.getInputStream();
			
			byte[] data = new byte[ips.available()];
			ips.read(data);
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		commande.setDocument(pdfFileName);
		
		if(request.getParameter("annulation")!= null) {		
			
			doGet(request, response);
		}	
		else {
		commandeForm.achatCommande(request,commande,arme);
		
		try {
			form.getIDC(client);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		commande.setArme(arme);
		commande.setClient(client);
		
		try {
			commandeDao.insertCommande(commande);
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		response.sendRedirect(request.getContextPath()+"/FacturePdf");
		}
	}

}
