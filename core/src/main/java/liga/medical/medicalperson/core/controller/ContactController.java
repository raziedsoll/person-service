package liga.medical.medicalperson.core.controller;

import io.swagger.annotations.Api;
import liga.medical.medicalperson.core.model.entity.Contact;
import liga.medical.medicalperson.core.service.api.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
@Api(value = "API для получения информации об контактах")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactServiceImp;

    @PutMapping("/update")
    public Contact updateAddress(@RequestBody Contact contact) {
        return contactServiceImp.updateContact(contact);
    }

}
