package saiz.project.dao;

import saiz.project.pojo.Arme;
import saiz.project.pojo.Client;
import saiz.project.pojo.Commande;

public class FactureDao {
	
	public static String user = "root";
	public static String pwd = "";
	public static String url = "jdbc:mysql://localhost/e-gun?useSSL=false";
	public static String sql ="";
	public static String drive ="com.mysql.jdbc.Driver";
	
	public void imprimerFacture(Commande commande, Client client, Arme arme) throws ClassNotFoundException {
		
		Class.forName(drive);
		sql="select* from commande,client,arme where commande.idCommande=?"+ 
		     "and commande.idArme = arme.idArme and commande.idClient = client.idClient"+
			 "order by commande.idCommande";
		
		
	}

}
