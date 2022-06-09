package beans.injections.factories;

import javax.annotation.PostConstruct;

public class ProductwithConstructorDep {

    final private FactoryProductDependency dependency;

    public boolean postConstruct=false;

    @PostConstruct
    private void postConstruct(){
        postConstruct=true;
    }

    public FactoryProductDependency getDependency() {
        return dependency;
    }

    public ProductwithConstructorDep(FactoryProductDependency dependency) {
        this.dependency = dependency;
    }
}
