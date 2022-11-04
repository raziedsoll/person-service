package liga.medical.medicalperson.core.security.service.api;

import org.springframework.security.core.Authentication;

public interface AuthLogService {
    void setAuthLogAndSave(Authentication authentication);
}
