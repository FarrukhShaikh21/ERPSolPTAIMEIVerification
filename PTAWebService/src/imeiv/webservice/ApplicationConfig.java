package imeiv.webservice;

import javax.ws.rs.ApplicationPath;

import javax.ws.rs.core.Application;


@ApplicationPath("service")

public class ApplicationConfig extends Application {
    public ApplicationConfig() {
        super();
    }
}
