package IOStreams;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public interface HttpInputStream {
    char read();
    String readLine();
    boolean ready();
}
