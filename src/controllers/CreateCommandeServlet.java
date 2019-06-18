package controllers;

import beans.*;
import dao.*;
import util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/CreateCommande")
public class CreateCommandeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Commande commande = new Commande();

        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); // New Pattern
            java.util.Date date = sdf1.parse(request.getParameter("date_livraison")); // Returns a Date format object with the pattern
            System.out.println(date);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            commande.setDateLivraison(sqlStartDate);
        } catch(ParseException e)
        {
        }

        String temps_livraison = request.getParameter("temps_livraison");
        String[] split_temps_livraison = temps_livraison.split(":");

        commande.setTempsLivraison(Float.parseFloat(split_temps_livraison[0]+"."+split_temps_livraison[1]));

        commande.setLivreur(LivreurDAO.getLivreurByID(Integer.parseInt(request.getParameter("livreur"))));

        commande.setVehicule(VehiculeDAO.getVehiculeByID(Integer.parseInt(request.getParameter("vehicule"))));

        commande.setClient(ClientDAO.getClientByID(Integer.parseInt(request.getParameter("client"))));

        ArrayList<Tailler> pizzas = new ArrayList<Tailler>();

        Double prix = 0.0;

        for(String pizza : request.getParameterValues("pizza"))
        {
            Tailler newPizza = TaillerDAO.getTaillerByID(Integer.parseInt(pizza));
            prix += newPizza.getPrix().doubleValue();
            pizzas.add(newPizza);
        }

        commande.setListPizza(pizzas);

        commande.setPrix(prix);

        CommandeDAO.insertCommande(commande);

        DBConnection.clearConnections();

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Livreur> livreurs = LivreurDAO.getLivreurList();
        request.setAttribute("livreurs",livreurs);

        ArrayList<Vehicule> vehicules = VehiculeDAO.getVehiculeList();
        request.setAttribute("vehicules",vehicules);

        ArrayList<Tailler> pizzas = TaillerDAO.getTaillerList();
        request.setAttribute("pizzas",pizzas);

        ArrayList<Client> clients = ClientDAO.getClientList();
        request.setAttribute("clients",clients);

        DBConnection.clearConnections();
        this.getServletContext().getRequestDispatcher("/createcommande.jsp").forward(request,response);
    }
}
