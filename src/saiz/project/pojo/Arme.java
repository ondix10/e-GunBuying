package saiz.project.pojo;

public class Arme {
	
	protected int idArme;
	protected int idTypeArme;
	protected int idGestionnaire;
	protected int idFournisseur;
	protected String nom;
	protected double prix;
	protected int quantiteDepose;
	protected int quantiteActuelle;
	
	public Arme() {}
	
	public Arme(String nom, double prix) {
		this.nom=nom;
		this.prix=prix;
		// TODO Auto-generated constructor stub
	}
	public Arme(String nom,int idArme) {
		this.nom = nom;
		this.idArme = idArme;
		// TODO Auto-generated constructor stub
	}

	public int getIdArme() {
		return idArme;
	}
	public void setIdArme(int idArme) {
		this.idArme = idArme;
	}
	public int getIdTypeArme() {
		return idTypeArme;
	}
	public void setIdTypeArme(int idTypeArme) {
		this.idTypeArme = idTypeArme;
	}
	public int getIdGestionnaire() {
		return idGestionnaire;
	}
	public void setIdGestionnaire(int idGestionnaire) {
		this.idGestionnaire = idGestionnaire;
	}
	public int getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantiteDepose() {
		return quantiteDepose;
	}
	public void setQuantiteDepose(int quantiteDepose) {
		this.quantiteDepose = quantiteDepose;
	}
	public int getQuantiteActuelle() {
		return quantiteActuelle;
	}
	public void setQuantiteActuelle(int quantiteActuelle) {
		this.quantiteActuelle = quantiteActuelle;
	}
	
	
	
}
