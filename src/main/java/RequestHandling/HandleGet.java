package RequestHandling;

import FileMgmt.AccessFile;
import Request.RequestBuilder;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class HandleGet implements HandleAction{
    private RequestBuilder request;

    private AccessFile accessFile = new AccessFile();

    public void setRequest(RequestBuilder request){
        this.request = request;
    }

    public String getResponse(){
        return accessFile.readFromFile(request.getUrl());
    }
}
