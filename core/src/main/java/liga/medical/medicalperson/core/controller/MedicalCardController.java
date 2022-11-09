package liga.medical.medicalperson.core.controller;

import io.swagger.annotations.Api;
import liga.medical.medicalperson.core.model.entity.MedicalCard;
import liga.medical.medicalperson.core.service.api.MedicalCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medical_card")
@Api(value = "API для получения медицинских карт")
@RequiredArgsConstructor
public class MedicalCardController {
    private final MedicalCardService medicalCardServiceImp;

    @PutMapping("/update")
    public MedicalCard updateAddress(@RequestBody MedicalCard medicalCard) {
        return medicalCardServiceImp.updateMedicalCard(medicalCard);
    }
}
