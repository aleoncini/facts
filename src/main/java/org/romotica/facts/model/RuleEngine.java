package org.romotica.facts.model;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.romotica.facts.model.channels.NullChannel;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("rules")
public class RuleEngine {

    private org.slf4j.Logger logger = LoggerFactory.getLogger("org.romotica");
    private KieSession kSession;

    public RuleEngine(){
        this.init();
    }

    private void init(){
        logger.info("===> Init Rule Engine");
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            kSession = kContainer.newKieSession("ksession-rules");
            kSession.registerChannel("null_channel", new NullChannel());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        logger.info("===> Rule Engine ready to fire rules.");
    }

    public void processEvent(Event event){
        logger.info("===> received new event");
        kSession.insert(event);
        kSession.fireAllRules();
    }

}