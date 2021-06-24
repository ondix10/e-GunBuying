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

import saiz.project.dao.ClientDao;
import saiz.project.metier.ClientForm;
import saiz.project.pojo.Client;

/**
 * Servlet implementation class ModifyProfil
 */
@WebServlet("/modifyProfil")
@MultipartConfig
public class ModifyProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClientForm clientForm = new ClientForm();
	Client client = new Client();
	ClientDao clientDao = new ClientDao();
	
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/profil2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String biographie = request.getParameter("biographie");
		Part photo = request.getPart("photo");
		String sexe = request.getParameter("sexe");
		
		try {
			clientForm.getIDC(client);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(photo != null) {
			
			String imageFileName = photo.getSubmittedFileName();
			String uploadName = "C:/Users/Sabwe Saiz/eclipse-workspaceJavaEE3/e-GunBuying/WebContent/pic/"+ imageFileName;
			client.setPhoto(imageFileName);
			
			try {
				FileOutputStream fos = new FileOutputStream(uploadName);
				InputStream ips = photo.getInputStream();
				
				byte[] data = new byte[ips.available()];
				ips.read(data);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				clientDao.changerPhoto(client);
				request.setAttribute("client", client);
				doGet(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(biographie != null) {
			client.setBiographie(biographie);
			try {
				clientDao.changerBio(client);
				request.setAttribute("client", client);
				doGet(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(sexe != null) {
			client.setSexe(sexe);
			try {
				clientDao.changerGenre(client);
				request.setAttribute("client", client);
				doGet(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

}
