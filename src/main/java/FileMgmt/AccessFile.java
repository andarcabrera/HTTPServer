package FileMgmt;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class AccessFile {

    public String readFromFile(String fileName){
        File path = new File(System.getProperty("user.home"), "/Desktop/cob_spec/public");

        StringBuffer result = new StringBuffer("");

        if (fileName.equals("/")){
            return "HTTP/1.0 200 OK\n";
        }

          try (Scanner scanner = new Scanner(new File(path, fileName))) {
              result.append("HTTP/1.0 200 OK\n\n");

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    result.append(line).append("\n");
                }

                scanner.close();

            } catch (IOException e) {
                result.append("HTTP/1.0 404 Not Found\n");
                e.printStackTrace();
            }

            return result.toString();

        }
}
