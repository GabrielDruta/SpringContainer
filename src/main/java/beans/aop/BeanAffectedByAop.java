package beans.aop;

import org.springframework.stereotype.Component;

@Component
public class BeanAffectedByAop {
    public String complexBusiness(){
        return this+ " executed";
    }

    public String complexBusinessThatThrowsException(){
        throw new RuntimeException("fail");
    }
}

