package saiz.project.document;

import java.io.IOException;
import java.io.OutputStream;

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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import saiz.project.dao.CommandeDao;
import saiz.project.metier.ClientForm;
import saiz.project.pojo.Client;

/**
 * Servlet implementation class Pdf
 */
@WebServlet("/pdf")
public class Pdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommandeDao dao = new CommandeDao();
	Client client = new Client();
	ClientForm clientForm = new ClientForm();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pdf() {
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
		
		String txt ="Merci de nous avoir choisi, Nous esperons vous revoir!";
				
		try {
			
			try {
				Document document = new Document();
				PdfWriter.getInstance(document, out);
				
				document.open();
				
				Image ico = Image.getInstance("C:\\Users\\Sabwe Saiz\\eclipse-workspaceJavaEE3\\e-GunBuying\\WebContent\\favicon.png");
				ico.setAlignment(Element.ALIGN_LEFT);
				ico.scaleToFit(40, 30);
				
				document.add(ico);
				
				Paragraph par = new Paragraph();				
				Font font = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.CYAN);				
				par.add(new Phrase(Chunk.NEWLINE));
				par.add(new Phrase("RAPPORT COMMANDE",font));
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
				
				PdfPTable table = new PdfPTable(5);
				PdfPCell cell1 = new PdfPCell(new Paragraph("Arme"));
				PdfPCell cell2 = new PdfPCell(new Paragraph("Prix"));
				PdfPCell cell3 = new PdfPCell(new Paragraph("Quantite"));
				PdfPCell cell4 = new PdfPCell(new Paragraph("Date"));
				PdfPCell cell5 = new PdfPCell(new Paragraph("Statut"));
				
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
				
				clientForm.getIDC(client);
				dao.selectCommandePdf(client, table);
				
				document.add(table);
				
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
