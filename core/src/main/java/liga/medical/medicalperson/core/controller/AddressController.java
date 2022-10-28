package liga.medical.medicalperson.core.controller;

import liga.medical.medicalperson.core.model.entity.Address;
import liga.medical.medicalperson.core.service.api.AddressService;
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
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressServiceImp;

    @Autowired
    public AddressController(AddressService  addressServiceImp) {
        this.addressServiceImp = addressServiceImp;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<Address> getAllAddresses() {
        return addressServiceImp.getAllAddresses();
    }

    @PostMapping(path = "/new_address")
    public int postAddress(@RequestBody Address address) {
        return addressServiceImp.postAddress(address);
    }

    @DeleteMapping(path = "/delete_address/{addressId}")
    public void deleteAddress(@PathVariable("addressId") int addressId) {
        addressServiceImp.deleteAddress(addressId);
    }
}
