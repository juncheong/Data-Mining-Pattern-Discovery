package edu.cuny.qc.cs.dataminingfinal;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.cuny.qc.cs.dataminingfinal.models.BehaviorScore;
import edu.cuny.qc.cs.dataminingfinal.models.SelectedLog;
import edu.cuny.qc.cs.dataminingfinal.statistics.BehaviorScoreStats;
import edu.cuny.qc.cs.dataminingfinal.statistics.SelectedLogStats;

public class Main {
    public static Map<String, String> env;

    public static void main(String[] args) {
        try {
            Scanner environmentVariables = new Scanner(Paths.get("env"));
            
            env = loadEnvVar(environmentVariables);
            environmentVariables.close();
            
            Database database = new Database(env.get("DB_HOST"), env.get("DB_USERNAME"), 
                                            env.get("DB_PASSWORD"), env.get("DB_PORT"), 
                                            env.get("DB_NAME"));
            
            Writer behaviorScoreStatsWriter = new BufferedWriter((new OutputStreamWriter(
                    new FileOutputStream("results/behaviorScoreStats.txt"), "utf-8")));
            
            try {
                database.establishConnection();
                //uploadDataSets(database);
                
                ArrayList<BehaviorScore> behaviorScores = database.getAllBehaviorScores();
                BehaviorScoreStats behaviorScoreStats = new BehaviorScoreStats(behaviorScores);
                behaviorScoreStats.printResults(behaviorScoreStatsWriter);
                
                ArrayList<SelectedLog> selectedLogs = database.getAllSelectedLogs();
                SelectedLogStats selectedLogStats = new SelectedLogStats(selectedLogs);
                selectedLogStats.printResults();
                
                
                database.closeConnection();
            } catch (SQLException e){
                System.out.println(e);
            }
            
            behaviorScoreStatsWriter.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    private static Map<String, String> loadEnvVar(Scanner environmentVariables){
        Map<String, String> hashMap = new HashMap<String, String>();
        
        while(environmentVariables.hasNextLine()){
            String[] variable = environmentVariables.nextLine().split("=");
            hashMap.put(variable[0], variable[1]);
        }
        
        return hashMap;
    }
    
    private static void uploadDataSets(Database database){
        try {
            Scanner adherence = new Scanner(Paths.get("data/adherence.txt"));
            Scanner allLog = new Scanner(Paths.get("data/all-log.txt"));
            Scanner behavior = new Scanner(Paths.get("data/behavior.txt"));
            Scanner selectedLog = new Scanner(Paths.get("data/selected-log.txt"));
            Scanner selfEfficacy = new Scanner(Paths.get("data/self-efficacy-revised.txt"));
            
            database.uploadDataSets(adherence, allLog, behavior, selectedLog, selfEfficacy);
            adherence.close();
            allLog.close();
            behavior.close();
            selectedLog.close();
            selfEfficacy.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }

}
