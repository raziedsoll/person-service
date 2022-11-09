package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.dao.api.PersonDataRepository;
import liga.medical.medicalperson.core.dao.api.SignalsRepository;
import liga.medical.medicalperson.core.model.entity.PersonData;
import liga.medical.medicalperson.core.model.entity.Signals;
import liga.medical.medicalperson.core.service.api.SignalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignalsServiceImp implements SignalsService {

    private final SignalsRepository signalsRepository;
    private final PersonDataRepository personDataRepository;

    @Override
    public Signals save(Signals signals) {
        Optional<PersonData> optional = personDataRepository.findById(signals.getPersonDataId());
        if (optional.isPresent()) {
            return signalsRepository.save(signals);
        } else {
            return null;
        }
    }
}
