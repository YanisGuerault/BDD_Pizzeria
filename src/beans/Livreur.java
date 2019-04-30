package beans;

public class Livreur {
    private Number id;
    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public Number getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
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
}
