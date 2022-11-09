package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.dao.api.ContactRepository;
import liga.medical.medicalperson.core.model.entity.Contact;
import liga.medical.medicalperson.core.service.api.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImp implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

}
