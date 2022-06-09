package beans.injections.types;

import org.springframework.stereotype.Component;

@Component
public class FieldDependency {
    public String execute(){
        return this+" executed";
    }

}
