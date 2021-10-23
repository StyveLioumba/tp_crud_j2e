package com.example.tp2j2e_crud.model;

import com.example.tp2j2e_crud.beans.Produit;

import java.util.ArrayList;
import java.util.List;

public class ProduitModele {
    private String keyword;
    private List<Produit> produits=new ArrayList<>();

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
