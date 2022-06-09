package beans.events.asynchronous;


import beans.events.CustomSpringEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//consumer of events
@Component
public class AsynchronousEventListener {

    //enable Async methods
    @Async

    //consumption of the event
    @EventListener
    public void processEvent(CustomSpringEvent event){
        processedEvents.add(event);
        processingThreads.add(Thread.currentThread());

        //enure processing takes longer so that another thread wikl take the net mesasge
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException("can't sleep", e);
        }
    }


    public List<CustomSpringEvent> getProcessedEvents() {
        return processedEvents;
    }

    public Set<Thread> getProcessingThreads() {
        return processingThreads;
    }

    final private List<CustomSpringEvent> processedEvents = new ArrayList<>();
    final private Set<Thread> processingThreads = new HashSet<>();
}
