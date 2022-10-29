package liga.medical.medicalperson.core.controller;

import liga.medical.medicalperson.core.model.pojo.PersonData;
import liga.medical.medicalperson.core.service.api.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person_data")
public class PersonDataController {
    private final PersonDataService personDataService;

    @Autowired
    public PersonDataController(PersonDataService personDataService) {
        this.personDataService = personDataService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<PersonData> getAllPersonData() {
        return personDataService.getAllPersonData();
    }

    @GetMapping(path = "/{personDataId}", produces = "application/json")
    public PersonData getPersonDataById(@PathVariable("personDataId") int personDataId) {
        return personDataService.getPersonDataById(personDataId);
    }

    @PostMapping(path = "/new_PersonData")
    public int postPersonData(@RequestBody PersonData personData) {
        return personDataService.postPersonData(personData);
    }
}
