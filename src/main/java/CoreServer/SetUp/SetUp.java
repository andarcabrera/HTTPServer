package CoreServer.SetUp;

import java.util.Properties;

public class SetUp {
    private String[] args;
    private int port;
    private String directory;

    public SetUp(String[] args){
        this.args = args;
        setPort();
        setDirectory();
    }

    public int getPort(){
        return port;
    }

    private void setPort(){
        if(args[0].equals("-p")){
            port = Integer.parseInt(args[1]);
        }
    }

    private void setDirectory(){
        if(args[2].equals("-d")){
            directory = args[3];
            setSystemPropertiesDirectory(directory);
        }
    }

    private void setSystemPropertiesDirectory(String directory){
        Properties props = System.getProperties();
        props.setProperty("source_directory", directory);
    }
}
