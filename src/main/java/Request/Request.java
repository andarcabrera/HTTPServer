package Request;

import java.util.ArrayList;


public class Request implements RequestBuilder {
    private String rawRequest;
    private String rawHeader = "";
    private String rawBody = "";
    private String method = "";
    private String url = "";
    private String version= "";
    private String initialLine = "";
    private ArrayList<String> headers = new ArrayList<String>();
    private String requestBody = "";

    public Request(StringBuffer rawRequest){
        this.rawRequest = rawRequest.toString();
    }

    public void setRequestDetails(){
        separateHeaderBody();
        setHeaderLines();
        processInitialLine();
    }

    public String getRawHeader(){
        return rawHeader;
    }

    public String getInitialLine(){
        return initialLine;
    }

    public ArrayList<String> getHeaders(){
        return headers;
    }

    public String getRawBody(){
        return rawBody;
    }

    public String getMethod(){
        return method;
    }

    public String getUrl(){
        return url;
    }

    public String getVersion(){
        return version;
    }


    private void separateHeaderBody(){
        String[] parsedRequest = rawRequest.split("\n\\s*\n");
        if (parsedRequest.length == 2) {
            rawHeader = parsedRequest[0];
            rawBody = parsedRequest[1];
        }else {
            rawHeader = rawRequest;
        }
    }

    private void setHeaderLines(){
        for (int i = 0; i < getRawHeaderLines().length;i++){
            if (methodName(getRawHeaderLines()[i])){
                initialLine = getRawHeaderLines()[i];
                System.out.println(initialLine);
                System.out.println("initial line " + initialLine);
            }else{
                headers.add(getRawHeaderLines()[i]);
            }
        }
    }

    private void processInitialLine() {
        String[] parsedLine = getInitialLine().split(" ");
        method = parsedLine[0];
        url = parsedLine[1];
        version = parsedLine[2];

    }

    private String[] getRawHeaderLines() {
        return rawHeader.split("\n");
    }

    private boolean methodName(String line){
        String firstWord = line.split(" ")[0];
        return MethodNames.methodNames.contains(firstWord);
    }
}
