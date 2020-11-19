/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

/**
 *
 * @author Utilisateur
 */
public class Salle {
    private String nomSalle;
    private int capacite;
    
    public Salle(String nom1, int capacite1){
        nomSalle = nom1;
        capacite = capacite1;
        
    }
     public String getNomSalle(){
         return nomSalle;
     }
    
     public int getCapacite(){
         return capacite;
     }
}
