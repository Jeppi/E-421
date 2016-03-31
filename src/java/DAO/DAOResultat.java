/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entites.Joueur;
import entites.Resultat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JP
 */
public class DAOResultat extends DAOConnexion {
    
    public DAOResultat(){super();}
        
    public Resultat select(Joueur joueur){
        try {
            PreparedStatement pSmt = dbcon.prepareStatement("SELECT * FROM resultats WHERE nom=?");
            pSmt.setString(1,joueur.getNom());
            ResultSet rs = pSmt.executeQuery();
            rs.next();
            int nbV = rs.getInt("partieGagneeJoueur");
            int nbD = rs.getInt("partieGagneeOrdinateur");
            return new Resultat(joueur, nbV, nbD);
        } catch (SQLException ex) {
            Logger.getLogger(DAOResultat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void create(Joueur joueur){
        try{
        PreparedStatement pSmt = dbcon.prepareStatement("INSERT INTO resultats VALUES (?,?,0,0)");
        pSmt.setString(1, joueur.getNom());
        pSmt.setString(2, joueur.getPrenom());
        pSmt.executeUpdate();
        } catch (SQLException e){}
    }
    
    public void ajouteVictoire(Joueur joueur){
        try{
        PreparedStatement pSmt = dbcon.prepareStatement("UPDATE resultats SET partieGagneeJoueur=partieGagneeJoueur+1 WHERE nom=?");
        pSmt.setString(1, joueur.getNom());
        pSmt.executeUpdate();    
        } catch (SQLException ex) {
            //gestion exception
        }
    }

    public void ajouteDefaite(Joueur joueur) {
        try{
        PreparedStatement pSmt = dbcon.prepareStatement("UPDATE resultats SET partieGagneeOrdinateur=partieGagneeOrdinateur+1 WHERE nom=?");
        pSmt.setString(1, joueur.getNom());
        pSmt.executeUpdate();    
        } catch (SQLException ex) {
        //gestion exception
        }
    }   
}
