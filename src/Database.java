import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database {

    private String DB_HOST;
    private String DB_USERNAME;
    private String DB_PASSWORD;
    private String DB_PORT;
    private String DB_NAME;
    private String JDBC_URL;
    
    public Database(String dB_HOST, String dB_USERNAME, String dB_PASSWORD, String dB_PORT, String dB_NAME) {
        DB_HOST = dB_HOST;
        DB_USERNAME = dB_USERNAME;
        DB_PASSWORD = dB_PASSWORD;
        DB_PORT = dB_PORT;
        DB_NAME = dB_NAME;
        JDBC_URL = "jdbc:mysql://" + dB_HOST + ":" + dB_PORT + "/" + dB_NAME;
    }

    public void uploadDataSets(Scanner adherence, Scanner allLog, Scanner behavior, Scanner selectedLog, Scanner selfEfficacy){
        try {
            
            Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            
            uploadAdherence(adherence, statement);
            uploadAllLog(allLog, statement);
            uploadBehavior(behavior, statement);
            uploadSelectedLog(selectedLog, statement);
            uploadSelfEfficacy(selfEfficacy, statement);
            
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    
    private void uploadAdherence(Scanner adherence, Statement statement){
        String tableName = "adherence_response";
        
        while (adherence.hasNextLine()){
            try{
                String[] line = adherence.nextLine().split("\\s+");
                StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES (");
                
                for(int i = 0; i < line.length; i++){
                    query.append("'" + line[i] + "'");
                    if (i != line.length-1)
                        query.append(", ");
                }
                
                query.append(");");
                statement.executeUpdate(query.toString());
            } catch (SQLException e){
                System.out.println(e);
            }
        }
        
    }
    
    private void uploadAllLog(Scanner allLog, Statement statement){
        String tableName = "all_log";
        
        while (allLog.hasNextLine()){
            try{
                String[] line = allLog.nextLine().split("\\s+");
                StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES ("); 
                query.append("'" + line[0] + "', ");
                query.append("'" + line[1] + " " + line[2] + "'");
                
                if (line.length > 3){
                    query.append(", '");
                    StringBuilder description = new StringBuilder();
                    
                    for (int i = 3; i < line.length; i++){
                        description.append(line[i]);
                        if (i != line.length-1)
                            description.append(" ");
                    }
                    query.append(description + "'");
                    
                }
                
                query.append(");");
                statement.executeUpdate(query.toString());
            } catch (SQLException e){
                System.out.println(e);
            }
        }
    }
    
    private void uploadBehavior(Scanner behavior, Statement statement){
        String tableName = "behavior_score";
        
        while (behavior.hasNextLine()){
            try{
                String[] line = behavior.nextLine().split("\\s+");
                StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES ("); 
                query.append("'" + line[0] + "', ");
                query.append("'" + line[1] + "', ");
                query.append("'" + line[2] + "', ");
                query.append("'" + line[3] + "', ");
                query.append("'" + line[4] + "'");
                
                query.append(");");
                statement.executeUpdate(query.toString());
            } catch (SQLException e){
                System.out.println(e);
            }
        }
    }
    
    private void uploadSelectedLog(Scanner selectedLog, Statement statement){
        String tableName = "selected_log";
        
        while (selectedLog.hasNextLine()){
            try{
                String[] line = selectedLog.nextLine().split("\\s+");
                StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES ("); 
                query.append("'" + line[0] + "', ");
                query.append("'" + line[1] + "', ");
                query.append("'" + line[2] + " " + line[3] + "'");
                
                if (line.length > 4){
                    query.append(", '");
                    StringBuilder description = new StringBuilder();
                    
                    for (int i = 4; i < line.length; i++){
                        description.append(line[i]);
                        if (i != line.length-1)
                            description.append(" ");
                    }
                    query.append(description + "'");
                    
                }
                
                query.append(");");
                statement.executeUpdate(query.toString());
            } catch (SQLException e){
                System.out.println(e);
            }
        }
    }
    
    private void uploadSelfEfficacy(Scanner selfEfficacy, Statement statement){
        String tableName = "self_efficacy";
        
        while (selfEfficacy.hasNextLine()){
            try{
                String[] line = selfEfficacy.nextLine().split("\\s+");
                StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES ("); 
                for(int i = 0; i < line.length; i++){
                    query.append("'" + line[i] + "'");
                    if (i != line.length-1)
                        query.append(", ");
                }
                
                query.append(");");
                statement.executeUpdate(query.toString());
                System.out.println(query.toString());
            } catch (SQLException e){
                System.out.println(e);
            }
        }
    }
}
