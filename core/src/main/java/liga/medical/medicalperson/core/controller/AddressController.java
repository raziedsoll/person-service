package liga.medical.medicalperson.core.controller;

import io.swagger.annotations.Api;
import liga.medical.medicalperson.core.model.entity.Address;
import liga.medical.medicalperson.core.service.api.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
@Api(value = "API для получения информации об адресах")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressServiceImp;

    @PutMapping("/update")
    @ResponseBody
    public Address updateAddress(@RequestBody Address address) {
        return addressServiceImp.updateAddress(address);
    }
}
