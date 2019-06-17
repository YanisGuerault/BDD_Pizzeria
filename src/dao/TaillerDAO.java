package dao;

import beans.Pizza;
import beans.Taille;
import beans.Tailler;
import util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaillerDAO {


    public static Tailler getTaillerByID(int id) {
        String requete = "select * from tailler where id="+id+";";
        ResultSet result = DBConnection.makeRequestSelect(requete);

        try {
            Tailler newTailler = new Tailler();
            while (result.next()) {
                newTailler.setId(result.getBigDecimal("id"));
                newTailler.setPizza(PizzaDAO.getPizzaByID(result.getInt("id_pizza")));
                newTailler.setTaille(TailleDAO.getTailleByID(result.getInt("id_taille")));
                newTailler.setPrix(result.getBigDecimal("prix"));
            }
            return newTailler;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Tailler> getTaillerList() {
        ResultSet result = DBConnection.makeRequestSelect("select * from tailler");

        ArrayList<Tailler> taillerlist = new ArrayList<Tailler>();
        try {
            while (result.next()) {
                Tailler newTailler = new Tailler();
                newTailler.setId(result.getBigDecimal("id"));
                newTailler.setPizza(PizzaDAO.getPizzaByID(result.getInt("id_pizza")));
                newTailler.setTaille(TailleDAO.getTailleByID(result.getInt("id_taille")));
                newTailler.setPrix(result.getBigDecimal("prix"));
                taillerlist.add(newTailler);
            }
            return taillerlist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void insertTailler(Tailler tailler) {
        String requete = "INSERT INTO tailler(id_pizza,id_taille,prix) VALUES " +
                "('" + tailler.getPizza().getId() + "',"
                + tailler.getTaille().getId() + ","
                + tailler.getPrix() + ")";

        DBConnection.makeRequestInsert(requete);
    }
}
