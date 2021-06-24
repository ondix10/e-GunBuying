package saiz.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import saiz.project.pojo.Arme;
import saiz.project.pojo.Client;
import saiz.project.pojo.Commande;

public class CommandeDao {
	
	public static String user = "root";
	public static String pwd = "";
	public static String url = "jdbc:mysql://localhost/e-gun?useSSL=false";
	public static String sql ="";
	public static String drive ="com.mysql.jdbc.Driver";
	
	public void selectCommandePdf(Client client, PdfPTable table) throws ClassNotFoundException, SQLException {
		
		Class.forName(drive);
		sql="select* from commande,arme where commande.idClient=? and commande.idArme = arme.idArme order by commande.dateCommande";

		try(Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, client.getIdClient());
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					String nomA = rs.getString("arme.nom");
					double prixA = rs.getDouble("arme.prix");
					String prix = String.valueOf(prixA);
					int quantC = rs.getInt("commande.quantite");
					String quant = String.valueOf(quantC);
					String dateC = rs.getString("commande.dateCommande");
					String statut = rs.getString("commande.statut");
					PdfPCell cell1 = new PdfPCell(new Paragraph(nomA));
					PdfPCell cell2 = new PdfPCell(new Paragraph(prix));
					PdfPCell cell3 = new PdfPCell(new Paragraph(quant));
					PdfPCell cell4 = new PdfPCell(new Paragraph(dateC));
					PdfPCell cell5 = new PdfPCell(new Paragraph(statut));
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
				}
			}
		}
	}

	public int insertCommande(Commande commande) throws ClassNotFoundException, SQLException {
		
		Class.forName(drive);
		sql = "insert into commande(idArme,idClient,dateCommande,quantite,document) values(?,?,Now(),?,?)";
		
		int rs=0;
		
		try(Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, commande.getArme().getIdArme());
			pst.setInt(2, commande.getClient().getIdClient());
			pst.setInt(3, commande.getQuantite());
			pst.setString(4, commande.getDocument());
			
			rs = pst.executeUpdate();
			}
		
		return rs;
	}

	public int selectIdArme(Arme arme) throws ClassNotFoundException, SQLException {
		
		Class.forName(drive);
		sql="select* from arme where nom=?";
		int idA = 0;
		
		try(Connection con = DriverManager.getConnection(url,user,pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, arme.getNom());
			
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					arme.setIdArme(rs.getInt("idArme"));
					idA = arme.getIdArme();
				}
			}
			
		}
		return idA;
		
	}
	
public double selectPrixArme(Arme arme) throws ClassNotFoundException, SQLException {
		
		Class.forName(drive);
		sql="select* from arme where nom=?";
		double prix = 0;
		
		try(Connection con = DriverManager.getConnection(url,user,pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, arme.getNom());
			
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					arme.setPrix(rs.getDouble("prix"));
					prix = arme.getPrix();
				}
			}
			
		}
		return prix;
		
	}

	public void selectCommande(ArrayList<Commande> commande, Client client, ArrayList<Arme> arme) throws ClassNotFoundException, SQLException {
		
		Class.forName(drive);
		sql="select* from commande,arme where commande.idClient=? and commande.idArme = arme.idArme order by commande.idCommande";
		
		try(Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, client.getIdClient());
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					String nomA = rs.getString("arme.nom");
					double prixA = rs.getDouble("arme.prix");
					int quantC = rs.getInt("commande.quantite");
					String dateC = rs.getString("commande.dateCommande");
					String statut = rs.getString("commande.statut");
					arme.add(new Arme(nomA,prixA));
					commande.add(new Commande(dateC,quantC,statut));					
				}
			}
			
		}
	}
	
	public int selectQuant(Arme arme) throws ClassNotFoundException, SQLException {
		
		Class.forName(drive);
		sql="select* from arme where idArme=?";
		int qAct = 0;
		
		try(Connection con = DriverManager.getConnection(url,user,pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, arme.getIdArme());
			
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					arme.setQuantiteActuelle(rs.getInt("quantiteActuelle"));
					qAct = arme.getQuantiteActuelle();
				}
			}		
		}
		return qAct;
	}
	
	public int updateQuant(Arme arme) throws ClassNotFoundException, SQLException {
		
		Class.forName(drive);
		sql="update arme set quantiteActuelle=? where idArme=?";
		int rs=0;
	
		try(Connection con = DriverManager.getConnection(url,user,pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, arme.getQuantiteActuelle());
			pst.setInt(2, arme.getIdArme());	
			
			rs = pst.executeUpdate();
			
		}
		return rs;
	}
	
	

}
