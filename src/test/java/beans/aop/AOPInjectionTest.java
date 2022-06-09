package beans.aop;

import beans.ApplicationContextTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

public class AOPInjectionTest extends ApplicationContextTest {

    @Test
    public void testAOPok(){
        BeanAffectedByAop bean = context.getBean(BeanAffectedByAop.class);
        Assertions.assertNotNull(bean);
        System.out.println("");

        System.out.println(bean.complexBusiness());

    }

    @Test
    public void testAOPfail(){
        Assertions.assertThrows(RuntimeException.class,
                ()-> {
                BeanAffectedByAop bean = context.getBean(BeanAffectedByAop.class);
                Assertions.assertNotNull(bean);
                    System.out.println(bean.complexBusinessThatThrowsException());
                });
    }
}
