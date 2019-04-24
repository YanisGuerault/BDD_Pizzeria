package dao;

import beans.Ingredient;
import beans.Pizza;
import util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientDAO {

    public static Ingredient getIngredientByName(String name)
    {
        ResultSet result = DBConnection.makeRequest("select * from ingredient where nom='"+name+"'");

        try {
            Ingredient newIngredient = new Ingredient();
            while(result.next())
            {
                newIngredient.setId(result.getBigDecimal("id"));
                newIngredient.setNom(result.getString("nom")); //fetch the values present in database
            }
            return newIngredient;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Ingredient> getIngredientList() {
        ResultSet result = DBConnection.makeRequest("select * from ingredient");

        ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
        try {
            while(result.next())
            {
                Ingredient newIngredient = new Ingredient();
                newIngredient.setId(result.getBigDecimal("id"));
                newIngredient.setNom(result.getString("nom")); //fetch the values present in database
                ingredientList.add(newIngredient);
            }
            return ingredientList;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
