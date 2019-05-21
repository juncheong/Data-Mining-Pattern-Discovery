package edu.cuny.qc.cs.dataminingfinal.models;

public class BehaviorScore {
    String id;
    double motivation;
    double intention;
    double attitude;
    double ownership;
    
    public BehaviorScore(String id, double motivation, double intention, double attitude, double ownership) {
        this.id = id;
        this.motivation = motivation;
        this.intention = intention;
        this.attitude = attitude;
        this.ownership = ownership;
    }

    public String getId() {
        return id;
    }

    public double getMotivation() {
        return motivation;
    }

    public double getIntention() {
        return intention;
    }

    public double getAttitude() {
        return attitude;
    }

    public double getOwnership() {
        return ownership;
    }

    
}
