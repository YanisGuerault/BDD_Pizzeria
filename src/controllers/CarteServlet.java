package controllers;

import beans.Ingredient;
import beans.Pizza;
import dao.PizzaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Carte")
public class CarteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Object> list = new ArrayList<Object>();
        for (Pizza pizza:PizzaDAO.getPizzaList())
        {
            ArrayList<Object> listpizzaingredient = new ArrayList<Object>();
            listpizzaingredient.add(pizza);
            listpizzaingredient.add(PizzaDAO.getPizzaIngredients(pizza));
            list.add(listpizzaingredient);
        }

        request.setAttribute("listPizza",list);
        this.getServletContext().getRequestDispatcher("/carte.jsp").forward(request,response);
    }
}
