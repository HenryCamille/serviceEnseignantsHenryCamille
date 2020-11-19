package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
        private final Enseignant enseignant;
	private final UE ue1;
        private int volumeCM;
        private int volumeTD;
        private int volumeTP;
        
        public ServicePrevu(Enseignant e, UE ue, int VCM, int VTD, int VTP){
            enseignant = e;
            ue1 = ue;
            volumeCM = VCM;
            volumeTD = VTD;
            volumeTP = VTP;
        }
        
        public Enseignant getEnseignant(){
            return enseignant;
        }
        
        public UE getUE(){
            return ue1;
        }
        
        public int getvolumeCM(){
            return volumeCM;
        }
        
        public int getvolumeTD(){
            return volumeTD;
        }
        
        public int getvolumeTP(){
            return volumeTP;
        }

}
