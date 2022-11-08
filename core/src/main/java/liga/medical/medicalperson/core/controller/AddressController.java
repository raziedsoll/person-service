package liga.medical.medicalperson.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "API для получения информации об адресах")
public class AddressController {

    private final AddressService addressServiceImp;

    @Autowired
    public AddressController(AddressService addressServiceImp) {
        this.addressServiceImp = addressServiceImp;
    }

    @GetMapping(path = "/all", produces = "application/json")
    @ApiOperation(value = "Получения всего списка адресов")
    public List<Address> getAllAddresses() {
        return addressServiceImp.getAllAddresses();
    }

    @PostMapping(path = "/new_address")
    @ApiOperation(value = "Добавление нового адреса")
    public int postAddress(@RequestBody Address address) {
        return addressServiceImp.postAddress(address);
    }

    @DeleteMapping(path = "/delete_address/{addressId}")
    @ApiOperation(value = "Удаление адреса")
    public void deleteAddress(@PathVariable("addressId") @ApiParam(name = "addressId",
            value = "Address id", example = "1") int addressId) {
        addressServiceImp.deleteAddress(addressId);
    }
}
