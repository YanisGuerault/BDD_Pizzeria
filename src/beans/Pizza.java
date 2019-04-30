package beans;

import java.util.ArrayList;

public class Pizza {
    private Number id;
    private String nom;
    private Number prix;
    private String taille;
    private ArrayList<Ingredient> listIngredient;

    public Number getId() {
        return id;
    }

    public ArrayList<Ingredient> getListIngredient() {
        return listIngredient;
    }

    public String getTaille() {
        return taille;
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

    public void setListIngredient(ArrayList<Ingredient> listIngredient) {
        this.listIngredient = listIngredient;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }
}
