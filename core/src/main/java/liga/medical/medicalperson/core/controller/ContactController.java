package liga.medical.medicalperson.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "API для получения информации об контактах")
public class ContactController {

    private final ContactService contactServiceImp;

    @Autowired
    public ContactController(ContactService contactServiceImp) {
        this.contactServiceImp = contactServiceImp;
    }

    @GetMapping(path = "/all", produces = "application/json")
    @ApiOperation(value = "Получения всего списка контактов")
    public List<Contact> getAllContact() {
        return contactServiceImp.getAllContact();
    }

    @GetMapping(path = "/{contactId}", produces = "application/json")
    @ApiOperation(value = "Получения контакта по id")
    public Contact getContactById(@PathVariable("contactId") @ApiParam(name = "contactId",
            value = "Contact id", example = "1") int contactId) {
        Contact contact = contactServiceImp.getAddressesFromContact(contactId);
        return contact;
    }

    @PostMapping(path = "/new_contact")
    @ApiOperation(value = "Добавить новый контакт")
    public int postContact(@RequestBody Contact contact) {
        return contactServiceImp.postContact(contact);
    }

    @DeleteMapping(path = "/delete_contact/{contactId}")
    @ApiOperation(value = "Удаление контакта по id")
    public void deleteContact(@PathVariable("contactId") @ApiParam(name = "contactId",
            value = "Contact id", example = "1") int contactId) {
        contactServiceImp.deleteContact(contactId);
    }
}
