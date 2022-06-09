package beans.injections.types;

import beans.ApplicationContextTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InjectionTypesTest extends ApplicationContextTest {
    @Test
    public void testInjectionTypes(){
        InjectionTarget bean=context.getBean(InjectionTarget.class);
        Assertions.assertNotNull(bean);
        Assertions.assertTrue(bean.isConstructorUsedInInjection());
        Assertions.assertTrue(bean.isSetterUsedInInjection());

        Assertions.assertNotNull(bean.getConstructorDependency());
        System.out.println(bean.getConstructorDependency().execute());
        Assertions.assertEquals(ConstructorDependency.class, bean.getConstructorDependency().getClass());
        Assertions.assertNotNull(bean.getFieldDependency());
        Assertions.assertSame(FieldDependency.class, bean.getFieldDependency().getClass());
        Assertions.assertNotNull(bean.getSetterDependency());
        Assertions.assertEquals(SetterDependency.class, bean.getSetterDependency().getClass());


    }



}
