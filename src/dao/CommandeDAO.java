package dao;

import beans.*;
import util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommandeDAO {

    public static Client getClientCommande(Commande commande) {
        String requete = "select * from client " +
                "join commande on client.id = commande.id_client " +
                "where commande.id=" + commande.getId();

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            result.next();
            Client newClient = ClientDAO.getClientByName(result.getString("prenom"),result.getString("nom"));
            return newClient;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Livreur getLivreurCommande(Commande commande) {
        String requete = "select * from livreur " +
                "join commande on livreur.id = commande.id_livreur " +
                "where commande.id=" + commande.getId();

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            result.next();
            Livreur newLivreur = LivreurDAO.getLivreurByName(result.getString("prenom"),result.getString("nom"));
            return newLivreur;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Vehicule getVehiculeCommande(Commande commande) {
        String requete = "select * from vehicule " +
                "join commande on vehicule.id = commande.id_vehicule " +
                "where commande.id=" + commande.getId();

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            result.next();
            Vehicule newVehicule = VehiculeDAO.getVehiculeByPlaque(result.getString("plaque"));
            return newVehicule;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Pizza> getPizzaCommande(Commande commande) {
        String requete = "select * from commanderpizza " +
                "join commande on commanderpizza.id_commande = commande.id " +
                "join pizza on commanderpizza.id_pizza = pizza.id " +
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

    public static ArrayList<Tailler> getTaillerCommande(Commande commande) {
        String requete = "select * from commanderpizza " +
                "join commande on commanderpizza.id_commande = commande.id " +
                "join tailler on commanderpizza.id_tailler = tailler.id " +
                "where commande.id=" + commande.getId();

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            ArrayList<Tailler> pizzaList = new ArrayList<Tailler>();
            while (result.next()) {
                pizzaList.add(TaillerDAO.getTaillerByID(result.getInt("id_tailler")));
            }
            return pizzaList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Commande getCommandeByID(Integer id)
    {
        String requete = "select * from commande where id="+id;

        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            result.next();
            Commande newCommande = new Commande();
            newCommande.setId(result.getBigDecimal("id"));
            newCommande.setDateLivraison(result.getDate("date_livraison")); //fetch the values present in database
            newCommande.setPrix(result.getBigDecimal("prix"));
            newCommande.setTempsLivraison(result.getBigDecimal("temps_livraison"));
            newCommande.setClient(CommandeDAO.getClientCommande(newCommande));
            newCommande.setListPizza(CommandeDAO.getTaillerCommande(newCommande));
            newCommande.setLivreur(CommandeDAO.getLivreurCommande(newCommande));
            newCommande.setVehicule(CommandeDAO.getVehiculeCommande(newCommande));
            DBConnection.clearConnections();
            return newCommande;
        } catch (SQLException e) {
            e.printStackTrace();
            DBConnection.clearConnections();
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
                newCommande.setListPizza(CommandeDAO.getTaillerCommande(newCommande));
                newCommande.setLivreur(CommandeDAO.getLivreurCommande(newCommande));
                newCommande.setVehicule(CommandeDAO.getVehiculeCommande(newCommande));
                commandeList.add(newCommande);
            }
            DBConnection.clearConnections();
            return commandeList;
        } catch (SQLException e) {
            e.printStackTrace();
            DBConnection.clearConnections();
            return null;
        }
    }

    public static void insertCommande(Commande commande) {
        String requete = "INSERT INTO commande(prix,temps_livraison,date_livraison,id_livreur,id_vehicule,id_client) VALUES " +
                "('" + commande.getPrix() + "',"
                + commande.getTempsLivraison() + ","
                +"'"+ commande.getDateLivraison() + "',"
                + commande.getLivreur().getId() + ","
                + commande.getVehicule().getId() + ","
                + commande.getClient().getId() + ")";

        System.out.println(requete);

        int id = DBConnection.makeRequestInsert(requete);

        for(Tailler pizza : commande.getListPizza()) {
            DBConnection.makeRequestInsert("INSERT INTO commanderpizza(id_tailler,id_commande) VALUES " +
                    "('" + pizza.getId() + "',"
                    + id + ")");
        }
    }
}
