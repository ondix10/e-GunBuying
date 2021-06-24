package saiz.project.metier;


import javax.servlet.http.HttpServletRequest;

import saiz.project.pojo.Commande;
import saiz.project.pojo.Gestionnaire;

public class GestionnaireForm {
	
	Gestionnaire gestionnaire = new Gestionnaire();
	
	public static final String CHAMP_ID = "commandeId";
	public static final String CHAMP_IDENTIFIANT = "identifiant";
	public static final String CHAMP_MOTDEPASSE = "motDePasse";
	
	public static int idcmd = 0;
	public static String identifiant;
	public static String motDePasse;
	
	public void achatCommande(HttpServletRequest request, Commande commande) {
		
		idcmd = Integer.parseInt(request.getParameter(CHAMP_ID));
		commande.setIdCommande(idcmd);
		
	}
	
	public void recupId (Commande commande) {
		commande.setIdCommande(idcmd);
	}
	
	public Gestionnaire connectInsertGestionnaire(HttpServletRequest request) {
		
		identifiant = request.getParameter(CHAMP_IDENTIFIANT); 
		gestionnaire.setIdentifiant(identifiant);
		
		motDePasse = request.getParameter(CHAMP_MOTDEPASSE);
		gestionnaire.setMotDePasse(motDePasse);
	
		
		return gestionnaire;
		
	}
	
	public Gestionnaire connectGestionnaire(HttpServletRequest request) {
		 
		gestionnaire.setIdentifiant(identifiant);
		gestionnaire.setMotDePasse(motDePasse);
		
		return gestionnaire;
		
	}
		

}
