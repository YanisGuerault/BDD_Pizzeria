package dao;

import beans.Taille;
import beans.TypeVehicule;
import beans.Vehicule;
import util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TailleDAO {


    public static Taille getTailleByID(int id) {
        String requete = "select * from taille where id="+id+";";
        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Taille newTaille = new Taille();
            while (result.next()) {
                newTaille.setId(result.getBigDecimal("id"));
                newTaille.setNom(result.getString("nom"));
                newTaille.setPourcentage(result.getBigDecimal("pourcentage"));
            }
            return newTaille;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Taille getTailleByPlaque(String nom) {
        String requete = "select * from taille where nom='" + nom+"'";
        System.out.print(requete);

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Taille newTaille = new Taille();
            while (result.next()) {
                newTaille.setId(result.getBigDecimal("id"));
                newTaille.setNom(result.getString("nom"));
                newTaille.setPourcentage(result.getBigDecimal("pourcentage"));
            }
            return newTaille;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Taille> getTailleList() {
        ResultSet result = DBConnection.makeRequestSelect("select * from taille");

        ArrayList<Taille> taillelist = new ArrayList<Taille>();
        try {
            while (result.next()) {
                Taille nnewTaille = new Taille();
                nnewTaille.setId(result.getBigDecimal("id"));
                nnewTaille.setNom(result.getString("nom"));
                nnewTaille.setPourcentage(result.getBigDecimal("pourcentage"));
                taillelist.add(nnewTaille);
            }
            return taillelist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
