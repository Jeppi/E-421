/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entites.Joueur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lp
 */
public class DAOJoueur extends DAOConnexion{
    
    public DAOJoueur(){super();}
        
    public Joueur select(String nom) {
        
        try {
            PreparedStatement pSmt = dbcon.prepareStatement("SELECT * FROM personne WHERE nom=?");
            pSmt.setString(1,nom);
            ResultSet rs = pSmt.executeQuery();
            rs.next();
            String prenom = rs.getString("prenom");
            int age = rs.getInt("age");
            return new Joueur(nom, prenom, age);
        } catch (SQLException ex) {
            Logger.getLogger(DAOJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    /* pour pouvoir insérer de nouveaux joueurs,etc.

    public void insert(Joueur joueur) throws SQLException {
        PreparedStatement pSmt = dbcon.prepareStatement("INSERT INTO Personne VALUES (?,?,?) ");
        pSmt.setString(1, joueur.getNom());
        pSmt.setString(2, joueur.getPrenom());
        pSmt.setInt(3, joueur.getAge());
        pSmt.executeUpdate();
        
    }
    
    public void update(Joueur joueur) throws SQLException {
        PreparedStatement pSmt = dbcon.prepareStatement("UPDATE personne SET 'prenom'=?, 'age'=? WHERE 'nom'=?");
        pSmt.setString(1, joueur.getPrenom());
        pSmt.setInt(2, joueur.getAge());
        pSmt.setString(3, joueur.getNom());
        pSmt.executeUpdate();   
    }
    
    public void delete(String nom) throws SQLException {
        PreparedStatement pSmt = dbcon.prepareStatement("DELETE FROM personne WHERE 'nom'=?");
        pSmt.setString(1, nom);
        pSmt.executeUpdate();
    }*/
    
