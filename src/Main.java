import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<String, String> env;

    public static void main(String[] args) {
        try {
            Scanner environmentVariables = new Scanner(Paths.get("env"));
            Scanner adherence = new Scanner(Paths.get("data/adherence.txt"));
            Scanner allLog = new Scanner(Paths.get("data/all-log.txt"));
            Scanner behavior = new Scanner(Paths.get("data/behavior.txt"));
            Scanner selectedLog = new Scanner(Paths.get("data/selected-log.txt"));
            Scanner selfEfficacy = new Scanner(Paths.get("data/self-efficacy.txt"));
            
            env = loadEnvVar(environmentVariables);
            environmentVariables.close();
            
            Database database = new Database(env.get("DB_HOST"), env.get("DB_USERNAME"), 
                                            env.get("DB_PASSWORD"), env.get("DB_PORT"), 
                                            env.get("DB_NAME"));
            
            //database.uploadDataSets(adherence, allLog, behavior, selectedLog, selfEfficacy);
            adherence.close();
            allLog.close();
            behavior.close();
            selectedLog.close();
            selfEfficacy.close();
            
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

}
