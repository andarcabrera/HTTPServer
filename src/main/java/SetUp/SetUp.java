package SetUp;

public class SetUp {
    private String[] args;
    private String port;
    private String directory;

    public SetUp(String[] args){
        this.args = args;
        setPort();
        setDirectory();
    }

    private void setPort(){
        if(args[0].equals("-p")){
            port = args[1];
        }
    }

    private void setDirectory(){
        if(args[2].equals("-d")){
            directory = args[3];
        }
    }

    public String getPort(){
        return port;
    }

    public String getDirectory(){
        return directory;
    }
}
