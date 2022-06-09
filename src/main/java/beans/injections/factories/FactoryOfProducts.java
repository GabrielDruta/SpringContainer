package beans.injections.factories;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//builds the products used in dependency injeciton
@Configuration
public class FactoryOfProducts {

    public boolean usedProductWithConstructorDep=false;
    public boolean usedProductWithFieldDep=false;
    public boolean usedProductWithSetterDep=false;

    @Bean
    //injection on product is performed automatically after return
    public ProductWithFieldDep productWithFieldDep(){
        usedProductWithFieldDep=true;
        return new ProductWithFieldDep();
    }

    @Bean
    //injections on factory param are perofom automaticalel
    //no need to write @Autowired on method param
    public ProductwithConstructorDep productwithConstructorDep(FactoryProductDependency dependency){
        usedProductWithConstructorDep=true;
        return new ProductwithConstructorDep(dependency);
    }

    @Bean
    public ProductWithSetterDep productWithSetterDep(){
        usedProductWithSetterDep=true;
        return new ProductWithSetterDep();
    }


}
