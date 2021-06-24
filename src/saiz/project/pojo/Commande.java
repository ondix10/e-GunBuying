package saiz.project.pojo;

public class Commande {
	
	protected int idCommande;
	protected Arme arme;
	protected Client client;
	protected String dateCommande;
	protected int quantite;
	protected String document;
	protected String statut;
	
	public Commande() {}
	
	public Commande(String dateCommande, int quantite, String statut) {
		this.dateCommande=dateCommande;
		this.quantite = quantite;
		this.statut = statut;
	}
	public Commande(int idCommande,String dateCommande) {
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
				
		// TODO Auto-generated constructor stub
	}

	public Arme getArme() {
		return arme;
	}
	public void setArme(Arme arme) {
		this.arme = arme;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	
	public String getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) { 
		this.dateCommande = dateCommande;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	

}
