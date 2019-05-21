package dao;

import beans.Client;
import beans.Livreur;
import util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO {

    public static Client getClientByID(int id) {
        String requete = "select * from client where id="+id+";";
        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Client newClient = new Client();
            while (result.next()) {
                newClient.setId(result.getBigDecimal("id"));
                newClient.setNom(result.getString("nom"));
                newClient.setPrenom(result.getString("prenom"));
                newClient.setSolde(result.getInt("solde"));//fetch the values present in database
            }
            return newClient;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Client getClientByName(String firstname, String lastname) {
        String requete = "select * from client where ";
        if (firstname != "" && lastname != "") {
            requete += "nom='" + lastname + "' and prenom='" + firstname+"';";
        } else if (firstname != "") {
            requete += "prenom='" + firstname+"';";
        } else {
            requete += "nom='" + lastname+"';";
        }

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Client newClient = new Client();
            while (result.next()) {
                newClient.setId(result.getBigDecimal("id"));
                newClient.setNom(result.getString("nom"));
                newClient.setPrenom(result.getString("prenom"));
                newClient.setSolde(result.getInt("solde"));//fetch the values present in database
            }
            return newClient;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Client> getClientList() {
        ResultSet result = DBConnection.makeRequestSelect("select * from client");

        ArrayList<Client> clientlist = new ArrayList<Client>();
        try {
            while (result.next()) {
                Client newClient = new Client();
                newClient.setId(result.getBigDecimal("id"));
                newClient.setNom(result.getString("nom")); //fetch the values present in database
                newClient.setPrenom(result.getString("prenom"));
                newClient.setSolde(result.getInt("solde"));
                clientlist.add(newClient);
            }
            return clientlist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
