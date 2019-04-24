package beans;

public class Pizza {
    private Number id;
    private String nom;
    private Number prix;

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Number getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(Number prix) {
        this.prix = prix;
    }

}
