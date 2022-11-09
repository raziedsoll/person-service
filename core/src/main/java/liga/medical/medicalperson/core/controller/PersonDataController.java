package liga.medical.medicalperson.core.controller;

import io.swagger.annotations.Api;
import liga.medical.medicalperson.core.model.entity.PersonData;
import liga.medical.medicalperson.core.service.api.PersonDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person_data")
@Api(value = "API для получения персональных данных пациентов")
@RequiredArgsConstructor
public class PersonDataController {
    private final PersonDataService personDataService;

    @PutMapping("/update")
    public PersonData updatePersonData(@RequestBody PersonData personData) {
        return personDataService.saveOrUpdatePersonData(personData);
    }

    @PostMapping(value = "/save")
    public PersonData savePersonData(@RequestBody PersonData personData) {
        return personDataService.saveOrUpdatePersonData(personData);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public PersonData findById(@PathVariable("id") Long id) {
        return personDataService.findById(id);
    }
}
