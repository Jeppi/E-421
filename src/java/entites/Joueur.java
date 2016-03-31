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
public class Joueur {
    
    private String nom;
    private String prenom;
    private int age;
        
    public Joueur(){}
    public Joueur(String nom, String prenom, int age){
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
    }
    
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public int getAge(){
        return this.age;
    }
    
}
