package beans.injections.types;

import org.springframework.stereotype.Component;

@Component
public class ConstructorDependency {
    public String execute(){
        return this+ " executed";
    }
}
