package dao;

import beans.*;
import util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommandeDAO {

    /*public static Vehicule getVehiculeByPlaque(String plaque) {
        String requete = "select * from vehicule where plaque=" + plaque;

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Vehicule newVehicule = new Vehicule();
            while (result.next()) {
                newVehicule.setId(result.getBigDecimal("id"));
                newVehicule.setPlaque(result.getString("plaque"));
                newVehicule.setTypeVehicule(CommandeDAO.getTypeVehiculeOfVehicule(newVehicule));
            }
            return newVehicule;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }*/

    public static Client getClientCommande(Commande commande) {
        String requete = "select * from client " +
                "join commande on client.id = commande.id_client" +
                "where commande.id=" + commande.getId();

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Client newClient = new Client();
            return ClientDAO.getClientByName(result.getString("prenom"),result.getString("nom"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Livreur getLivreurCommande(Commande commande) {
        String requete = "select * from livreur " +
                "join commande on livreur.id = commande.id_livreur" +
                "where commande.id=" + commande.getId();

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Livreur newLivreur = new Livreur();
            return LivreurDAO.getLivreurByName(result.getString("prenom"),result.getString("nom"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Vehicule getVehiculeCommande(Commande commande) {
        String requete = "select * from vehicule " +
                "join commande on vehicule.id = commande.id_vehicule" +
                "where commande.id=" + commande.getId();

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Vehicule newVehicule = new Vehicule();
            return VehiculeDAO.getVehiculeByPlaque(result.getString("plaque"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Pizza> getPizzaCommande(Commande commande) {
        String requete = "select * from commanderpizza " +
                "join commande on commanderpizza.id_commande = commande.id" +
                "join pizza on commanderpizza.id_pizza = pizza.id" +
                "where commande.id=" + commande.getId();

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
            while (result.next()) {
                pizzaList.add(PizzaDAO.getPizzaByName(result.getString("nom")));
            }
            return pizzaList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Commande> getCommandeList() {
        ResultSet result = DBConnection.makeRequestSelect("select * from commande");

        ArrayList<Commande> commandeList = new ArrayList<Commande>();
        try {
            while (result.next()) {
                Commande newCommande = new Commande();
                newCommande.setId(result.getBigDecimal("id"));
                newCommande.setDateLivraison(result.getDate("date_livraison")); //fetch the values present in database
                newCommande.setPrix(result.getBigDecimal("prix"));
                newCommande.setTempsLivraison(result.getBigDecimal("temps_livraison"));
                newCommande.setClient(CommandeDAO.getClientCommande(newCommande));
                newCommande.setListPizza(CommandeDAO.getPizzaCommande(newCommande));
                newCommande.setLivreur(CommandeDAO.getLivreurCommande(newCommande));
                newCommande.setVehicule(CommandeDAO.getVehiculeCommande(newCommande));
                commandeList.add(newCommande);
                System.out.print(newCommande);
            }
            return commandeList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
