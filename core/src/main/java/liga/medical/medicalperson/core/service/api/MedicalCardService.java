package liga.medical.medicalperson.core.service.api;

import liga.medical.medicalperson.core.model.pojo.Illness;
import liga.medical.medicalperson.core.model.pojo.MedicalCard;

import java.util.List;

public interface MedicalCardService {
    List<MedicalCard> getAllMedicalCard();

    List<Illness> getMedicalCardById(int medicalCardId);

    int postMedicalCard(MedicalCard medicalCard);
}
