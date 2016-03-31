/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
import java.util.*;

/**
 *
 * @author JP
 */
public class Joueurs {
    
    //cette classe joueurs était utilisée avant l'installation de la DAO
    private Hashtable<String,Joueur> joueurs;
    
    public Joueurs(){
    joueurs=new Hashtable<String,Joueur>();
    }
    
    public void ajoute(Joueur j1){
        joueurs.put(j1.getNom(), j1);
    }
    
    public Joueur retourne(String nom){
        return joueurs.get(nom);
    }
    
    public void supprime(String nom){
        joueurs.remove(nom);
    }
    
}
