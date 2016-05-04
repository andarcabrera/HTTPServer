package CoreServer.Controllers;

import CoreServer.Request.Request;
import CoreServer.Response.Response;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Controller implements ControllerStrategy {
    protected Response response;
    protected Request request;
    protected String methodsAllowed;

    public Controller(Request request, Response response, String methodsAllowed){
        this.request = request;
        this.response = response;
        this.methodsAllowed = methodsAllowed;
    }

    public Response sendResponse(String controllerAction) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class activeController = this.getClass();
        Object currentObject = this;
        Method method = activeController.getDeclaredMethod(controllerAction);
        response = (Response) method.invoke(currentObject, null);
        return response;
    }
}
