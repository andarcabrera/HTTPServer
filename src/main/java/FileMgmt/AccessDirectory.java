package FileMgmt;

import java.io.File;


public class AccessDirectory {
    public File[] getFiles(String directoryName){
        File directory = new File(directoryName);
        return directory.listFiles();
    }
}
