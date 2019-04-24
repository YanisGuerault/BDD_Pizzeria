package controllers;

import beans.Pizza;
import dao.PizzaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ListePizza")
public class ListePizzaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPizza",PizzaDAO.getPizzaIngredients("Margherita"));
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
