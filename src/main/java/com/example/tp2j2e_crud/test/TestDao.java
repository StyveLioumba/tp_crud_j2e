package com.example.tp2j2e_crud.test;

import com.example.tp2j2e_crud.beans.Produit;
import com.example.tp2j2e_crud.dao.ProduitDaoImpl;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        ProduitDaoImpl produitDao = new ProduitDaoImpl();
        Produit produit=produitDao.save(new Produit("macbook pro ",2050));
        System.out.println(produit.toString());
        System.out.println("\n------\n");
        List<Produit> produits=produitDao.produits("a");
        for (Produit prod : produits){
            System.out.println(prod.toString());
        }
    }
}
