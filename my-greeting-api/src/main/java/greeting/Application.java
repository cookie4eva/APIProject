package greeting;

import greeting.server.EmbeddedJetty;

public class Application {

    public static void main(String[] args) throws Exception {
        new EmbeddedJetty().startJetty(8089);
    }
}
