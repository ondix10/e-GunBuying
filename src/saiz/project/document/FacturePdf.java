package saiz.project.document;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import saiz.project.dao.ClientDao;
import saiz.project.metier.ClientForm;
import saiz.project.metier.CommandeForm;
import saiz.project.pojo.Arme;
import saiz.project.pojo.Client;
import saiz.project.pojo.Commande;

/**
 * Servlet implementation class Pdf
 */
@WebServlet("/FacturePdf")
public class FacturePdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Arme arme = new Arme();
	Commande commande = new Commande();
	CommandeForm commandeForm = new CommandeForm();
	Client client = new Client();
	ClientDao clientDao = new ClientDao();
	ClientForm clientForm = new ClientForm();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturePdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		
		try {
			clientForm.getIDC(client);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			clientDao.getNameClient(client);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		commandeForm.pdfCommande(request, commande, arme);
		
		double tva,total,som;
		
		total = (arme.getPrix() * commande.getQuantite());
		tva = 16 * total / 100;
		som = total + tva; 
		
		String txt ="Merci de nous avoir choisi, Nous esperons vous revoir!";
		String txt2 ="Informations Relative à l'Achat :";
				
		try {
			
			try {
				Document document = new Document();
				PdfWriter.getInstance(document, out);
				
				document.open();
				
				Image ico = Image.getInstance("C:\\Users\\Sabwe Saiz\\eclipse-workspaceJavaEE3\\e-GunBuying\\WebContent\\favicon.png");
				ico.setAlignment(Element.ALIGN_LEFT);
				ico.scaleToFit(40, 30);
				
				document.add(ico);
				
				Paragraph date = new Paragraph();
				date.add(new Phrase());
				date.setAlignment(Element.ALIGN_RIGHT);
				date.add(new Phrase(Chunk.NEWLINE));
				date.add(new Phrase(Chunk.NEWLINE));
				
				
				document.add(date);
				
				Paragraph par = new Paragraph();				
				Font font = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLACK);				
				par.add(new Phrase(Chunk.NEWLINE));
				par.add(new Phrase("RAPPORT Achat",font));
				par.setAlignment(Element.ALIGN_CENTER); 				
				par.add(new Phrase(Chunk.NEWLINE));
				par.add(new Phrase(Chunk.NEWLINE));
				par.add(new Phrase(Chunk.NEWLINE));
				
				document.add(par);
				
				Paragraph par1 = new Paragraph();				
				par1.add(new Phrase(txt)); 	
				par1.setAlignment(Element.ALIGN_CENTER);
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase(Chunk.NEWLINE));
				
				document.add(par1);
				
				Paragraph par2 = new Paragraph();				
				par2.add(new Phrase(txt2)); 	
				par2.setAlignment(Element.ALIGN_CENTER);
				par2.add(new Phrase(Chunk.NEWLINE));
				par2.add(new Phrase(Chunk.NEWLINE));
				
				document.add(par2);
				
				Paragraph nom = new Paragraph();
				nom.add(new Phrase("Nom Client: "+client.getNom()));
				nom.setAlignment(Element.ALIGN_CENTER);
				nom.add(new Phrase(Chunk.NEWLINE));
				
				document.add(nom);
				
				Paragraph nArme = new Paragraph();
				nArme.add(new Phrase("Nom Arme: "+arme.getNom()));
				nArme.setAlignment(Element.ALIGN_CENTER);
				nArme.add(new Phrase(Chunk.NEWLINE));
				
				document.add(nArme);
				
				Paragraph pArme = new Paragraph();
				pArme.add(new Phrase("Prix Arme: "+String.valueOf(arme.getPrix())));
				pArme.setAlignment(Element.ALIGN_CENTER);
				pArme.add(new Phrase(Chunk.NEWLINE));
				
				document.add(pArme);
				
				Paragraph qArme = new Paragraph();
				qArme.add(new Phrase("Quantite: "+String.valueOf(commande.getQuantite())));
				qArme.setAlignment(Element.ALIGN_CENTER);
				qArme.add(new Phrase(Chunk.NEWLINE));
				
				document.add(qArme);
				
				Paragraph taxe = new Paragraph();
				taxe.add(new Phrase("Taxe: "+String.valueOf(tva)));
				taxe.setAlignment(Element.ALIGN_CENTER);
				taxe.add(new Phrase(Chunk.NEWLINE));
				
				document.add(taxe);
				
				Paragraph tot = new Paragraph();
				tot.add(new Phrase("Total: "+String.valueOf(som)));
				tot.setAlignment(Element.ALIGN_CENTER);
				tot.add(new Phrase(Chunk.NEWLINE));
				
				document.add(tot);
				
				Paragraph blanck = new Paragraph();
				blanck.add(new Phrase(Chunk.NEWLINE));
				blanck.add(new Phrase(Chunk.NEWLINE));
				
				document.add(blanck);
				
				Paragraph name = new Paragraph();
				Font font1 = new Font(Font.FontFamily.TIMES_ROMAN,14,Font.ITALIC,BaseColor.BLACK);
				name.add(new Phrase("Saiz SABWE",font1));
				par.add(new Phrase(Chunk.NEWLINE));
				name.add(new Phrase(Chunk.NEWLINE));
				name.add(new Phrase("Product Manager",font1));
				name.setAlignment(Element.ALIGN_RIGHT);
				
				document.add(name);
				
				
				Image sign = Image.getInstance("C:\\Users\\Sabwe Saiz\\Documents\\sign.jpg");
				sign.setAlignment(Element.ALIGN_BOTTOM);
				sign.scaleToFit(100, 110);
				
				document.add(sign);
				
				document.close(); 
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		} finally {
			out.close();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//doGet(request, response);
	}

}
