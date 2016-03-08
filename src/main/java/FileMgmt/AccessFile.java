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

    public byte[] readPartiallyFromFile(String fileName, String rawRange) {
        FileInputStream fileInputStream = null;
        File file = new File(fileName);

        int[] range = parsedRange(rawRange, file);
        byte[] fileContent = new byte[range[1] - range[0] + 1];

        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.skip(range[0]);
            fileInputStream.read(fileContent, 0, range[1] - range[0] + 1);
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileContent.length);
        return fileContent;
    }


    private int[] parsedRange(String rawRange, File file){
        int[] range = new int[2];
        String[] rangeString = new String[2];

        String[] parsedRawRange = rawRange.split("=");
        String rawRangeLimits = parsedRawRange[1];
        if (rawRangeLimits.trim().length() == 3) {
            rangeString = rawRangeLimits.split("-");
        }else if(rawRangeLimits.trim().length() == 2) {
            if (rawRangeLimits.substring(1, 2).equals("-")) {
                rangeString[0] = rawRangeLimits.substring(0, 1);
                rangeString[1] = String.valueOf(file.length() - 1);
            } else {
                rangeString[0] = "71";
                rangeString[1] = String.valueOf(file.length() - 1);
            }
        }

        System.out.println(rangeString[0]);
        System.out.println(rangeString[1]);
        range[0] = Integer.parseInt(rangeString[0].trim());
        range[1] = Integer.parseInt(rangeString[1].trim());
        return range;
    }
}




