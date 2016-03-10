package Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class Logger {
    String fileName;
    private File logFile;
    FileOutputStream outputStream;

    public Logger(String fileName){
        this.fileName = fileName;
        this.logFile = new File(fileName);
        createOutputStream();
    }

    public void createOutputStream(){
        try {
            outputStream = new FileOutputStream(logFile, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void log(String message){
        try {
            outputStream.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
