package beans;

public class Tailler {
    private Number id;
    private Taille taille;
    private Pizza pizza;
    private Number prix;

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public Number getPrix() {
        return prix;
    }

    public void setPrix(Number prix) {
        this.prix = prix;
    }

    public Taille getTaille() {
        return taille;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
        if(pizza != null)
        {
            prix = taille.getPourcentage().doubleValue()*pizza.getPrix().doubleValue();
        }
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
        if(taille != null)
        {
            prix = taille.getPourcentage().doubleValue()*pizza.getPrix().doubleValue();
        }
    }
}
