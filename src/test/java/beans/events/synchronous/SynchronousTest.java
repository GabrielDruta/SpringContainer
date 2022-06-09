package beans.events.synchronous;

import beans.ApplicationContextTest;
import beans.events.EventPublisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SynchronousTest extends ApplicationContextTest {
    @Test
    public void testSynchronousEventConsumer(){
        EventPublisher publisher=context.getBean(EventPublisher.class);
        Assertions.assertNotNull(publisher);
        publisher.publishEvent("event message 1");
        publisher.publishEvent("event message 2");

        SynchronousEventListener listener=context.getBean(SynchronousEventListener.class);
        Assertions.assertNotNull(listener);
        Assertions.assertEquals(2, listener.processedEvents.size());
        Assertions.assertEquals("event message 1", listener.processedEvents.get(0).getMessage());
        Assertions.assertEquals(publisher, listener.processedEvents.get(0).getSource());
        Assertions.assertEquals(Thread.currentThread(), listener.processedByThreads.get(1));
    }
}
