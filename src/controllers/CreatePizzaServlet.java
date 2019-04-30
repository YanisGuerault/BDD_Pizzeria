package controllers;

import beans.Ingredient;
import beans.Pizza;
import dao.IngredientDAO;
import dao.PizzaDAO;
import util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet("/CreatePizza")
public class CreatePizzaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pizza pizza = new Pizza();
        pizza.setNom(request.getParameter("pizzaname"));
        pizza.setPrix(Integer.parseInt(request.getParameter("prix")));

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

        for(String ingredient : request.getParameterValues("ingredients"))
        {
            Ingredient newIngredient = IngredientDAO.getIngredientByName(ingredient);
            ingredients.add(newIngredient);
        }

        PizzaDAO.insertPizza(pizza,ingredients);

        DBConnection.clearConnections();

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Ingredient> ingredients = IngredientDAO.getIngredientList();
        request.setAttribute("ingredients",ingredients);
        DBConnection.clearConnections();
        this.getServletContext().getRequestDispatcher("/createpizza.jsp").forward(request,response);
    }
}
