package org.romotica.facts.model.channels;

import org.kie.api.runtime.Channel;
import org.slf4j.LoggerFactory;

public class NullChannel implements Channel {

    private org.slf4j.Logger logger = LoggerFactory.getLogger("org.romotica.facts");

    @Override
    public void send(Object object) {
        logger.info(String.format("[NullChannel] sending object [%s] to logs", object));
    }

}