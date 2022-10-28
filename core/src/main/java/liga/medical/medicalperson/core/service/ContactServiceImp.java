package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.dao.api.ContactRepository;
import liga.medical.medicalperson.core.model.entity.Contact;
import liga.medical.medicalperson.core.service.api.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImp implements ContactService {

    private final ContactRepository contactRepositoryImp;

    @Autowired
    ContactServiceImp(ContactRepository contactRepositoryImp) {
        this.contactRepositoryImp = contactRepositoryImp;
    }

    @Override
    public Contact getAddressesFromContact(int contactId) {
        return contactRepositoryImp.getContactById(contactId);
    }

    @Override
    public int postContact(Contact contact) {
        return contactRepositoryImp.postContact(contact);
    }

    @Override
    public void deleteContact(int id) {
        contactRepositoryImp.deleteContact(id);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepositoryImp.getAllContact();
    }
}
