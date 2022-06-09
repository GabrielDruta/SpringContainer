package beans.injections.factories;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class ProductWithFieldDep {

    @Autowired
    private FactoryProductDependency dependency;
    public boolean postConstruct = false;

    @PostConstruct
    private void postConstruct() {
        postConstruct = true;
    }

    public FactoryProductDependency getDependency() {
        return dependency;
    }
}
