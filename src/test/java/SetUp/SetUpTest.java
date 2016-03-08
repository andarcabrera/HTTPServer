package SetUp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SetUpTest {
    private SetUp serverSetup;

    @Before
    public void setup(){
        String[] args = {"-p", "5000", "-d", "/file/public"};
        serverSetup = new SetUp(args);
    }

    @Test
    public void testGetPort() throws Exception {
        assertEquals(5000, serverSetup.getPort());
    }

}