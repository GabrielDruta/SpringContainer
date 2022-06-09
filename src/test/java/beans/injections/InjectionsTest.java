package beans.injections;

import beans.ApplicationContextTest;
import beans.injections.ii.MySqlRepository;
import beans.injections.ii.OracleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InjectionsTest extends ApplicationContextTest {
    @Test
    public void testII(){
        Service bean=context.getBean(Service.class);
        Assertions.assertNotNull(bean);
        Assertions.assertNotNull(bean.repository1);
        Assertions.assertEquals(bean.repository1.getClass(), OracleRepository.class);
        Assertions.assertNotNull(bean.repository2);
        Assertions.assertEquals(bean.repository2.getClass(), MySqlRepository.class);

    }
}
