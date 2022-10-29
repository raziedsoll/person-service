package liga.medical.medicalperson.core.controller;

import liga.medical.medicalperson.core.model.pojo.Illness;
import liga.medical.medicalperson.core.model.pojo.MedicalCard;
import liga.medical.medicalperson.core.service.api.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/medical_card")
public class MedicalCardController {
    private final MedicalCardService medicalCardServiceImp;

    @Autowired
    public MedicalCardController(MedicalCardService medicalCardServiceImp) {
        this.medicalCardServiceImp = medicalCardServiceImp;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<MedicalCard> getAllMedicalCard() {
        return medicalCardServiceImp.getAllMedicalCard();
    }

    @GetMapping(path = "/{medicalCardId}", produces = "application/json")
    public List<Illness> getMedicalCardById(@PathVariable("medicalCardId") int medicalCardId) {
        return medicalCardServiceImp.getMedicalCardById(medicalCardId);
    }

    @PostMapping(path = "/new_medicalCard")
    public int postMedicalCard(@RequestBody MedicalCard medicalCard) {
        return medicalCardServiceImp.postMedicalCard(medicalCard);
    }
}
