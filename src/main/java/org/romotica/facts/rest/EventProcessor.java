package org.romotica.facts.rest;

import org.romotica.facts.model.Event;
import org.romotica.facts.model.RuleEngine;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/events")
public class EventProcessor {
    @Inject
    @Named("rules")
    private RuleEngine engine;

    @GET
    @Produces("text/plain")
    public Response doGet() {
        return Response.ok("This a rest interface to process events with Drools Engine.").build();
    }

    @GET
    @Produces("text/plain")
    @Path("/put")
    public Response processEvent(@QueryParam("type") String type,
                                 @QueryParam("name") String name,
                                 @QueryParam("message") String message,
                                 @QueryParam("value") double value) {
        Event event = new Event();
        event.setName(name);
        event.setType(type);
        event.setValue(value);
        event.setMessage(message);
        engine.processEvent(event);
        return Response.ok("Event Processed").build();
    }
}