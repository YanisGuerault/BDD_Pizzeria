package dao;

import java.sql.*;
import java.util.ArrayList;

import beans.Ingredient;
import beans.Pizza;
import beans.Taille;
import beans.Tailler;
import util.DBConnection;

public class PizzaDAO {

    public static Pizza getPizzaByID(int id) {
        ResultSet result = DBConnection.makeRequestSelect("select * from pizza where id=" + id + ";");

        try {
            Pizza newPizza = new Pizza();
            while (result.next()) {
                newPizza.setId(result.getBigDecimal("id"));
                newPizza.setNom(result.getString("nom")); //fetch the values present in database
                newPizza.setPrix(result.getBigDecimal("prix"));
                newPizza.setListIngredient(PizzaDAO.getPizzaIngredients(newPizza));
            }
            return newPizza;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Pizza getPizzaByName(String name) {
        ResultSet result = DBConnection.makeRequestSelect("select * from pizza where nom='" + name + "'");

        try {
            Pizza newPizza = new Pizza();
            while (result.next()) {
                newPizza.setId(result.getBigDecimal("id"));
                newPizza.setNom(result.getString("nom")); //fetch the values present in database
                newPizza.setPrix(result.getBigDecimal("prix"));
                newPizza.setListIngredient(PizzaDAO.getPizzaIngredients(newPizza));
            }
            return newPizza;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Pizza> getPizzaList() {
        ResultSet result = DBConnection.makeRequestSelect("select * from pizza");

        ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
        try {
            while (result.next()) {
                Pizza newPizza = new Pizza();
                newPizza.setId(result.getBigDecimal("id"));
                newPizza.setNom(result.getString("nom")); //fetch the values present in database
                newPizza.setPrix(result.getBigDecimal("prix"));
                newPizza.setListIngredient(PizzaDAO.getPizzaIngredients(newPizza));
                pizzaList.add(newPizza);
            }
            return pizzaList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Ingredient> getPizzaIngredients(Pizza pizza) {
        ResultSet result = DBConnection.makeRequestSelect("select ingredient.id,ingredient.nom from ingredient " +
                "join preparer on ingredient.id = preparer.id_ingredient " +
                "join pizza on preparer.id_pizza = pizza.id " +
                "where pizza.nom = '" + pizza.getNom() + "'");

        ArrayList<Ingredient> IngredientList = new ArrayList<Ingredient>();

        try {
            while (result.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setId(result.getBigDecimal("id"));
                ingredient.setNom(result.getString("nom")); //fetch the values present in database
                IngredientList.add(ingredient);
            }
            return IngredientList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Ingredient> getPizzaIngredients(String pizza) {
        Pizza newpizza = new Pizza();
        newpizza.setNom(pizza);
        return getPizzaIngredients(newpizza);
    }

    public static void insertPizza(Pizza pizza) {
        int id = DBConnection.makeRequestInsert("INSERT INTO pizza(nom,prix) VALUES ('" + pizza.getNom() + "'," + pizza.getPrix() + ")");
        pizza.setId(id);
        for(Taille taille : TailleDAO.getTailleList())
        {
            Tailler tailler = new Tailler();
            tailler.setTaille(taille);
            tailler.setPizza(pizza);
            tailler.setPrix((taille.getPourcentage().doubleValue()/100)*pizza.getPrix().doubleValue());
            TaillerDAO.insertTailler(tailler);
        }
    }

    public static void insertPizza(Pizza pizza, ArrayList<Ingredient> ingredients) {
        insertPizza(pizza);
        Pizza newpizza = getPizzaByName(pizza.getNom());
        for (Ingredient ingredient : ingredients) {
            DBConnection.makeRequestInsert("INSERT INTO preparer VALUES (" + newpizza.getId() + "," + ingredient.getId() + ")");
        }
    }
}
