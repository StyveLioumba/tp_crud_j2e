package com.example.tp2j2e_crud.dao;

import com.example.tp2j2e_crud.beans.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements IProduitDao{

    @Override
    public Produit save(Produit produit) {
        try {
            Connection connection=SingletonConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement("INSERT INTO tb_produit (nom,prix) values (?,?)");
            statement.setString(1,produit.getNom());
            statement.setDouble(2,produit.getPrix());
            statement.executeUpdate();

            PreparedStatement statement1 = connection.prepareStatement("SELECT MAX(id) as max_id FROM  tb_produit");
            ResultSet resultSet=statement1.executeQuery();

            if (resultSet.next()){
                produit.setId(resultSet.getInt("max_id"));
            }

            statement.close();
            statement1.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produit;
    }

    @Override
    public List<Produit> produits(String keyword) {
        List<Produit> produits =new ArrayList<>();
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement statement= connection.prepareStatement("SELECT * FROM tb_produit where nom LIKE ?");
            statement.setString(1,"%"+keyword+"%");
            ResultSet resultSet= statement.executeQuery();

            while (resultSet.next()){
                Produit produit = new Produit();
                produit.setId(resultSet.getInt("id"));
                produit.setNom(resultSet.getString("nom"));
                produit.setPrix(resultSet.getDouble("prix"));

                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Produit getProduit(int id) {
        Produit produit=new Produit();

        try {
            Connection connection=SingletonConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM tb_produit where id=?");
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();

            if (resultSet.next()){
                produit.setId(resultSet.getInt("id"));
                produit.setNom(resultSet.getString("nom"));
                produit.setPrix(resultSet.getDouble("prix"));
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produit;
    }

    @Override
    public Produit updateProduit(Produit produit) {

        try {
            Connection connection=SingletonConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement("UPDATE tb_produit SET nom =?,prix=? where id =? ");

            statement.setString(1,produit.getNom());
            statement.setDouble(2,produit.getPrix());
            statement.setInt(3,produit.getId());
            statement.executeUpdate();

            PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM  tb_produit where id =?");
            statement1.setInt(1,produit.getId());
            ResultSet resultSet=statement1.executeQuery();

            if (resultSet.next()){
                produit.setId(resultSet.getInt("id"));
                produit.setNom(resultSet.getString("nom"));
                produit.setPrix(resultSet.getDouble("prix"));
            }

            statement.close();
            statement1.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produit;
    }

    @Override
    public void deleteProduit(int id) {
        try {
            Connection connection=SingletonConnection.getConnection();
            PreparedStatement statement= connection.prepareStatement("DELETE FROM tb_produit WHERE id = ?");
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
