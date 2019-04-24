package controllers;

import beans.Ingredient;
import dao.IngredientDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/CreatePizza")
public class CreatePizzaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("BONSOIR !");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Ingredient> ingredients = IngredientDAO.getIngredientList();
        request.setAttribute("ingredients",ingredients);
        this.getServletContext().getRequestDispatcher("/createpizza.jsp").forward(request,response);
        System.out.print(request);
    }
}
