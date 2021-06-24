package saiz.project.document;

import java.awt.Desktop;
import java.io.File;
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
 * Servlet implementation class PermisPdf
 */
@WebServlet("/PermisPdf")
public class PermisPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Commande commande = new Commande();
	GestionnaireForm gestionnaireForm = new GestionnaireForm();
	GestionnaireDao gestionnaireDao = new GestionnaireDao();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PermisPdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/pdf");
		
		gestionnaireForm.recupId(commande);
		
		try {
			gestionnaireDao.getFile(commande);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String pdfPath = "C:/Users/Sabwe Saiz/eclipse-workspaceJavaEE3/e-GunBuying/WebContent/docPdf/"+commande.getDocument();
		
		try {
			File pdfFile = new File(pdfPath);
			Desktop.getDesktop().open(pdfFile);
			
		}catch (Exception e) {
			e.printStackTrace();
		} 		
		
		this.getServletContext().getRequestDispatcher("/profilGest.jsp").forward(request, response);
		
				 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
