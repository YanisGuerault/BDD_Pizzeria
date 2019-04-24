package dao;

import java.sql.*;
import java.util.ArrayList;

import beans.Ingredient;
import beans.Pizza;
import util.DBConnection;

public class PizzaDAO {

    public static Pizza getPizzaByName(String name)
    {
        ResultSet result = DBConnection.makeRequest("select * from pizza where nom='"+name+"'");

        try {
            Pizza newPizza = new Pizza();
            while(result.next())
            {
                newPizza.setNom(result.getString("nom")); //fetch the values present in database
                newPizza.setPrix(result.getBigDecimal("prix"));
            }
            return newPizza;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Pizza> getPizzaList() {
        ResultSet result = DBConnection.makeRequest("select * from pizza");

        ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
        try {
            while(result.next())
            {
                Pizza newPizza = new Pizza();
                newPizza.setNom(result.getString("nom")); //fetch the values present in database
                newPizza.setPrix(result.getBigDecimal("prix"));
                pizzaList.add(newPizza);
            }
            return pizzaList;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Ingredient> getPizzaIngredients(Pizza pizza)
    {
        ResultSet result = DBConnection.makeRequest("select ingredient.nom from ingredient " +
                "join preparer on ingredient.id = preparer.id_ingredient " +
                "join pizza on preparer.id_pizza = pizza.id " +
                "where pizza.nom = '"+pizza.getNom()+"'");

        ArrayList<Ingredient> IngredientList = new ArrayList<Ingredient>();

        try {
            while(result.next())
            {
                Ingredient ingredient = new Ingredient();
                ingredient.setNom(result.getString("nom")); //fetch the values present in database
                IngredientList.add(ingredient);
            }
            return IngredientList;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Ingredient> getPizzaIngredients(String pizza)
    {
        Pizza newpizza = new Pizza();
        newpizza.setNom(pizza);
        return getPizzaIngredients(newpizza);
    }
}
