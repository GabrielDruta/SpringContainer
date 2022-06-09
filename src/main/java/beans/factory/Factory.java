package beans.factory;

import beans.prototype.Prototype;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
public class Factory {

    @Bean
    Produs createProdus() {
        return new Produs();
    }

    @Bean
    @Scope("prototype")
    Prototyp createPrototyp() {
        return new Prototyp();
    }

//    @Bean
//    @Scope("prototype")
//    @Qualifier("prototypeName")
//    Prototype createPrototype() {
//        return new Prototype();
//    }

}
