package liga.medical.medicalperson.core.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {
    @Pointcut("execution(* liga.medical.medicalperson.core.controller.*Controller.*(..))")
    public void allRestMethods() { }

    @Pointcut("execution(* liga.medical.medicalperson.core.security.controller.*Controller.*(..)))")
    public void securityMethods() { }
}
