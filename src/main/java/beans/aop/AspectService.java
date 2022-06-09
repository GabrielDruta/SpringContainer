package beans.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component  // an aspect i a container managed bean
@Aspect //annotated with a special marker
public class AspectService {

    @Before(value = "execution(* beans.aop.*.*(..))") // packege-classes-methods-parameters
    void aspectExecutedBeforeExecutingTargetedMethods() {
        System.out.println("AOP invoked BEFORE method call");
    }

    @After(value = "execution(* beans.aop.*.*(..))") // packege-classes-methods-parameters
    void aspectExecutedAfterExecutingTargetedMethods() {
        System.out.println("AOP invoked AFTER method call");
    }

//    @AfterReturning(pointcut = "execution(* beans.aop.*.*(..))"), returning = "valueReturnedByTargetMethod")
//    public void aspectExecutedAfterMethodsReturnValues(Object valueReturnedByTargetMethod) {
//        System.out.println("AOP invoked when Rerurn Object is " + valueReturnedByTargetMethod);
//    }

    @AfterReturning(pointcut = "execution(* beans.aop.*.*(..))", returning = "valueReturnedByTargetedMethod")
    public void aspectExecutedAfterExecutingTargetedMethodsReturnAValues(Object valueReturnedByTargetedMethod) {
        System.out.println("AOP invoked when RETURN object is " + valueReturnedByTargetedMethod);
    }

    @AfterThrowing(pointcut = "execution(* beans.aop.*.*(..))", throwing = "exceptionThrownByTargetedMethod")
    public void aspectExecutedWhenTargetedMethodsThrowExceptions(Exception exceptionThrownByTargetedMethod) {
        System.out.println("AOP invoked when EXCEPTION thrown is " + exceptionThrownByTargetedMethod);
    }

    @Around("execution(* beans.aop.beans.*.*(..))")
    public Object aroundAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AOP AROUND invoked BEFORE executing method call " + joinPoint);
        Object result = joinPoint.proceed();
        System.out.println("AOP AROUND invoked AFTER executing method call " + joinPoint);
        return result + " + data added by the aspect";
    }

}
////AOP nu afiseaza rezulattul niciunei metode, please help