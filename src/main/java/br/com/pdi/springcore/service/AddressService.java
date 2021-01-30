package br.com.pdi.springcore.service;

import br.com.pdi.springcore.domain.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    Address saveOrUpdateAddress(Address address);

    Address getAddressById(Long id);
}
