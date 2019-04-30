package beans;

public class Client {
    private Number id;
    private String nom;
    private String prenom;
    private Number solde;

    public String getNom() {
        return nom;
    }

    public Number getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public Number getSolde() {
        return solde;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSolde(Number solde) {
        this.solde = solde;
    }
}
