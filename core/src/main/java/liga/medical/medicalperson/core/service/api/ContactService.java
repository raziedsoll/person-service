package liga.medical.medicalperson.core.service.api;

import liga.medical.medicalperson.core.model.entity.Contact;

import java.util.List;

public interface ContactService {
    Contact getAddressesFromContact(int contactId);

    List<Contact> getAllContact();

    int postContact(Contact contact);

    void deleteContact(int id);
}
