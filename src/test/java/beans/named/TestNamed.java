package beans.named;

import beans.ApplicationContextTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNamed extends ApplicationContextTest {

    @Test
    public void testNamedSingleton(){
        NamedSingleton bean1= (NamedSingleton) context.getBean("myNamedSingleton");
        Assertions.assertNotNull(bean1);

    }
}
