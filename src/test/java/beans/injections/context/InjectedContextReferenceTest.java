package beans.injections.context;

import beans.ApplicationContextTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;


public class InjectedContextReferenceTest extends ApplicationContextTest {

    @Test
    public void testInjectionOfContext() {
        BeanWithContainerReferenceInjected bean = context.getBean(BeanWithContainerReferenceInjected.class);
        Assertions.assertNotNull(bean);
        Assertions.assertNotNull(bean.getContext());
        Assertions.assertTrue(ApplicationContext.class.isAssignableFrom(bean.getContext().getClass()));

    }
}
