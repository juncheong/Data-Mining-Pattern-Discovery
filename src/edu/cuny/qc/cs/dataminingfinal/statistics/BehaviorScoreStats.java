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
    
    int[][] motInt = new int[3][3];
    int[][] motAtt = new int[3][3];
    int[][] motOwn = new int[3][3];
    int[][] intAtt = new int[3][3];
    int[][] intOwn = new int[3][3];
    int[][] attOwn = new int[3][3];
    
    public BehaviorScoreStats(ArrayList<BehaviorScore> behaviorScores){
        this.behaviorScores = behaviorScores;
        numResponses = behaviorScores.size();
        initializeArrays();
        calculateAvgAndDist();
        calculateChiSquared();
    }
    
    private void initializeArrays() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                motInt[i][j] = 0;
                motAtt[i][j] = 0;
                motOwn[i][j] = 0;
                intAtt[i][j] = 0;
                intOwn[i][j] = 0;
                attOwn[i][j] = 0;
            }
        }
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
        
        calculateMargins();

        avgMotivation = motivationSum / numResponses;
        avgIntention = intentionSum / numResponses;
        avgAttitude = attitudeSum / numResponses;
        avgOwnership = ownershipSum / numResponses;
    }

    private void addToSpread(double motivation, double intention, double attitude, double ownership) {
        addTo2WaySpread(motivation, intention, attitude, ownership);
        addTo5WaySpread(motivation, intention, attitude, ownership);
    }

    private void addTo2WaySpread(double motivation, double intention, double attitude, double ownership) {
        if(motivation < 0.5 && intention < 0.5) motInt[0][0]++;
        else if(motivation >= 0.5 && intention < 0.5) motInt[0][1]++;
        else if(motivation < 0.5 && intention >= 0.5) motInt[1][0]++;
        else if(motivation >= 0.5 && intention >= 0.5) motInt[1][1]++;
        
        if(motivation < 0.5 && attitude < 0.5) motAtt[0][0]++;
        else if(motivation >= 0.5 && attitude < 0.5) motAtt[0][1]++;
        else if(motivation < 0.5 && attitude >= 0.5) motAtt[1][0]++;
        else if(motivation >= 0.5 && attitude >= 0.5) motAtt[1][1]++;
        
        if(motivation < 0.5 && ownership < 0.5) motOwn[0][0]++;
        else if(motivation >= 0.5 && ownership < 0.5) motOwn[0][1]++;
        else if(motivation < 0.5 && ownership >= 0.5) motOwn[1][0]++;
        else if(motivation >= 0.5 && ownership >= 0.5) motOwn[1][1]++;
        
        if(intention < 0.5 && attitude < 0.5) intAtt[0][0]++;
        else if(intention >= 0.5 && attitude < 0.5) intAtt[0][1]++;
        else if(intention < 0.5 && attitude >= 0.5) intAtt[1][0]++;
        else if(intention >= 0.5 && attitude >= 0.5) intAtt[1][1]++;
        
        if(intention < 0.5 && ownership < 0.5) intOwn[0][0]++;
        else if(intention >= 0.5 && ownership < 0.5) intOwn[0][1]++;
        else if(intention < 0.5 && ownership >= 0.5) intOwn[1][0]++;
        else if(intention >= 0.5 && ownership >= 0.5) intOwn[1][1]++;
        
        if(attitude < 0.5 && ownership < 0.5) attOwn[0][0]++;
        else if(attitude >= 0.5 && ownership < 0.5) attOwn[0][1]++;
        else if(attitude < 0.5 && ownership >= 0.5) attOwn[1][0]++;
        else if(attitude >= 0.5 && ownership >= 0.5) attOwn[1][1]++;
    }

    private void addTo5WaySpread(double motivation, double intention, double attitude, double ownership) {
        
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
    
    private void calculateMargins() {
        
        for (int i = 0; i < motInt.length-1; i++){
            for (int j = 0; j < motInt.length-1; j++){
                motInt[i][motInt.length-1] += motInt[i][j];
                motAtt[i][motInt.length-1] += motAtt[i][j];
                motOwn[i][motInt.length-1] += motOwn[i][j];
                intAtt[i][motInt.length-1] += intAtt[i][j];
                intOwn[i][motInt.length-1] += intOwn[i][j];
                attOwn[i][motInt.length-1] += attOwn[i][j];
            }
        }
        
        for (int j = 0; j < motInt.length-1; j++){
            for (int i = 0; i < motInt.length-1; i++){
                motInt[motInt.length-1][j] += motInt[i][j];
                motAtt[motInt.length-1][j] += motAtt[i][j];
                motOwn[motInt.length-1][j] += motOwn[i][j];
                intAtt[motInt.length-1][j] += intAtt[i][j];
                intOwn[motInt.length-1][j] += intOwn[i][j];
                attOwn[motInt.length-1][j] += attOwn[i][j];
            }
        }
        
        motInt[motInt.length-1][motInt.length-1] = numResponses;
        motAtt[motInt.length-1][motInt.length-1] = numResponses;
        motOwn[motInt.length-1][motInt.length-1] = numResponses;
        intAtt[motInt.length-1][motInt.length-1] = numResponses;
        intOwn[motInt.length-1][motInt.length-1] = numResponses;
        attOwn[motInt.length-1][motInt.length-1] = numResponses;
                
    }
    
    private void calculateChiSquared() {
        // TODO Auto-generated method stub
        
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
    
    public void printChiSquaredTables(Writer output) throws IOException{
        output.write("***** Tables used for Chi-Squared *****\n\n");
        output.write("2x2 grids were chosen as anything larger resulted in every cell being very small\n");
        output.write("The two catagories (low and high) represent\n");
        output.write("0.0 <= low < 0.5\n");
        output.write("0.5 <= high < 1.0\n\n");
        
        output.write("      Motivation x Intention\n\n");
        output.write("        low  | high | total\n");
        output.write("      ----------------------\n");
        
        for (int i = 0; i < motInt.length; i++){
            if (i == 0) output.write("low   | ");
            else if (i == 1) output.write("high  | ");
            else output.write("      ----------------------\ntotal | ");
            
            for (int j = 0; j < motInt.length; j++){
                output.write(" " + motInt[i][j] + "  ");
                if (motInt[i][j] < 10) output.write(" ");
                output.write("| ");
            }
            output.write("\n");
        }
        
        output.write("\n\n");
        
        output.write("      Motivation x Attitude\n\n");
        output.write("        low  | high | total\n");
        output.write("      ----------------------\n");
        
        for (int i = 0; i < motAtt.length; i++){
            if (i == 0) output.write("low   | ");
            else if (i == 1) output.write("high  | ");
            else output.write("      ----------------------\ntotal | ");
            
            for (int j = 0; j < motAtt.length; j++){
                output.write(" " + motAtt[i][j] + "  ");
                if (motAtt[i][j] < 10) output.write(" ");
                output.write("| ");
            }
            output.write("\n");
        }
        
        output.write("\n\n");
        
        output.write("      Motivation x Ownership\n\n");
        output.write("        low  | high | total\n");
        output.write("      ----------------------\n");
        
        for (int i = 0; i < motOwn.length; i++){
            if (i == 0) output.write("low   | ");
            else if (i == 1) output.write("high  | ");
            else output.write("      ----------------------\ntotal | ");
            
            for (int j = 0; j < motOwn.length; j++){
                output.write(" " + motOwn[i][j] + "  ");
                if (motOwn[i][j] < 10) output.write(" ");
                output.write("| ");
            }
            output.write("\n");
        }
        
        output.write("\n\n");
        
        output.write("      Intention x Attitude\n\n");
        output.write("        low  | high | total\n");
        output.write("      ----------------------\n");
        
        for (int i = 0; i < intAtt.length; i++){
            if (i == 0) output.write("low   | ");
            else if (i == 1) output.write("high  | ");
            else output.write("      ----------------------\ntotal | ");
            
            for (int j = 0; j < intAtt.length; j++){
                output.write(" " + intAtt[i][j] + "  ");
                if (intAtt[i][j] < 10) output.write(" ");
                output.write("| ");
            }
            output.write("\n");
        }
        
        output.write("\n\n");
        
        output.write("      Intention x Ownership\n\n");
        output.write("        low  | high | total\n");
        output.write("      ----------------------\n");
        
        for (int i = 0; i < intOwn.length; i++){
            if (i == 0) output.write("low   | ");
            else if (i == 1) output.write("high  | ");
            else output.write("      ----------------------\ntotal | ");
            
            for (int j = 0; j < intOwn.length; j++){
                output.write(" " + intOwn[i][j] + "  ");
                if (intOwn[i][j] < 10) output.write(" ");
                output.write("| ");
            }
            output.write("\n");
        }
        
        output.write("\n\n");
        
        output.write("      Attitude x Ownership\n\n");
        output.write("        low  | high | total\n");
        output.write("      ----------------------\n");
        
        for (int i = 0; i < attOwn.length; i++){
            if (i == 0) output.write("low   | ");
            else if (i == 1) output.write("high  | ");
            else output.write("      ----------------------\ntotal | ");
            
            for (int j = 0; j < attOwn.length; j++){
                output.write(" " + attOwn[i][j] + "  ");
                if (attOwn[i][j] < 10) output.write(" ");
                output.write("| ");
            }
            output.write("\n");
        }
        
    }
 
    public void printResults(Writer output) throws IOException {
        output.write("***** RESULTS FOR BEHAVIOR SCORES *****\n\n");
        
        output.write("Number of responses: " + numResponses + "\n");
        output.write("Average motivation: " + avgMotivation + "\n");
        output.write("Average intention: " + avgIntention + "\n");
        output.write("Average attitude: " + avgAttitude + "\n");
        output.write("Average ownership: " + avgOwnership + "\n");
        
        output.write("\n");
        output.write("5-way distribution of scores\n");
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
        output.write("\n\n");
        
        printChiSquaredTables(output);
    }
}
