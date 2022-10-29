package liga.medical.medicalperson.core.dao.api;

import liga.medical.medicalperson.core.model.entity.Contact;

import java.util.List;

public interface ContactRepository {
    Contact getContactById(int contactId);

    List<Contact> getAllContact();

    int postContact(Contact contact);

    void deleteContact(int id);
}
