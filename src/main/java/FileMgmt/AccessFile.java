package FileMgmt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class AccessFile {

    public byte[] readFromFile(String fileName) {
        FileInputStream fileInputStream = null;
        File file = new File(fileName);

        byte[] fileContent = new byte[(int) file.length()];

        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileContent);
            fileInputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}




