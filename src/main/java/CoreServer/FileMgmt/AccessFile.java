package CoreServer.FileMgmt;

import CobSpecApp.Parsers.RangeParser;

import java.io.*;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class AccessFile implements FileAccess{
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    RangeParser parser = new RangeParser();

    public byte[] readFromFile(String fileName) {
        File file = new File(fileName);
        byte[] fileContent = new byte[(int) file.length()];
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileContent);
            fileInputStream.close();
        } catch (FileNotFoundException  e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public byte[] readPartiallyFromFile(String fileName, String rawRange) {
        File file = new File(fileName);
        int containerSize = parser.containerSize(rawRange, (int) file.length());
        byte[] fileContent = new byte[containerSize];
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.skip(parser.getSkipedBytes());
            fileInputStream.read(fileContent, 0, containerSize);
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public void writeToFile(String fileName, String message){
        File file = new File(fileName);
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFileContent(String fileName){
        File file = new File(fileName);
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write("".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




