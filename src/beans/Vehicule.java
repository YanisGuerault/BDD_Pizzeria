package beans;

public class Vehicule {
    private Number id;
    private String plaque;
    private TypeVehicule typeVehicule;

    public Number getId() {
        return id;
    }

    public String getPlaque() {
        return plaque;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }
}
