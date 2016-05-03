package CoreServer.Controllers;

import CoreServer.Request.RequestBuilder;
import CoreServer.Response.Response;

import java.lang.reflect.Method;


public abstract class Controller implements ControllerStrategy {
    protected Response response;
    protected RequestBuilder request;
    protected  String methodsAllowed;

    public Controller(RequestBuilder request, Response response, String methodsAllowed){
        this.request = request;
        this.response = response;
        this.methodsAllowed = methodsAllowed;
    }

    public Response sendResponse(String action){
        try{
            Class cls = this.getClass();
            Object obj = this;

            Method method = cls.getDeclaredMethod(action);
            response = (Response) method.invoke(obj, null);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return response;
    }
}