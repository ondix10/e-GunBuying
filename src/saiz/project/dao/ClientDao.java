package saiz.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import saiz.project.pojo.Client;


public class ClientDao {
	
	public static String user = "root";
	public static String pwd = "";
	public static String url = "jdbc:mysql://localhost/e-gun?useSSL=false";
	public static String sql ="";
	public static String drive ="com.mysql.jdbc.Driver";
	
	
	public int insertClient(Client client) throws SQLException, ClassNotFoundException {
		
		Class.forName(drive);
		
		int rs =0;
		sql = "insert into client(nom,prenom,telephone,adresse,identifiant) values(?,?,?,?,?)";
		
		try(Connection con = DriverManager.getConnection(url,user,pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			
			pst.setString(1, client.getNom());
			pst.setString(2, client.getPrenom());
			pst.setString(3, client.getTelephone());
			pst.setString(4, client.getAdresse());
			pst.setString(5, client.getIdentifiant());
			
			rs= pst.executeUpdate();
			
		}
		return rs;
	}
	
	public int updateInsertClient(Client client) throws SQLException, ClassNotFoundException {
		
		Class.forName(drive);
		
		int rs =0;
		sql = "update client set email=?, motDePasse=MD5(?) where identifiant =?";
		
		try(Connection con = DriverManager.getConnection(url,user,pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			
			pst.setString(1, client.getEmail());
			pst.setString(2, client.getMotDePasse());
			pst.setString(3, client.getIdentifiant());
			
			rs= pst.executeUpdate();
			
		}
		return rs;
	}
	
	public int connectClient (Client client) throws ClassNotFoundException, SQLException {
		
		Class.forName(drive);

		int idcc=0;
		
		sql = "select* from client where identifiant=? and motDePasse=MD5(?)";
		
		try(Connection con = DriverManager.getConnection(url,user,pwd); 
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, client.getIdentifiant());
			pst.setString(2, client.getMotDePasse());
			
			
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					client.setNom(rs.getString("nom"));
					client.setIdClient(rs.getInt("idClient"));
					client.setPrenom(rs.getString("prenom"));
					client.setPhoto(rs.getString("photo"));
					client.setBiographie(rs.getString("biographie"));
					client.setSexe(rs.getString("sexe"));
					idcc=client.getIdClient();
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return idcc;
			
		
	}
	
public void getMedias (Client client) throws ClassNotFoundException, SQLException {
		
		Class.forName(drive);
		
		sql = "select* from client where idClient=?";
		
		try(Connection con = DriverManager.getConnection(url,user,pwd); 
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, client.getIdClient());
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					client.setPhoto(rs.getString("photo"));
					client.setBiographie(rs.getString("biographie"));
					client.setSexe(rs.getString("sexe"));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String insertIdentifiant (String id) throws ClassNotFoundException, SQLException {
		
		Class.forName(drive);
		sql ="select identifiant from client";
		
		try(Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){  
			try(ResultSet rst = pst.executeQuery()){
				while(rst.next()) {
					if(id.equals(rst.getString("identifiant"))) {
						id = id + "1";
					}
				}
			}
		}
		
		
		return id;
		
	}
	
	public boolean insertEmail (String email) throws Exception {
		
		boolean flag = false;
		Class.forName(drive);
		sql ="select email from client";
		
		try(Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			try(ResultSet rst = pst.executeQuery()){
				while(rst.next()) {
					if(email.equals(rst.getString("email"))) {
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	
	public int changerPhoto(Client client) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql ="update client set photo = ? where idClient = ?";
		int rs = 0;
		try(Connection con=DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst= con.prepareStatement(sql)){
			
			pst.setString(1, client.getPhoto());
			pst.setInt(2, client.getIdClient());
			
			rs = pst.executeUpdate();
		}
		return rs;
	}
	
	public int changerBio(Client client) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql ="update client set biographie = ? where idClient = ?";
		int rs = 0;
		try(Connection con=DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst= con.prepareStatement(sql)){
			
			pst.setString(1, client.getBiographie());
			pst.setInt(2, client.getIdClient());
			
			rs = pst.executeUpdate();
		}
		return rs;
	}
	
	public int changerGenre(Client client) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql ="update client set sexe = ? where idClient = ?";
		int rs = 0;
		try(Connection con=DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst= con.prepareStatement(sql)){
			
			pst.setString(1, client.getSexe());
			pst.setInt(2, client.getIdClient());
			
			rs = pst.executeUpdate();
		}
		return rs;
	}
	
	public void getNameClient (Client client) throws ClassNotFoundException, SQLException {
		Class.forName(drive);
		sql="select* from client where idClient =?";
		
		try(Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, client.getIdClient());
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					client.setNom(rs.getString("nom"));
				}
			}
		}
	}


}
