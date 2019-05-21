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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/CreateCommande")
public class CreateCommandeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Commande commande = new Commande();

        commande.setPrix(Float.parseFloat(request.getParameter("prix")));

        try {
            commande.setDateLivraison(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date_livraison")));
        } catch(ParseException e)
        {
        }

        String temps_livraison = request.getParameter("temps_livraison");
        String[] split_temps_livraison = temps_livraison.split(":");

        commande.setTempsLivraison(Float.parseFloat(split_temps_livraison[0]+"."+split_temps_livraison[1]));

        commande.setLivreur(LivreurDAO.getLivreurByID(Integer.parseInt(request.getParameter("livreur"))));

        commande.setVehicule(VehiculeDAO.getVehiculeByID(Integer.parseInt(request.getParameter("vehicule"))));

        commande.setClient(ClientDAO.getClientByID(Integer.parseInt(request.getParameter("client"))));

        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

        for(String pizza : request.getParameterValues("pizza"))
        {
            Pizza newPizza = PizzaDAO.getPizzaByID(Integer.parseInt(pizza));
            pizzas.add(newPizza);
        }

        commande.setListPizza(pizzas);

        CommandeDAO.insertCommande(commande);

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
