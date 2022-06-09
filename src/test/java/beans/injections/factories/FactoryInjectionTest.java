package beans.injections.factories;

import beans.ApplicationContextTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryInjectionTest extends ApplicationContextTest {

    @Test
    public void testBeanWithFactoryProducedDependency(){

        BeanWithFactoryProducedDependencies bean= context.getBean(BeanWithFactoryProducedDependencies.class);
        Assertions.assertNotNull(bean);
        {
           //
            ProductWithFieldDep dep1 = bean.productWithFieldDep;
            Assertions.assertNotNull(dep1);
            Assertions.assertTrue(dep1.postConstruct);
            Assertions.assertNotNull(dep1.getDependency());
            System.out.println(dep1.getDependency());
        }

        {
            ProductwithConstructorDep dep2=bean.productwithConstructorDep;
            Assertions.assertNotNull(dep2);
            Assertions.assertTrue(dep2.postConstruct);
            Assertions.assertNotNull(dep2.getDependency());
            System.out.println(dep2.getDependency());
        }

        {
            ProductWithSetterDep dep3=bean.productWithSetterDep;
            Assertions.assertNotNull(dep3);
            Assertions.assertTrue(dep3.postConstruct);
            Assertions.assertNotNull(dep3.getDependency());
            System.out.println(dep3.getDependency());
        }

        FactoryOfProducts factory=context.getBean(FactoryOfProducts.class);
        Assertions.assertNotNull(factory);
        Assertions.assertTrue(factory.usedProductWithConstructorDep);
        Assertions.assertTrue(factory.usedProductWithFieldDep);
        Assertions.assertTrue(factory.usedProductWithSetterDep);



    }
}
