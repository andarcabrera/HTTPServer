package Helpers;

/**
 * Created by andacabrera29 on 3/9/16.
 */
public class RangeParser {
    private String rawRangeInfo;
    private int lowerRange;
    private int upperRange;
    private int skippedBytes;

    public int containerSize(String rawRange, int fileLength){
        getRange(rawRange, fileLength);
        return upperRange - lowerRange;
    }

    public int getSkipedBytes(){
        return skippedBytes;
    }

    private void getRange(String rawRange, int fileLength){
        splitRangeInfo(rawRange);

        if (rawRangeInfo.startsWith("-")) {
            bytesFromEndofFileProvided(rawRangeInfo, fileLength);
        } else if (rawRangeInfo.endsWith("-")) {
            lowerLimitProvided(rawRangeInfo, fileLength);
        } else {
            twoLimitsProvided(rawRangeInfo);
        }
    }

    private void twoLimitsProvided(String rangeInfo){
        String[] splitRangeInfo = rangeInfo.split("-");
        lowerRange = Integer.parseInt(splitRangeInfo[0]);
        upperRange = Integer.parseInt(splitRangeInfo[1]) + 1;
        skippedBytes = lowerRange;
    }

    private void lowerLimitProvided(String rangeInfo, int fileLength){
        String[] splitRangeInfo = rangeInfo.split("-");
        lowerRange = Integer.parseInt(splitRangeInfo[0]);
        upperRange = fileLength;
        skippedBytes = lowerRange;
    }

    private void bytesFromEndofFileProvided(String rangeInfo, int fileLength){
        String trimmedRangeLimit = rangeInfo.substring(1);
        lowerRange = fileLength - Integer.parseInt(trimmedRangeLimit);
        upperRange = fileLength;
        skippedBytes = upperRange-Integer.parseInt(trimmedRangeLimit);
    }

    private void splitRangeInfo(String rawRange){
        rawRangeInfo = rawRange.split("=")[1].trim();
    }
}
