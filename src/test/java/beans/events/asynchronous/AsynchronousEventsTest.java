package beans.events.asynchronous;

import beans.ApplicationContextTest;
import beans.events.CustomSpringEvent;
import beans.events.EventPublisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashSet;
import java.util.Set;

public class AsynchronousEventsTest extends ApplicationContextTest {
    @Test
    public void testAsynchronousEvents() {
        EventPublisher publisher = context.getBean(EventPublisher.class);
        Assertions.assertNotNull(publisher);
        new Thread(() -> publisher.publishEvent("Event number 1")).start();
        new Thread(() -> publisher.publishEvent("Event number 2")).start();


        ///force wait

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("cannot slee.", e);
        }

        // force closing of executor in order to force event processing
        ThreadPoolTaskExecutor executor = context.getBean(ThreadPoolTaskExecutor.class);
        executor.shutdown();

        AsynchronousEventListener asynchronousEventListener = context.getBean(AsynchronousEventListener.class);
        Assertions.assertNotNull(asynchronousEventListener);


        Assertions.assertEquals(publisher, asynchronousEventListener.getProcessedEvents().get(0).getSource());
        Assertions.assertEquals(publisher, asynchronousEventListener.getProcessedEvents().get(1).getSource());
        Assertions.assertEquals(2, asynchronousEventListener.getProcessedEvents().size());


        //order of messages is not guaranteed
        Set<String> messages = new HashSet<>();
        for (CustomSpringEvent event : asynchronousEventListener.getProcessedEvents()) {
            messages.add(event.getMessage());
        }
        Assertions.assertTrue(messages.contains("Event number 1"));
        Assertions.assertTrue(messages.contains("Event number 2"));

        //assume htat 2 diiff threads prcessed the messages
        Assertions.assertEquals(2, asynchronousEventListener.getProcessingThreads().size());
    }
}
