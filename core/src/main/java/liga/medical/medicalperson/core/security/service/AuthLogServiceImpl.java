package liga.medical.medicalperson.core.security.service;

import liga.medical.medicalperson.core.security.entity.AuthLog;
import liga.medical.medicalperson.core.security.repository.AuthLogRepository;
import liga.medical.medicalperson.core.security.service.api.AuthLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class AuthLogServiceImpl implements AuthLogService {

    private final AuthLogRepository authLogRepository;

    @Override
    public void setAuthLogAndSave(Authentication authentication) {
        String username = authentication.getName();
        boolean successfully = authentication.isAuthenticated();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        AuthLog currentAuthLog = new AuthLog(username, successfully, timestamp);
        authLogRepository.save(currentAuthLog);
    }
}
