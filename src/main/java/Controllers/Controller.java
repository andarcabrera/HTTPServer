package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;

import java.lang.reflect.Method;


public abstract class Controller implements ControllerStrategy {
    protected ResponseBuilder response;
    protected RequestBuilder request;
    protected  String methodsAllowed;
    protected String sourceDirectory = System.getProperty("source_directory");

    public Controller(RequestBuilder request, ResponseBuilder response, String methodsAllowed){
        this.request = request;
        this.response = response;
        this.methodsAllowed = methodsAllowed;
    }

    public ResponseBuilder sendResponse(String action){
        try{
            Class cls = this.getClass();
            Object obj = this;

            Method method = cls.getDeclaredMethod(action);
            response = (ResponseBuilder) method.invoke(obj, null);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return response;
    }
}
