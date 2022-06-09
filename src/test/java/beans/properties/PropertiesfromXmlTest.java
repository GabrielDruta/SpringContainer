package beans.properties;

import beans.ApplicationContextTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PropertiesfromXmlTest extends ApplicationContextTest {


    //test the values taken from spring-beans.xml file bean definition
    @Test
    public void testInjectionPropertiesFromXml(){
        BeanWithPropertiesInjectedFromXml bean=context.getBean(BeanWithPropertiesInjectedFromXml.class);
        Assertions.assertNotNull(bean);
        Assertions.assertEquals("customConstructorXmlValue",    bean.getConstructorProperty());
        Assertions.assertEquals(2, bean.getSimpleProperty());

    }
}
