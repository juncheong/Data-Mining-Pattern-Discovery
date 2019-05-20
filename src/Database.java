import java.util.Scanner;

public class Database {

    private String DB_HOST;
    private String DB_USERNAME;
    private String DB_PASSWORD;
    private String DB_PORT;
    private String DB_NAME;
    
    public Database(String dB_HOST, String dB_USERNAME, String dB_PASSWORD, String dB_PORT, String dB_NAME) {
        DB_HOST = dB_HOST;
        DB_USERNAME = dB_USERNAME;
        DB_PASSWORD = dB_PASSWORD;
        DB_PORT = dB_PORT;
        DB_NAME = dB_NAME;
    }

    public void uploadDataSets(Scanner adherence, Scanner allLog, Scanner behavior, Scanner selectedLog, Scanner selfEfficacy){
        uploadAdherence(adherence);
        uploadAllLog(allLog);
        uploadBehavior(behavior);
        uploadSelectedLog(selectedLog);
        uploadSelfEfficacy(selfEfficacy);
    }
    
    private void uploadAdherence(Scanner adherence){
        
    }
    
    private void uploadAllLog(Scanner allLog){
        
    }
    
    private void uploadBehavior(Scanner behavior){
        
    }
    
    private void uploadSelectedLog(Scanner selectedLog){
        
    }
    
    private void uploadSelfEfficacy(Scanner selfEfficacy){
        
    }
}
