package beans.prototype;

import beans.ApplicationContextTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPrototype extends ApplicationContextTest {

    @Test
    public void testPrototype(){
        Prototype bean1=context.getBean(Prototype.class);
        Prototype bean2=context.getBean(Prototype.class);
        Assertions.assertNotSame(bean1, bean2);
    }

}
