package com.gjaras.webserver;

import org.slf4j.LoggerFactory;

public class StartServer {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(StartServer.class);

    private static InternalWebServer iws;

    public static void main(String[] args) throws Exception {
        start(args);
        join();
    }

    public static synchronized void start(String[] args) throws Exception {
        LOG.info("Starting server...");
        iws = new InternalWebServer();
        iws.start();

        LOG.info("Server started.");
    }

    public static synchronized void stop(String[] args) throws Exception {
        LOG.info("Stopping server...");
        if (iws != null) {
            LOG.info("Stopping InternalWebServer...");
            iws.stop();
            LOG.info("InternalWebServer stopped.");
        }
        LOG.info("Server stopped.");
    }

    public static void join() throws Exception {
        if (iws != null) {
            iws.join();
        }
    }
}
