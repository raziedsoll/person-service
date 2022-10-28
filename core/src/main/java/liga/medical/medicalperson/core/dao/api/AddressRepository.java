package liga.medical.medicalperson.core.dao.api;

import liga.medical.medicalperson.core.model.entity.Address;

import java.util.List;

public interface AddressRepository {
    List<Address> getAllAddresses();

    int postAddress(Address address);

    void deleteAddress(int id);
}
