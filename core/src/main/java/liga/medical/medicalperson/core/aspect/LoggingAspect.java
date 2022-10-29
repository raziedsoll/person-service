package liga.medical.medicalperson.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @AfterReturning("execution(* liga.medical.medicalperson.core.controller.*Controller.*(..))")
    public void beforeGetAllAdvice(JoinPoint joinPoint) {
        System.out.println("The " + joinPoint.getSignature().getName() + " worked fine.");
    }
}
