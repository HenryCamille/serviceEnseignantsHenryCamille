/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.*;

/**
 *
 * @author Utilisateur
 */
public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee = false;
    private Salle nomSalle;
    private Enseignant nomEnseignant;
    private UE ue;
    private TypeIntervention typeIntervention;
    
    
    public Intervention(Enseignant e1, Salle s1, UE ue1, int d1, Date date1){
        nomEnseignant = e1;
        nomSalle = s1;
        ue = ue1;
        duree = d1;
        debut = date1;
                
    }   
    
    public Enseignant getEnseignant(){
        return nomEnseignant;
    }
    
        
    public boolean getAnnulee(){
        return annulee;
    }
    
    
    public Date getDate(){
        return debut;
    }
    
    
    public int getDuree(){
        return duree;
    }
  
    
    public void setAnnulee(boolean annulee){
        this.annulee = annulee;
    }
    
    public TypeIntervention getTypeIntervention(){
        return typeIntervention;
    }
    
    public void setTypeIntervention(TypeIntervention typeIntervention){
        this.typeIntervention = typeIntervention;
    }

 
}
