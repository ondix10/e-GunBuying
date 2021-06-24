 package saiz.project.metier;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import saiz.project.dao.ClientDao;
import saiz.project.pojo.Client;

public class ClientForm {
	
	Client client = new Client();
	ClientDao clientDao = new ClientDao();
	
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_SEXE = "sexe";
	public static final String CHAMP_TELEPHONE = "telephone";
	public static final String CHAMP_ADRESSE = "adresse";
	public static final String CHAMP_IDENTIFIANT = "identifiant";
	public static final String CHAMP_MOTDEPASSE = "motDePasse";
	public static final String CHAMP_PHOTO = "photo";
	public static final String CHAMP_BIOGRAPHIE = "biographie";
	
	public static String idt="";
	public static int Cid=0;
	public static String identifiant;
	public static String motDePasse;
	 
	private String resultat;
	private Map<String, String> erreur = new HashMap<String, String>();


	public String getResultat() {
		return resultat;
	}
	public Map<String, String> getErreur() {
		return erreur;
	}

	public Client insertClient(HttpServletRequest request) {
		
		String nom = getValeurChamp( request, CHAMP_NOM );
		String prenom = getValeurChamp( request, CHAMP_PRENOM );
		String adresse = getValeurChamp( request, CHAMP_ADRESSE );
		String telephone = getValeurChamp( request, CHAMP_TELEPHONE );
		
		
		
		try {
			validationNom( nom );
		}catch(Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		client.setNom(nom);
		
		try {
			validationPreNom( prenom );
		}catch(Exception e) {
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
		client.setPrenom(prenom);
		
		try {
			validationAdresse( adresse );
		}catch(Exception e) {
			setErreur(CHAMP_ADRESSE, e.getMessage());
		}
		client.setAdresse(adresse);
		
		try {
			validationTelephone( telephone );
		}catch(Exception e) {
			setErreur(CHAMP_TELEPHONE, e.getMessage());
		}
		client.setTelephone(telephone);
		
		String identifiant = client.getNom()+client.getPrenom();
		//client.setIdentifiant(identifiant);
		
		
		try {
			idt = clientDao.insertIdentifiant(identifiant);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		client.setIdentifiant(idt);		
		
		
		return client;
	}
	
	
	public Client updateInsertClient(HttpServletRequest request) {
		
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_MOTDEPASSE);
		String confirmation = getValeurChamp(request, "confirmation");
		client.setIdentifiant(idt);
		
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		client.setEmail(email);
		
		try {
			validationMotDePasse(motDePasse,confirmation);
		} catch (Exception e) {
			setErreur(CHAMP_MOTDEPASSE, e.getMessage());
		}
		client.setMotDePasse(motDePasse);
		
		return client;
		
	}
	
	public void getMedia(Client client) throws ClassNotFoundException, SQLException {
		client.setIdClient(Cid);
		clientDao.getMedias(client);
		
	}
	
	public void getIDC(Client client) throws ClassNotFoundException, SQLException {
		
		client.setIdClient(Cid);
		
	}
	
	public Client connectInsertClient(HttpServletRequest request) {
		
		identifiant = getValeurChamp( request, CHAMP_IDENTIFIANT ); 
		client.setIdentifiant(identifiant);
		motDePasse = getValeurChamp( request, CHAMP_MOTDEPASSE );
		client.setMotDePasse(motDePasse);
		
		int rst=1;
		try {
			rst = clientDao.connectClient(client);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cid = rst;
		
		return client;
		
	}
	
	public Client connectClient(HttpServletRequest request) {
		 
		client.setIdentifiant(identifiant);
		client.setMotDePasse(motDePasse);
		
		return client;
		
	}
	
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return null;
		} else {
			return valeur.trim();
		}

	}
			
	private void validationNom( String nom ) throws Exception {
		
		if ( nom != null && nom.length() < 4 ) {
			throw new Exception( "Le nom d'utilisateur doit contenir au moins 4 caractères." );
		}
	}
	
	private void validationPreNom( String prenom ) throws Exception {
		
		if ( prenom != null && prenom.length() < 3 ) {
			throw new Exception( "Le prenom d'utilisateur doit contenir au moins 4 caractères." );
		}
	}
	
	private void validationAdresse( String adresse ) throws Exception {
		
		if ( adresse != null && adresse.length() < 1 ) {
			throw new Exception( "L'adresse d'utilisateur doit contenir au moins 10 caractères." );
		}
	}
	
	private void validationTelephone( String telephone ) throws Exception {
		
		if ( telephone != null && telephone.length() < 9 ) {
			throw new Exception( "le telephone d'utilisateur doit contenir au moins 10 numeros." );
		}
	}
	
	private void validationEmail( String email ) throws Exception {
		
		boolean flag = false;
		flag = clientDao.insertEmail(email);
		
		if ( email != null ) {
			if ( !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				throw new Exception( "Merci de saisir une adresse mail valide." );
			} else if(flag) {
				throw new Exception ("Mail deja pris. veuillez entrer un autre");
			}
		} else {
			throw new Exception( "Merci de saisir une adresse mail." );
		}
	}
	
	private void validationMotDePasse( String motDePasse, String confirmation ) throws Exception {
		
		if ( motDePasse != null && motDePasse.length() < 4 ) {
			throw new Exception( "le mot de passe d'utilisateur doit contenir au moins 5 caracteres." );
		}else if ( motDePasse != null && motDePasse.length() > 4 ) {
			if ( motDePasse.equalsIgnoreCase(confirmation) ) {
				//throw new Exception( "les mots de passe ne conrespondent pas" );
			} else {
				throw new Exception( "les mots de passe ne conrespondent pas" );	
			}			
		}
		
	}
	
	private void setErreur( String champ, String message ) {
		erreur.put( champ, message );
	}		
	
}

