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

          try (Scanner scanner = new Scanner(new File(path, fileName))) {

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    result.append(line).append("\n");
                }

                scanner.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return result.toString();

        }
}
