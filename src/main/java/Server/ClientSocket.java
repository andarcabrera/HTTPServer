package Server;

import IOStreams.HttpInputStream;
import IOStreams.HttpOutputStream;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public interface ClientSocket {
    HttpInputStream getInputStream();
    HttpOutputStream getOutputStream();
}
