package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.dao.api.PersonDataRepository;
import liga.medical.medicalperson.core.model.entity.PersonData;
import liga.medical.medicalperson.core.service.api.PersonDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonDataServiceImp implements PersonDataService {

    private final PersonDataRepository personDataRepository;

    @Override
    public PersonData saveOrUpdatePersonData(PersonData personData) {
        return personDataRepository.save(personData);
    }

    @Override
    public PersonData findById(Long id) {
        return personDataRepository.findById(id).get();
    }
}
