package com.example.tp2j2e_crud.servlets;

import com.example.tp2j2e_crud.beans.Produit;
import com.example.tp2j2e_crud.dao.IProduitDao;
import com.example.tp2j2e_crud.dao.ProduitDaoImpl;
import com.example.tp2j2e_crud.model.ProduitModele;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProduitServlet", urlPatterns = {"/produits","*.do"})
public class ProduitServlet extends HttpServlet {
    private IProduitDao produitDao;

    @Override
    public void init() throws ServletException {
        produitDao= new ProduitDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path){
            case "/produits.do":
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;
            case "/search.do":
                ProduitModele produitModele= new ProduitModele();

                String keyword= request.getParameter("keyword");
                produitModele.setKeyword(keyword);

                List<Produit> produits= produitDao.produits(keyword);
                produitModele.setProduits(produits);

                request.setAttribute("modele",produitModele);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;
            case "/saisie.do":
                request.getRequestDispatcher("/create.jsp").forward(request,response);
                break;
            case "/supprimer.do":
                int id = Integer.parseInt(request.getParameter("id"));
                produitDao.deleteProduit(id);
                response.sendRedirect("search.do?keyword=");
                break;
            case "/editer.do":
                int id_edit = Integer.parseInt(request.getParameter("id"));
                Produit produit= produitDao.getProduit(id_edit);
                request.setAttribute("produit",produit);
                request.getRequestDispatcher("editer.jsp").forward(request,response);
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);



        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/save.do")){
            String nom = request.getParameter("nom");
            double prix = Double.parseDouble(request.getParameter("prix"));
            Produit produit = produitDao.save(new Produit(nom,prix));
            request.setAttribute("produit",produit);

            request.getRequestDispatcher("/confirmation.jsp").forward(request,response);
        }else if(path.equals("/update.do")){
            int id_update=Integer.parseInt(request.getParameter("id"));
            String nom_update=request.getParameter("nom");
            double prix_update= Double.parseDouble(request.getParameter("prix"));
            Produit produit_update=produitDao.updateProduit(new Produit(id_update,nom_update,prix_update));
            request.setAttribute("produit",produit_update);
            request.getRequestDispatcher("/confirmation.jsp").forward(request,response);

        }

    }
}
