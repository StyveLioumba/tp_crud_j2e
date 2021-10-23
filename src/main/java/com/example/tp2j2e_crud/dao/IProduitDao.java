package com.example.tp2j2e_crud.dao;

import com.example.tp2j2e_crud.beans.Produit;

import java.util.List;

public interface IProduitDao {
    Produit save (Produit produit);
    List<Produit> produits(String keyword);
    Produit getProduit(int id);
    Produit updateProduit(Produit produit);
    void deleteProduit(int id);
}
