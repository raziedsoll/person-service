package liga.medical.medicalperson.core.controller;

import liga.medical.medicalperson.core.model.entity.Contact;
import liga.medical.medicalperson.core.service.api.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactServiceImp;

    @Autowired
    public ContactController(ContactService contactServiceImp) {
        this.contactServiceImp = contactServiceImp;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<Contact> getAllContact() {
        return contactServiceImp.getAllContact();
    }

    @GetMapping(path = "/{contactId}", produces = "application/json")
    public Contact getContactById(@PathVariable("contactId") int contactId) {
        Contact contact = contactServiceImp.getAddressesFromContact(contactId);
        return contact;
    }

    @PostMapping(path = "/new_contact")
    public int postContact(@RequestBody Contact contact) {
        return contactServiceImp.postContact(contact);
    }

    @DeleteMapping(path = "/delete_contact/{contactId}")
    public void deleteContact(@PathVariable("contactId") int contactId) {
        contactServiceImp.deleteContact(contactId);
    }
}
