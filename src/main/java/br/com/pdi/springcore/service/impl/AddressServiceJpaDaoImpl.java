package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.domain.Address;
import br.com.pdi.springcore.service.AddressService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class AddressServiceJpaDaoImpl implements AddressService {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Address> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Address", Address.class).getResultList();
    }

    @Override
    public Address getById(Long id) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       return entityManager.find(Address.class, id);
    }


    @Override
    public Address saveOrUpdate(Address address) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address savedAddress = entityManager.merge(address);
        entityManager.getTransaction().commit();

        return savedAddress;
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Address.class, id));
        entityManager.getTransaction().commit();
    }
}
