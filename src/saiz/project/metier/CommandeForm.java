 package saiz.project.metier;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import saiz.project.dao.ClientDao;
import saiz.project.dao.CommandeDao;
import saiz.project.pojo.Arme;
import saiz.project.pojo.Client;
import saiz.project.pojo.Commande;

public class CommandeForm{

	CommandeDao commandeDao = new CommandeDao();
	Client client = new Client();
	ClientDao clientDao = new ClientDao();
	ClientForm clientForm = new ClientForm();
	
	public static final String CHAMP_NOM = "arme";
	public static final String CHAMP_QUANTITE = "quantite";
	
	int idA=0;
	public static String nomArme;
	public static int quantArme;
	public static double prixArme;
	
	private String resultat;
	private Map<String, String> erreur = new HashMap<String, String>();


	public String getResultat() {
		return resultat;
	}
	public Map<String, String> getErreur() {
		return erreur;
	}

	public void achatCommande(HttpServletRequest request, Commande commande, Arme arme) {
		
		
		arme.setNom(nomArme);
		try {
			idA = commandeDao.selectIdArme(arme);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		arme.setIdArme(idA);
		arme.setPrix(prixArme);
		
		try {
			validationQuant(quantArme);
		} catch (Exception e) {
			setErreur(CHAMP_QUANTITE, e.getMessage());
		}
		commande.setQuantite(quantArme);
		 
	}
	
	public void pdfCommande(HttpServletRequest request, Commande commande, Arme arme) {
		
		commande.setQuantite(quantArme);
		
		arme.setNom(nomArme);
		try {
			idA = commandeDao.selectIdArme(arme);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		arme.setIdArme(idA);
		arme.setPrix(prixArme);
		 
	}
	
	public void confirmationCommande(HttpServletRequest request, Commande commande, Arme arme) throws IOException, ServletException {
		
		String nArme = request.getParameter(CHAMP_NOM);
		arme.setNom(nArme);
		int Quant = Integer.parseInt(request.getParameter(CHAMP_QUANTITE));
		commande.setQuantite(Quant);
		
		try {
			prixArme = commandeDao.selectPrixArme(arme);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		arme.setPrix(prixArme);
		
		nomArme = nArme;
		quantArme = Quant;
		
		
	}
	
	private void validationQuant(int quantite) throws Exception {
		
		Arme arme = new Arme();
		arme.setIdArme(idA);
		int quantAct = commandeDao.selectQuant(arme);
		
		if ( quantite > quantAct ) {
			throw new Exception( "Stock non suffisant." );
		}else {
			quantAct = quantAct - quantite;	
			arme.setQuantiteActuelle(quantAct);
			commandeDao.updateQuant(arme);
		}		
	}
	
	private void setErreur( String champ, String message ) {
		erreur.put( champ, message );
	}	
	
}