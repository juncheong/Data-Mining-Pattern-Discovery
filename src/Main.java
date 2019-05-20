import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<String, String> env;

    public static void main(String[] args) {
        try {
            Scanner environmentVariables = new Scanner(new File("env"));
            Scanner adherence = new Scanner(new File("/data/adherence.txt"));
            Scanner allLog = new Scanner(new File("/data/all-log.txt"));
            Scanner behavior = new Scanner(new File("/data/behavior.txt"));
            Scanner selectedLog = new Scanner(new File("/data/selected-log.txt"));
            Scanner selfEfficacy = new Scanner(new File("/data/self-efficacy.txt"));
            
            env = loadEnvVar(environmentVariables);
            environmentVariables.close();
            
            Database database = new Database(env.get("DB_HOST"), env.get("DB_USERNAME"), 
                                            env.get("DB_PASSWORD"), env.get("DB_PORT"), 
                                            env.get("DB_NAME"));
            
            database.uploadDataSets(adherence, allLog, behavior, selectedLog, selfEfficacy);
            adherence.close();
            allLog.close();
            behavior.close();
            selectedLog.close();
            selfEfficacy.close();
            
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
    
    private static Map<String, String> loadEnvVar(Scanner environmentVariables){
        
    }

}
