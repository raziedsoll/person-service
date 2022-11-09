package liga.medical.medicalperson.core.controller;

import io.swagger.annotations.Api;
import liga.medical.medicalperson.core.model.entity.Illness;
import liga.medical.medicalperson.core.service.api.IllnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/illness")
@Api(value = "API для получения информации об заболеваниях")
@RequiredArgsConstructor
public class IllnessController {

    private final IllnessService illnessServiceImp;

    @PutMapping("/update")
    public Illness updateAddress(@RequestBody Illness illness) {
        return illnessServiceImp.updateIllness(illness);
    }
}
