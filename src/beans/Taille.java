package beans;

public class Taille {
    private Number id;
    private String nom;
    private Number pourcentage;

    public String getNom() {
        return nom;
    }

    public Number getId() {
        return id;
    }

    public Number getPourcentage() {
        return pourcentage;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPourcentage(Number pourcentage) {
        this.pourcentage = pourcentage;
    }
}
