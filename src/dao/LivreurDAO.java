package dao;

import beans.Livreur;
import util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivreurDAO {

    public static Livreur getLivreurByName(String firstname, String lastname) {
        String requete = "select * from livreur where ";
        if (firstname != "" && lastname != "") {
            requete += "nom=" + lastname + " and prenom=" + firstname;
        } else if (firstname != "") {
            requete += "prenom=" + firstname;
        } else {
            requete += "nom=" + lastname;
        }

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Livreur newLivreur = new Livreur();
            while (result.next()) {
                newLivreur.setId(result.getBigDecimal("id"));
                newLivreur.setNom(result.getString("nom"));
                newLivreur.setPrenom(result.getString("prenom"));//fetch the values present in database
            }
            return newLivreur;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Livreur> getLivreurList() {
        ResultSet result = DBConnection.makeRequestSelect("select * from livreur");

        ArrayList<Livreur> livreurList = new ArrayList<Livreur>();
        try {
            while (result.next()) {
                Livreur newLivreur = new Livreur();
                newLivreur.setId(result.getBigDecimal("id"));
                newLivreur.setNom(result.getString("nom")); //fetch the values present in database
                newLivreur.setPrenom(result.getString("prenom"));
                livreurList.add(newLivreur);
            }
            return livreurList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
