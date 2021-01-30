package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.domain.Address;
import br.com.pdi.springcore.domain.DomainObject;
import br.com.pdi.springcore.service.AbstractMapService;
import br.com.pdi.springcore.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AddressServiceImpl extends AbstractMapService implements AddressService {

    public AddressServiceImpl(){
        loadDomainObjects();
    }

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Address getById(Long id) {
        return (Address) super.getById(id);
    }

    @Override
    public Address saveOrUpdate(Address domainObject) {
        return (Address) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    protected void loadDomainObjects(){
        domainMap = new HashMap<>();

        Address address1 = new Address();
        address1.setId(1L);
        address1.setCityName("Mogi das Cruzes");
        address1.setStateName("São Paulo");
        address1.setZipCode("08750-710");

        domainMap.put(1L, address1);

        Address address2 = new Address();
        address2.setId(2L);
        address2.setCityName("Suzano");
        address2.setStateName("São Paulo");
        address2.setZipCode("08664-710");

        domainMap.put(2L, address2);

        Address address3 = new Address();
        address3.setId(3L);
        address3.setCityName("Poá");
        address3.setStateName("São Paulo");
        address3.setZipCode("08750-256");

        domainMap.put(3L, address3);

        Address address4 = new Address();
        address4.setId(4L);
        address4.setCityName("São Paulo");
        address4.setStateName("São Paulo");
        address4.setZipCode("02249-520");

        domainMap.put(4L, address4);
    }
}
