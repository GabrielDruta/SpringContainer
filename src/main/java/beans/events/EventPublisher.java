package beans.events;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

//producer of events
@Component
public class EventPublisher {

    //Spring event firing mechanism
    @Autowired
    private ApplicationEventPublisher containerPublisher;

    public void publishEvent(String message){
        System.out.println("publishing event with custom message: "+message);

        //build the event
        CustomSpringEvent customSpringEvent=new CustomSpringEvent(this, message);

        //fire the event
        containerPublisher.publishEvent(customSpringEvent);
    }

}
