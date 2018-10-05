package com.gjaras.webserver;

import com.gjaras.util.Config;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InternalWebServer {

    private static final Logger LOG = LoggerFactory.getLogger(InternalWebServer.class);
    private final Server server;

    public InternalWebServer() throws Exception {
        LOG.info("Starting internal web services...");
        server = new Server(Integer.parseInt(Config.get("PORT")));

        // handler de los servlets (webservices del paquete rest)
        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);

        // servlet params
        ServletHolder sh = new ServletHolder(ServletContainer.class);
        sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
                "com.sun.jersey.api.core.PackagesResourceConfig");
        sh.setInitParameter("com.sun.jersey.config.property.packages",
                "com.gjaras.groovyWS");
        sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        context.addServlet(sh, "/vistahermosaws/*");

        // contenedor de todos los handlers
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{context, new DefaultHandler()});

        server.setHandler(handlers);

    }

    public void start() throws Exception {
        if (server.isStarted()) {
            LOG.info("Internal web server already started.");
        } else {
            LOG.info("Starting Internal web server...");
            server.start();
            LOG.info("Internal web server started.");
        }
    }

    public void join() throws Exception {
        server.join();
    }

    public void stop() throws Exception {
        server.stop();
    }
}
