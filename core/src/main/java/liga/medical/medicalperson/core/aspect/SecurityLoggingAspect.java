package liga.medical.medicalperson.core.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class SecurityLoggingAspect {
    @Before("PointCuts.securityMethods()")
    public void beforeAllSecurityMethodAdvice(JoinPoint joinPoint) throws JsonProcessingException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] array = joinPoint.getArgs();
        log.info("| Пользователь: " + userName + " |" + " Вызван метод: " + className + ": " +
                methodName + "()" + " с аргументами: " + Arrays.deepToString(array));
    }

    @AfterReturning("PointCuts.securityMethods()")
    public void afterReturningAllSecurityMethodAdvice(JoinPoint joinPoint) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] array = joinPoint.getArgs();
        log.info("| Пользователь: " + userName + " |" + " Отработал метод, " + className + ": " +
                methodName + "()" + " с аргументами: " + Arrays.deepToString(array));
    }

    @AfterThrowing(value = "PointCuts.securityMethods()", throwing = "exception")
    public void afterTrowingAllRestMethodAdvice(JoinPoint joinPoint, Throwable exception) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] array = joinPoint.getArgs();
        log.info("| Пользователь: " + userName + " |" + " Метод, " + className + ": " +
                methodName + "()" + " с аргументами: " + Arrays.deepToString(array) +
                " завершил работу с ошибкой: " + exception.getMessage());
    }
}
