package liga.medical.medicalperson.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "API для получения медицинских карт")
public class MedicalCardController {
    private final MedicalCardService medicalCardServiceImp;

    @Autowired
    public MedicalCardController(MedicalCardService medicalCardServiceImp) {
        this.medicalCardServiceImp = medicalCardServiceImp;
    }

    @GetMapping(path = "/all", produces = "application/json")
    @ApiOperation(value = "Получение всех медицинских карт")
    public List<MedicalCard> getAllMedicalCard() {
        return medicalCardServiceImp.getAllMedicalCard();
    }

    @GetMapping(path = "/{medicalCardId}", produces = "application/json")
    @ApiOperation(value = "Получение медицинской карты по id")
    public List<Illness> getMedicalCardById(@PathVariable("medicalCardId") @ApiParam(name = "medicalCardId",
            value = "MedicalCard id", example = "1") int medicalCardId) {
        return medicalCardServiceImp.getMedicalCardById(medicalCardId);
    }

    @PostMapping(path = "/new_medicalCard")
    @ApiOperation(value = "Добавление новой медицинской карты")
    public int postMedicalCard(@RequestBody MedicalCard medicalCard) {
        return medicalCardServiceImp.postMedicalCard(medicalCard);
    }
}
