package beans;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class ApplicationContextTest {
    protected static ClassPathXmlApplicationContext context;


    //spring - container general - lipeste componente, foarte usor si transparent
    //prin reflection, etc, pe baza a contract: annotations, constr etc
    //containerul merge adaugat la orice tip de applicatie java
    //custom context bazat pe xml, vedem noi cum se creaza xmlu
    @BeforeAll
    public static void before() {
        context = new ClassPathXmlApplicationContext("spring-beans.xml");
    }

    @AfterAll
    public static void after() {
        context.close();
    }

}
