package champollion;

import java.util.*;

public class Enseignant extends Personne {
    
    private final List<ServicePrevu> myService = new LinkedList<>();
    private final List<Intervention> myIntervention = new LinkedList<>();


    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        int x = 0;
        int y = 0;
        int z = 0;
        for( ServicePrevu s : myService){
            x += 1.5*s.getvolumeCM();
            y += s.getvolumeTD();
            z += 0.75*s.getvolumeTP();
        }
        return (x + y + z);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        int x = 0;
        int y = 0;
        int z = 0;
        for( ServicePrevu s : myService){
            if(ue.equals(s.getUE())){
            x += 1.5*s.getvolumeCM();
            y += s.getvolumeTD();
            z += 0.75*s.getvolumeTP();
            }
        }
        return (x + y + z);

    }
    
    
    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP){
        // TODO: Implémenter cette méthode
        ServicePrevu s = new ServicePrevu(this, ue,volumeCM, volumeTD, volumeTP);
		myService.add(s);
    }
    
    
    public void ajouteIntervention(Intervention i){
		myIntervention.add(i);
    }
        
    
    
    public int heuresPlannifiees(){
        int x = 0;
        int y = 0;
        int z = 0;
        for( Intervention s : myIntervention){
            if(s.getAnnulee() == false){
                if(s.getTypeIntervention() == TypeIntervention.CM){
                    x += 1.5*s.getDuree();
                }
                else if(s.getTypeIntervention() == TypeIntervention.TD){
                    y += s.getDuree();
                }
                else {
                    z += 0.75*s.getDuree();
                }
            }
        }
        return (x + y + z);
    }
    
    public boolean enSousService(){
            return heuresPlannifiees()<heuresPrevues();
    }
    
    public List<Intervention> getIntervention(){
        return this.myIntervention;
    }
        
    
    
    
    
    

}
