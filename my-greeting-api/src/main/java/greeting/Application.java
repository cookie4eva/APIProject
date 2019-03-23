package greeting;

import greeting.server.EmbeddedJetty;
import org.apache.log4j.BasicConfigurator;

public class Application {

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        new EmbeddedJetty().startJetty(8089);
    }
}
