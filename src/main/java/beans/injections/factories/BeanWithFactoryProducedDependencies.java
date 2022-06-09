package beans.injections.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanWithFactoryProducedDependencies {
    @Autowired
    public ProductWithSetterDep productWithSetterDep;

    @Autowired
    public ProductwithConstructorDep productwithConstructorDep;

    @Autowired
    public ProductWithFieldDep productWithFieldDep;
}
