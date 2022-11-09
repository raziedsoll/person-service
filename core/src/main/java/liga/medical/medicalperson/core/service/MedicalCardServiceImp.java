package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.dao.api.MedicalCardRepository;
import liga.medical.medicalperson.core.model.entity.MedicalCard;
import liga.medical.medicalperson.core.service.api.MedicalCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalCardServiceImp implements MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;

    @Override
    public MedicalCard updateMedicalCard(MedicalCard medicalCard) {
        return medicalCardRepository.save(medicalCard);
    }
}
