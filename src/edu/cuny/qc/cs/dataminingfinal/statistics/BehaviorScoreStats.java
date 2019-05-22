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

    int[] motivationSpread = {0, 0, 0, 0, 0};
    int[] intentionSpread = {0, 0, 0, 0, 0};
    int[] attitudeSpread = {0, 0, 0, 0, 0};
    int[] ownershipSpread = {0, 0, 0, 0, 0};
    
    public BehaviorScoreStats(ArrayList<BehaviorScore> behaviorScores){
        this.behaviorScores = behaviorScores;
        numResponses = behaviorScores.size();
        calculateAvgAndDist();
    }
    
    private void calculateAvgAndDist(){
        
        double motivationSum = 0;
        double intentionSum = 0;
        double attitudeSum = 0;
        double ownershipSum = 0;
        
        for (int i = 0; i < numResponses; i++){
            BehaviorScore scores = behaviorScores.get(i);
            
            double motivation = scores.getMotivation();
            double intention = scores.getIntention();
            double attitude = scores.getAttitude();
            double ownership = scores.getOwnership();
            
            motivationSum += motivation;
            intentionSum += intention;
            attitudeSum += attitude;
            ownershipSum += ownership;
            
            addToSpread(motivation, intention, attitude, ownership);
        }
        
        avgMotivation = motivationSum / numResponses;
        avgIntention = intentionSum / numResponses;
        avgAttitude = attitudeSum / numResponses;
        avgOwnership = ownershipSum / numResponses;
    }

    private void addToSpread(double motivation, double intention, double attitude, double ownership) {
        
        if(0.0 <= motivation && motivation < 0.2) motivationSpread[0]++;
        else if(0.2 <= motivation && motivation < 0.4) motivationSpread[1]++;
        else if(0.4 <= motivation && motivation < 0.6) motivationSpread[2]++;
        else if(0.6 <= motivation && motivation < 0.8) motivationSpread[3]++;
        else motivationSpread[4]++;
        
        if(0.0 <= intention && intention < 0.2) intentionSpread[0]++;
        else if(0.2 <= intention && intention < 0.4) intentionSpread[1]++;
        else if(0.4 <= intention && intention < 0.6) intentionSpread[2]++;
        else if(0.6 <= intention && intention < 0.8) intentionSpread[3]++;
        else intentionSpread[4]++;
        
        if(0.0 <= attitude && attitude < 0.2) attitudeSpread[0]++;
        else if(0.2 <= attitude && attitude < 0.4) attitudeSpread[1]++;
        else if(0.4 <= attitude && attitude < 0.6) attitudeSpread[2]++;
        else if(0.6 <= attitude && attitude < 0.8) attitudeSpread[3]++;
        else attitudeSpread[4]++;
        
        if(0.0 <= ownership && ownership < 0.2) ownershipSpread[0]++;
        else if(0.2 <= ownership && ownership < 0.4) ownershipSpread[1]++;
        else if(0.4 <= ownership && ownership < 0.6) ownershipSpread[2]++;
        else if(0.6 <= ownership && ownership < 0.8) ownershipSpread[3]++;
        else ownershipSpread[4]++;
        
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
        
        output.write("\n");
        output.write("Distribution of scores are divided into five groups\n");
        output.write("0 <= x < 0.2, 0.2 <= x < 0.4, 0.4 <= x < 0.6, 0.6 <= x < 0.8, 0.8 <= x < 1.0\n");
        output.write("These divions were chosen arbitrarily. Should there be more time and/or data, the data can be divided further\n\n");
        
        output.write("Motivation scores\n");
        for (int i = 0; i < 5; i++){
            output.write(motivationSpread[i] + " ");
        }
        output.write("\n");
       
        output.write("Intention scores\n");
        for (int i = 0; i < 5; i++){
            output.write(intentionSpread[i] + " ");
        }
        output.write("\n");
        
        output.write("Attitude scores\n");
        for (int i = 0; i < 5; i++){
            output.write(attitudeSpread[i] + " ");
        }
        output.write("\n");
       
        output.write("Ownership scores\n");
        for (int i = 0; i < 5; i++){
            output.write(ownershipSpread[i] + " ");
        }
        output.write("\n");
    }
}
