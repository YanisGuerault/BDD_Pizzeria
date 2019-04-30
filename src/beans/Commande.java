package beans;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Commande {
    private Number id;
    private String nom;
    private String prenom;
    private Date dateLivraison;
    private Number prix;
    private Time tempsLivraison;
    private Livreur livreur;
    private Vehicule vehicule;
    private ArrayList<Pizza> listPizza;
    private Client client;

    public String getNom() {
        return nom;
    }

    public Number getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public Number getPrix() {
        return prix;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public Time getTempsLivraison() {
        return tempsLivraison;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public ArrayList<Pizza> getListPizza() {
        return listPizza;
    }

    public Client getClient() {
        return client;
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

    public void setPrix(Number prix) {
        this.prix = prix;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public void setTempsLivraison(Time tempsLivraison) {
        this.tempsLivraison = tempsLivraison;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public void setListPizza(ArrayList<Pizza> listPizza) {
        this.listPizza = listPizza;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
