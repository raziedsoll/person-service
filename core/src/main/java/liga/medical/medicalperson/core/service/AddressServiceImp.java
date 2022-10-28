package liga.medical.medicalperson.core.service;

import liga.medical.medicalperson.core.dao.api.AddressRepository;
import liga.medical.medicalperson.core.model.entity.Address;
import liga.medical.medicalperson.core.service.api.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepositoryImp;

    @Autowired
    AddressServiceImp(AddressRepository addressRepositoryImp) {
        this.addressRepositoryImp = addressRepositoryImp;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepositoryImp.getAllAddresses();
    }

    @Override
    public int postAddress(Address address) {
        return addressRepositoryImp.postAddress(address);
    }

    @Override
    public void deleteAddress(int id) {
        addressRepositoryImp.deleteAddress(id);
    }
}
