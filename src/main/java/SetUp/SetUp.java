package SetUp;

import CobSpecApp.Config.CobspecRoutes;
import CobSpecApp.Controllers.CobSpecControllerFactory;
import CoreServer.Controllers.AbstractControllerFactory;
import CoreServer.Router.RoutesConfig;
import TTTApp.Config.TTTRoutes;
import TTTApp.Controllers.TTTControllerFactory;

public class SetUp {
    private String[] args;
    private int port;
    private String directory;
    private AbstractControllerFactory controllerFactory;
    private RoutesConfig routesConfig;

    public SetUp(String[] args){
        this.args = args;
        configure();
    }

    public int getPort(){
        return port;
    }

    public AbstractControllerFactory getControllerFactory(){
        return controllerFactory;
    }

    public RoutesConfig getRoutesConfig(){
        return routesConfig;
    }

    private void configure(){
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("-p")) {
                setPort(i + 1);
            } else if (args[i].equals("-d")){
                setDirectory(i + 1);
            } else if (args[i].equals("-app")) {
                setAppRoutesAndControllers(i + 1);
            }
        }
    }

    private void setPort(int argIndex){
        port = Integer.parseInt(args[argIndex]);
    }

    private void setDirectory(int argIndex){
        directory = args[argIndex];
    }

    private void setAppRoutesAndControllers(int argIndex){
        if(args[argIndex].equals("cob")){
            controllerFactory = new CobSpecControllerFactory(directory);
            routesConfig = new CobspecRoutes();
        } else if (args[argIndex].equals("ttt")){
            controllerFactory = new TTTControllerFactory();
            routesConfig = new TTTRoutes();
        }
    }
}
