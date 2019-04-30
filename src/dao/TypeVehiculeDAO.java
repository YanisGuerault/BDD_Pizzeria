package dao;

import beans.Client;
import beans.TypeVehicule;
import util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeVehiculeDAO {

    public static TypeVehicule getTypeVehiculeByName(String libelle) {
        String requete = "select * from type_vehicule where nom_type=" + libelle;

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


    public static ArrayList<TypeVehicule> getTypeVehiculeList() {
        ResultSet result = DBConnection.makeRequestSelect("select * from type_vehicule");

        ArrayList<TypeVehicule> typeVehiculeslist = new ArrayList<TypeVehicule>();
        try {
            while (result.next()) {
                TypeVehicule newtypevehicule = new TypeVehicule();
                newtypevehicule.setId(result.getBigDecimal("id"));
                newtypevehicule.setLibelle(result.getString("nom_type")); //fetch the values present in database
                typeVehiculeslist.add(newtypevehicule);
            }
            return typeVehiculeslist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
