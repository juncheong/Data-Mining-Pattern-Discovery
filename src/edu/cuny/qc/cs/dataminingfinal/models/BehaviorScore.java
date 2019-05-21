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

    public synchronized String getId() {
        return id;
    }

    public synchronized double getMotivation() {
        return motivation;
    }

    public synchronized double getIntention() {
        return intention;
    }

    public synchronized double getAttitude() {
        return attitude;
    }

    public synchronized double getOwnership() {
        return ownership;
    }
}
