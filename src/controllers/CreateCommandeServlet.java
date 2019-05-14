package controllers;

import beans.*;
import dao.*;
import util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/CreateCommande")
public class CreateCommandeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Commande commande = new Commande();

        commande.setId(Integer.parseInt(request.getParameter("id")));
        commande.setPrix(Float.parseFloat(request.getParameter("prix")));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format( new Date()   );
        commande.setDateLivraison(formatter.parse(request.getParameter("date")));
        commande.setTempsLivraison();
        commande.setNom(request.getParameter("pizzaname"));
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
        ArrayList<Livreur> livreurs = LivreurDAO.getLivreurList();
        request.setAttribute("livreurs",livreurs);

        ArrayList<Vehicule> vehicules = VehiculeDAO.getVehiculeList();
        request.setAttribute("vehicules",vehicules);

        ArrayList<Pizza> pizzas = PizzaDAO.getPizzaList();
        request.setAttribute("pizzas",pizzas);

        ArrayList<Client> clients = ClientDAO.getClientList();
        request.setAttribute("clients",clients);

        DBConnection.clearConnections();
        this.getServletContext().getRequestDispatcher("/createcommande.jsp").forward(request,response);
    }
}
