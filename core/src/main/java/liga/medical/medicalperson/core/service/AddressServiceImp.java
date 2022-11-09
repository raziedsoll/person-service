package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.dao.api.AddressRepository;
import liga.medical.medicalperson.core.model.entity.Address;
import liga.medical.medicalperson.core.service.api.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }
}
