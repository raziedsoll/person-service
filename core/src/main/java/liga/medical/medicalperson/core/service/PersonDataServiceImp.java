package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.mapper.PersonDataMapper;
import liga.medical.medicalperson.core.model.pojo.PersonData;
import liga.medical.medicalperson.core.service.api.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDataServiceImp implements PersonDataService {

    private final PersonDataMapper personDataMapper;

    @Autowired
    PersonDataServiceImp(PersonDataMapper personDataMapper) {
        this.personDataMapper = personDataMapper;
    }

    @Override
    public int postPersonData(PersonData personData) {
        return personDataMapper.postPersonData(personData);
    }

    @Override
    public PersonData getPersonDataById(int id) {
        return personDataMapper.getPersonDataById(id);
    }

    @Override
    public List<PersonData> getAllPersonData() {
        return personDataMapper.getAllPersonData();
    }

    @Override
    public void deletePersonData(int id) {
        personDataMapper.deletePersonData(id);
    }
}
