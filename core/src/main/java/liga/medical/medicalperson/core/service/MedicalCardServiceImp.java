package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.mapper.MedicalCardMapper;
import liga.medical.medicalperson.core.model.pojo.Illness;
import liga.medical.medicalperson.core.model.pojo.MedicalCard;
import liga.medical.medicalperson.core.service.api.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCardServiceImp implements MedicalCardService {

    private final MedicalCardMapper medicalCardMapper;

    @Autowired
    MedicalCardServiceImp(MedicalCardMapper medicalCardMapper) {
        this.medicalCardMapper = medicalCardMapper;
    }

    @Override
    public List<MedicalCard> getAllMedicalCard() {
        return medicalCardMapper.getAllMedicalCard();
    }

    @Override
    public List<Illness> getMedicalCardById(int medicalCardId) {
        return medicalCardMapper.getMedicalCardById(medicalCardId);
    }

    @Override
    public int postMedicalCard(MedicalCard medicalCard) {
        return medicalCardMapper.postMedicalCard(medicalCard);
    }
}
