package liga.medical.medicalperson.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "API для получения персональных данных пациентов")
public class PersonDataController {
    private final PersonDataService personDataService;

    @Autowired
    public PersonDataController(PersonDataService personDataService) {
        this.personDataService = personDataService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    @ApiOperation(value = "Получение всех персональных данных")
    public List<PersonData> getAllPersonData() {
        return personDataService.getAllPersonData();
    }

    @GetMapping(path = "/{personDataId}", produces = "application/json")
    @ApiOperation(value = "Получение персональных данных по id")
    public PersonData getPersonDataById(@PathVariable("personDataId") @ApiParam(name = "personDataId",
            value = "PersonData id", example = "1") int personDataId) {
        return personDataService.getPersonDataById(personDataId);
    }

    @PostMapping(path = "/new_PersonData")
    @ApiOperation(value = "Добавление новых персональных данных")
    public int postPersonData(@RequestBody PersonData personData) {
        return personDataService.postPersonData(personData);
    }
}
