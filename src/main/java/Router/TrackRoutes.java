package Router;

import java.util.ArrayList;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public interface TrackRoutes {
    ArrayList<Route> routes = new ArrayList<>();
    ArrayList<Route> getRoutes();
    String routeOptions(String action);
}
