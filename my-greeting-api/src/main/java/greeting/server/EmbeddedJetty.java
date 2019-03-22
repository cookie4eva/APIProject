package greeting.server;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

@Slf4j
public class EmbeddedJetty {

    public void startJetty(int port) throws Exception {
        Server server = new Server(port);
        server.setHandler(getServletContextHandler());
        server.start();
        server.join();
    }

    private ServletContextHandler getServletContextHandler() throws IOException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setErrorHandler(null);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), "/");
        return contextHandler;
    }

}
