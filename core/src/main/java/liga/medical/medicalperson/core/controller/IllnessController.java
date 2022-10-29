package liga.medical.medicalperson.core.controller;

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
public class IllnessController {

    private final IllnessService illnessServiceImp;

    @Autowired
    public IllnessController(IllnessService illnessServiceImp) {
        this.illnessServiceImp = illnessServiceImp;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<Illness> getAllIllness() {
        return illnessServiceImp.getAllIllness();
    }

    @PostMapping(path = "/new_illness")
    public int postIllness(@RequestBody Illness illness) {
        return illnessServiceImp.postIllness(illness);
    }
}
