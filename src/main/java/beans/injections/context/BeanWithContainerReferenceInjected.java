package beans.injections.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//allow a bean to obtain a reference to the context
@Component
public class BeanWithContainerReferenceInjected {

    @Autowired
    ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }
}
