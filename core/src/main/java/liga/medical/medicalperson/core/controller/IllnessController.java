package liga.medical.medicalperson.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.medicalperson.core.model.pojo.Illness;
import liga.medical.medicalperson.core.service.api.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/illness")
@Api(value = "API для получения информации об заболеваниях")
public class IllnessController {

    private final IllnessService illnessServiceImp;

    @Autowired
    public IllnessController(IllnessService illnessServiceImp) {
        this.illnessServiceImp = illnessServiceImp;
    }

    @GetMapping(path = "/all", produces = "application/json")
    @ApiOperation(value = "Получения всего списка заболеваний")
    public List<Illness> getAllIllness() {
        return illnessServiceImp.getAllIllness();
    }

    @PostMapping(path = "/new_illness")
    @ApiOperation(value = "Добавление нового заболевания")
    public int postIllness(@RequestBody Illness illness) {
        return illnessServiceImp.postIllness(illness);
    }
}
