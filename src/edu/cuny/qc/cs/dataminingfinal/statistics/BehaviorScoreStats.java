package edu.cuny.qc.cs.dataminingfinal.statistics;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import edu.cuny.qc.cs.dataminingfinal.models.BehaviorScore;

public class BehaviorScoreStats {
    
    ArrayList<BehaviorScore> behaviorScores;
    int numResponses;
    double avgMotivation;
    double avgIntention;
    double avgAttitude;
    double avgOwnership;
    
    public BehaviorScoreStats(ArrayList<BehaviorScore> behaviorScores){
        this.behaviorScores = behaviorScores;
        numResponses = behaviorScores.size();
        calculateAverages();
    }
    
    private void calculateAverages(){
        
        double motivationSum = 0;
        double intentionSum = 0;
        double attitudeSum = 0;
        double ownershipSum = 0;
        
        for (int i = 0; i < numResponses; i++){
            BehaviorScore scores = behaviorScores.get(i);
            motivationSum += scores.getMotivation();
            intentionSum += scores.getIntention();
            attitudeSum += scores.getAttitude();
            ownershipSum += scores.getOwnership();
        }
        
        avgMotivation = motivationSum / numResponses;
        avgIntention = intentionSum / numResponses;
        avgAttitude = attitudeSum / numResponses;
        avgOwnership = ownershipSum / numResponses;
    }

    public ArrayList<BehaviorScore> getBehaviorScores() {
        return behaviorScores;
    }

    public int getNumResponses() {
        return numResponses;
    }

    public double getAvgMotivation() {
        return avgMotivation;
    }

    public double getAvgIntention() {
        return avgIntention;
    }

    public double getAvgAttitude() {
        return avgAttitude;
    }

    public double getAvgOwnership() {
        return avgOwnership;
    }
 
    public void printResults(Writer output) throws IOException {
        output.write("***** RESULTS FOR BEHAVIOR SCORES *****\n\n");
        
        output.write("Number of responses: " + numResponses + "\n");
        output.write("Average motivation: " + avgMotivation + "\n");
        output.write("Average intention: " + avgIntention + "\n");
        output.write("Average attitude: " + avgAttitude + "\n");
        output.write("Average ownership: " + avgOwnership + "\n");
    }
}
