/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author JP
 */
public class Resultat {
    
    private Joueur joueur;
    private int nbV;
    private int nbD;
    
    public Resultat(Joueur j){
        joueur = j;
        nbV = 0;
        nbD = 0;
    }
    
    public Resultat(Joueur j, int v, int d){
        joueur = j;
        nbV = v;
        nbD = d;
    }
    
    public void setNbV(int v){
        nbV = v;
    }
    public int getNbV(){
        return nbV;
    }
    
    public void setNbD(int d){
        nbD = d;
    }
    public int getNbD(){
        return nbD;
    }
    
    public void setJoueur(Joueur j){
        joueur = j;
    }
    public Joueur getJoueur(){
        return joueur;
    }

    
}
