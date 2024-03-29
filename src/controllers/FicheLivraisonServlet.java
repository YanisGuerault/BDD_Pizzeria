package controllers;

import beans.Commande;
import dao.CommandeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/FicheLivraison")
public class FicheLivraisonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id_commande = Integer.parseInt(request.getParameter("fiche_livraison"));
        Commande commande = CommandeDAO.getCommandeByID(id_commande);
        request.setAttribute("commande",commande);
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Commande> listCommande = CommandeDAO.getCommandeList();
        System.out.print(listCommande);
        request.setAttribute("commandList",listCommande);
        this.getServletContext().getRequestDispatcher("/fichelivraison.jsp").forward(request,response);
    }
}
