package Helpers;

/**
 * Created by andacabrera29 on 3/9/16.
 */
public class RangeParser {
    private String rawRangeInfo;
    private int[] range = new int[2];

    public int[] getRange(String rawRange, int fileLength){
        splitRangeInfo(rawRange);

        if (rawRangeInfo.startsWith("-")) {
            bytesFromEndofFileProvided(rawRangeInfo, fileLength);
        } else if (rawRangeInfo.endsWith("-")) {
            lowerLimitProvided(rawRangeInfo, fileLength);
        } else {
            twoLimitsProvided(rawRangeInfo);
        }
        return range;
    }

    private void twoLimitsProvided(String rangeInfo){
        String[] splitRangeInfo = rangeInfo.split("-");
        range[0] = Integer.parseInt(splitRangeInfo[0]);
        range[1] = Integer.parseInt(splitRangeInfo[1]) + 1;
    }

    private void lowerLimitProvided(String rangeInfo, int fileLength){
        String[] splitRangeInfo = rangeInfo.split("-");
        range[0] = Integer.parseInt(splitRangeInfo[0]);
        range[1] = fileLength;
    }

    private void bytesFromEndofFileProvided(String rangeInfo, int fileLength){
        String trimmedRangeLimit = rangeInfo.substring(1);
        range[0] = fileLength - Integer.parseInt(trimmedRangeLimit);
        range[1] = fileLength;
    }

    private void splitRangeInfo(String rawRange){
        rawRangeInfo = rawRange.split("=")[1].trim();
    }
}
