package services;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class StartupService {

    @PostConstruct
    public void postConstruct() {        
        System.out.println("---------------- StartupService service started by CDI ---------------------------");
    }
}

