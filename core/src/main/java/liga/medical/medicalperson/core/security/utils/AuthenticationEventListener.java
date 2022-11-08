package liga.medical.medicalperson.core.security.utils;

import liga.medical.medicalperson.core.security.service.api.AuthLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {

    @Autowired
    AuthLogService authLogServiceImpl;

    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent authenticationEvent) {
        if (authenticationEvent instanceof InteractiveAuthenticationSuccessEvent) {
            return;
        }
        Authentication authentication = authenticationEvent.getAuthentication();
        String auditMessage = "Попытка войти: " + authentication.getName() +
                "  Успех: " + authentication.isAuthenticated();
        log.info(auditMessage);
        authLogServiceImpl.setAuthLogAndSave(authentication);
    }
}
