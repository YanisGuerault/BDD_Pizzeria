package beans;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Commande {
    private Number id;
    private Date dateLivraison;
    private Number prix;
    private Number tempsLivraison;
    private Livreur livreur;
    private Vehicule vehicule;
    private ArrayList<Tailler> listPizza;
    private Client client;

    public Number getId() {
        return id;
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

    public Number getTempsLivraison() {
        return tempsLivraison;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public ArrayList<Tailler> getListPizza() {
        return listPizza;
    }

    public Client getClient() {
        return client;
    }

    public void setId(Number id) {
        this.id = id;
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

    public void setTempsLivraison(Number tempsLivraison) {
        this.tempsLivraison = tempsLivraison;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public void setListPizza(ArrayList<Tailler> listPizza) {
        this.listPizza = listPizza;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
