package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.dao.api.IllnessRepository;
import liga.medical.medicalperson.core.model.entity.Illness;
import liga.medical.medicalperson.core.service.api.IllnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IllnessServiceImp implements IllnessService {

    private final IllnessRepository illnessRepository;

    @Override
    public Illness updateIllness(Illness illness) {
        return illnessRepository.save(illness);
    }
}
