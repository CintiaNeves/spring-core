package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.domain.Address;
import br.com.pdi.springcore.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {

    private Map<Long, Address> addressMap;

    public AddressServiceImpl(){
        loadAddress();
    }

    void loadAddress(){
        addressMap = new HashMap<>();

        Address address1 = new Address();
        address1.setId(1L);
        address1.setCityName("Mogi das Cruzes");
        address1.setStateName("São Paulo");
        address1.setZipCode("08750-710");

        addressMap.put(1L, address1);

        Address address2 = new Address();
        address2.setId(2L);
        address2.setCityName("Suzano");
        address2.setStateName("São Paulo");
        address2.setZipCode("08664-710");

        addressMap.put(2L, address2);

        Address address3 = new Address();
        address3.setId(3L);
        address3.setCityName("Poá");
        address3.setStateName("São Paulo");
        address3.setZipCode("08750-256");

        addressMap.put(3L, address3);

        Address address4 = new Address();
        address4.setId(4L);
        address4.setCityName("São Paulo");
        address4.setStateName("São Paulo");
        address4.setZipCode("02249-520");

        addressMap.put(4L, address4);
    }


    @Override
    public Address saveOrUpdateAddress(Address address) {
        return null;
    }

    @Override
    public Address getAddressById(Long id) {
        return addressMap.get(id);
    }
}
