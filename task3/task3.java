import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class task3 {
    public static void main(String[] args) throws Exception {
    	 Scanner in = new Scanner(System.in);  
         System.out.print("tests file path: ");
         String file1 = in.nextLine();
         System.out.print("values file path: ");
         String file2 = in.nextLine();
        JSONParser parser = new JSONParser();
        
        try {
            Object obj1 = parser.parse(new FileReader(file1));
            JSONObject tests = (JSONObject) obj1;
            Object obj2 = parser.parse(new FileReader(file2));
            JSONObject values = (JSONObject) obj2;
                        
            // Replace the "value" key in file1 with the extracted value
            tests.put("value", values);
            
            // Write the modified JSON object to a new file called "result.json"
            writeFile("result.json", tests.toString());
            System.out.println("Created result.json");
            
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        
        
   
    }

    private static void writeFile(String path, String contents) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(contents);
        }
}}