package edu.cuny.qc.cs.dataminingfinal.models;

enum Day { 
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, 
    THURSDAY, FRIDAY, SATURDAY; 
} 

public class Participant {

    String participantId;
    String memberId;
    
    double motivationScore;
    double intentionScore;
    double attitudeScore;
    double ownershipScore;
    
    //skip index 0 and 1 for these
    int[] selfEfficacyResponse = new int[79];
    int[] adherenceResponse = new int[10];
    
    Day mostActiveDay;
    
    int[] logsByHour = new int[24];
    
    public Participant(){
        
    }
}
