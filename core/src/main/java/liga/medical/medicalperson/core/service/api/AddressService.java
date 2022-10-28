package liga.medical.medicalperson.core.service.api;

import liga.medical.medicalperson.core.model.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    int postAddress(Address address);

    void deleteAddress(int id);
}
