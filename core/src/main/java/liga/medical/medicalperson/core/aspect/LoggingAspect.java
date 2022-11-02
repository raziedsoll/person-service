package liga.medical.medicalperson.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @AfterReturning("execution(* liga.medical.medicalperson.core.controller.*Controller.*(..))")
    public void beforeGetAllAdvice(JoinPoint joinPoint) {
        System.out.println("The " + joinPoint.getSignature().getName() + " worked fine.");
    }

    @Before("execution(* liga.medical.medicalperson.core.security.controller.*.*(..))")
    public void beforeAllSecurityRepositoryMethodAdvice(JoinPoint joinPoint)  {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("\n*********************************");
        System.out.println("Начало работы метода: " + methodName);
    }

    @AfterReturning("execution(* liga.medical.medicalperson.core.security.controller.*.*(..))")
    public void afterReturningAllSecurityRepositoryMethodAdvice(JoinPoint joinPoint)  {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Метод был успешно отработан: " + methodName);
    }
}
