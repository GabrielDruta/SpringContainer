package beans.singleton;

import beans.ApplicationContextTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest extends ApplicationContextTest {

    @Test
    public void TestSingleton() {
        MySingleton bean1 = context.getBean(MySingleton.class);
        MySingleton bean2 = context.getBean(MySingleton.class);
        Assertions.assertSame(bean1, bean2);

    }
}
