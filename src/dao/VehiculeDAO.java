package dao;

import beans.TypeVehicule;
import beans.Vehicule;
import util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehiculeDAO {

    public static Vehicule getVehiculeByPlaque(String plaque) {
        String requete = "select * from vehicule where plaque='" + plaque+"'";
        System.out.print(requete);

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Vehicule newVehicule = new Vehicule();
            while (result.next()) {
                newVehicule.setId(result.getBigDecimal("id"));
                newVehicule.setPlaque(result.getString("plaque"));
                newVehicule.setTypeVehicule(VehiculeDAO.getTypeVehiculeOfVehicule(newVehicule));
            }
            return newVehicule;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TypeVehicule getTypeVehiculeOfVehicule(Vehicule vehicule) {
        String requete = "select * from vehicule " +
                "join type_vehicule on type_vehicule.id = vehicule.id_type " +
                "where vehicule.plaque='" + vehicule.getPlaque()+"'";

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            TypeVehicule newTypeVehicule = new TypeVehicule();
            while (result.next()) {
                newTypeVehicule.setId(result.getBigDecimal("id"));
                newTypeVehicule.setLibelle(result.getString("nom_type"));
            }
            return newTypeVehicule;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Vehicule> getVehiculeList() {
        ResultSet result = DBConnection.makeRequestSelect("select * from vehicule");

        ArrayList<Vehicule> vehiculeslist = new ArrayList<Vehicule>();
        try {
            while (result.next()) {
                Vehicule newvehicule = new Vehicule();
                newvehicule.setId(result.getBigDecimal("id"));
                newvehicule.setPlaque(result.getString("nom_type")); //fetch the values present in database
                newvehicule.setTypeVehicule(VehiculeDAO.getTypeVehiculeOfVehicule(newvehicule));
                vehiculeslist.add(newvehicule);
            }
            return vehiculeslist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
