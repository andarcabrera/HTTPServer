package CoreServer.Request;

import java.util.HashMap;
import java.util.Map;


public class HttpRequest implements Request {
    private String rawRequest;
    private String rawHeader = "";
    private String rawBody = "";
    private String method = "";
    private String url = "";
    private HashMap<String, String> params = new HashMap<>();
    private String version= "";
    private String initialLine = "";
    private HashMap<String, String> headers = new HashMap<>();
    private String requestBody = "";

    public void buildRequest(StringBuffer rawRequest){
        this.rawRequest = rawRequest.toString();
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

    public HashMap<String, String> getHeaders(){
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

    public HashMap<String, String> getParams(){
        return params;
    }

    public String getRequestAction(){
        return getMethod() + " " + getUrl();
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
        initialLine = getRawHeaderLines()[0];
        for (int i = 1; i < getRawHeaderLines().length ;i++){
            String[] headerInfo = getRawHeaderLines()[i].split(": ");
            if (headerInfo.length == 2) {
                String headerTitle = headerInfo[0];
                String headerBody = headerInfo[1];
                headers.put(headerTitle, headerBody);
            }
        }
    }

    private void processInitialLine() {
        String[] parsedLine = getInitialLine().split(" ");
        if (rawBody.startsWith("_method")){
            method = "PUT";
        } else {
            method = parsedLine[0];
        }
        if (parsedLine.length > 1){
            getUrlAndParams(parsedLine[1]);
            version = parsedLine[2];
        }

    }

    private String[] getRawHeaderLines() {
        return rawHeader.split("\n");
    }

    private void getUrlAndParams(String rawUrlParams){
        String[] rawVariables = getRawVariables(rawUrlParams);
        for (String rawVariable : rawVariables ){
            String name = getVariableName(rawVariable);
            String rawContent = getVariableContent(rawVariable);
            String content = processRawVariable(rawContent);
            params.put(name, content);
        }
    }

    private String getVariableName(String rawVariable){
        String[] splitVariable = rawVariable.split("=");
        return splitVariable[0];
    }

    private String getVariableContent(String rawVariable){
        String[] splitVariable = rawVariable.split("=");
        String content  = "";
        if (splitVariable.length > 1){
            content = splitVariable[1];
        }
        return content;
    }

    private String processRawVariable(String rawVariable){
        String decodedVariable = rawVariable;
        HashMap<String, String> decoder = decodeUrl();
        for (Map.Entry<String, String> entry : decoder.entrySet()) {
            String urlCode = entry.getKey();
            String decodedText = entry.getValue();
            decodedVariable = decodedVariable.replaceAll(urlCode, decodedText);
        }
        return  decodedVariable.replaceAll("24", "\\$");
    }

    private String[] getRawVariables(String rawUrlParams){
        String rawParams = getRawParams(rawUrlParams);
        String[] rawVariables = rawParams.split("&");
        return rawVariables;
    }

    private String getRawParams(String rawUrlParams){
        String rawParameters = "";
        String[] parsedUrl = rawUrlParams.split("\\?");
        url = parsedUrl[0];

        if (parsedUrl.length > 1){
            rawParameters = parsedUrl[1];
        }
        return rawParameters;
    }

    private HashMap decodeUrl(){
        HashMap<String, String> urlCodes = new HashMap();
        urlCodes.put("20", " ");
        urlCodes.put("22", "\"");
        urlCodes.put("23", "#");
        urlCodes.put("26", "&");
        urlCodes.put("40", "@");
        urlCodes.put("43", "+");
        urlCodes.put("2B", "+");
        urlCodes.put("2C", ",");
        urlCodes.put("2F", "/");
        urlCodes.put("3A", ":");
        urlCodes.put("3B", ";");
        urlCodes.put("3C", "<");
        urlCodes.put("3D", "=");
        urlCodes.put("3E", ">");
        urlCodes.put("3F", "?");
        urlCodes.put("5B", "[");
        urlCodes.put("5D", "]");
        urlCodes.put("%", "");
        return urlCodes;
    }
}
