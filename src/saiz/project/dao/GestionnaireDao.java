package saiz.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import saiz.project.pojo.Arme;
import saiz.project.pojo.Commande;
import saiz.project.pojo.Gestionnaire;

public class GestionnaireDao {
	
	public static String user = "root";
	public static String pwd = "";
	public static String url = "jdbc:mysql://localhost/e-gun?useSSL=false";
	public static String sql ="";
	public static String drive ="com.mysql.jdbc.Driver";
	
	public void afficherCommandeClient(ArrayList<Commande> commande, ArrayList<Arme> arme) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql ="select* from commande,arme where commande.idArme = arme.idArme order by commande.idCommande";
		
		try(Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
					try(ResultSet rs = pst.executeQuery()){
						while(rs.next()) {
							int idC = rs.getInt("commande.idCommande");
							int idA = rs.getInt("arme.idArme");
							String nA = rs.getString("arme.nom");
							String dC = rs.getString("commande.dateCommande");
							
							arme.add(new Arme(nA,idA));
							commande.add(new Commande(idC,dC));
						}
						
					}
		}
	}

	public void afficherCommandeTraite(ArrayList<Commande> commande, ArrayList<Arme> arme) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql ="select* from commande,arme where commande.idArme = arme.idArme and statut != 'checking' order by commande.idCommande ";
		
		try(Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			try(ResultSet rs = pst.executeQuery()){				
				while(rs.next()) {					
					int idC = rs.getInt("commande.idCommande");
					int idA = rs.getInt("arme.idArme");
					String nA = rs.getString("arme.nom");
					String dC = rs.getString("commande.dateCommande");
					
					arme.add(new Arme(nA,idA));
					commande.add(new Commande(idC,dC));
				}
			}
		}
	}
	
	public void afficherCommandeNonTraite(ArrayList<Commande> commande, ArrayList<Arme> arme) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql ="select* from commande,arme where commande.idArme = arme.idArme and statut= 'checking' order by commande.idCommande ";
		
		try(Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			try(ResultSet rs = pst.executeQuery()){				
				while(rs.next()) {					
					int idC = rs.getInt("commande.idCommande");
					int idA = rs.getInt("arme.idArme");
					String nA = rs.getString("arme.nom");
					String dC = rs.getString("commande.dateCommande");
					
					arme.add(new Arme(nA,idA));
					commande.add(new Commande(idC,dC));
				}
			}
		}
	}
	
	public void valideCommande (Commande commande,Arme arme) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql="select* from commande, client where idCommande =? ";
		
		try(Connection con =DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, commande.getIdCommande());
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					commande.setIdCommande(rs.getInt("idCommande"));
					arme.setIdArme(rs.getInt("idArme"));
					commande.setDateCommande(rs.getString("dateCommande"));
					commande.setDocument(rs.getString("document"));
				}
			}
		}	
	}
	public void getFile (Commande commande) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql="select* from commande, client where idCommande =? ";
		
		try(Connection con =DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, commande.getIdCommande());
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					commande.setDocument(rs.getString("document"));
				}
			}
		}	
	}
	
	public void connectionGestionnaire(Gestionnaire gestionnaire) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql = "select* from gestionnaire where motDePasse = ? and identifiant=?";
		
		try(Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, gestionnaire.getMotDePasse());
			pst.setString(2, gestionnaire.getIdentifiant());
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					gestionnaire.setNom(rs.getString("nom"));
				}
				
			}
		}
	}
	
	public int udpdateSatut (Commande commande) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql="update commande set statut=? where idCommande = ?";
		int rs;
		
		try(Connection con =DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, commande.getStatut());
			pst.setInt(2, commande.getIdCommande());
			
			rs = pst.executeUpdate();
		}
		return rs;
	}
}
