package CobSpecApp.Parsers;

import java.util.Base64;

/**
 * Created by andacabrera29 on 3/14/16.
 */
public class Base64ParserAndDecoder {
    private String user;
    private String password;
    Base64.Decoder decoder = Base64.getDecoder();

    public String getUser(){
        return user;
    }

    public String getPassword(){
        return password;
    }

    private void setUserandPassword(String decodedAuthorization){
        String[] splitDecodedAuthorization = decodedAuthorization.split(":");
        user = splitDecodedAuthorization[0];
        password = splitDecodedAuthorization[1];
    }

    public void decodeBase64(String entireMessage){
        String encodedAuthorization = getEncodedAuthorization(entireMessage);
        byte[] decodedAuthorization = decoder.decode(encodedAuthorization);
        String authorization =  new String(decodedAuthorization);
        setUserandPassword(authorization);
    }

    private String getEncodedAuthorization(String entireMessage){
        String[] splitMessage = entireMessage.trim().split(" ");
        return splitMessage[1];
    }
}
