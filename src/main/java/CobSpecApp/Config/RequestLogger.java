package CobSpecApp.Config;

import CoreServer.FileMgmt.AccessFile;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by andacabrera29 on 3/14/16.
 */
public class RequestLogger {
    public final static Logger logger = Logger.getLogger(RequestLogger.class.getName());
    private static FileHandler requests;

    public static void init() {
        try {
            requests = new FileHandler("./requests.log");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        Logger requestLogger = Logger.getLogger("");
        requests.setFormatter(new SimpleFormatter());
        SimpleFormatter formatterTxt = new SimpleFormatter();
        requests.setFormatter(formatterTxt);

        requestLogger.addHandler(requests);
        requestLogger.setLevel(Level.INFO);
    }

    public static void resetLog() {
        AccessFile accessFile = new AccessFile();
        accessFile.deleteFileContent("./requests.log");
    }

    public static byte[] generateLogContent() {
        AccessFile accessFile = new AccessFile();
        return accessFile.readFromFile("./requests.log");
    }
}


