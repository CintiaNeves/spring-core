package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.domain.User;
import br.com.pdi.springcore.security.EncryptionService;
import br.com.pdi.springcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class UserServiceJpaDaoImpl implements UserService {

    private EntityManagerFactory entityManagerFactory;
    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<User> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getById(Long id) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       return entityManager.find(User.class, id);
    }


    @Override
    public User saveOrUpdate(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        if(user.getPassword() != null){
            user.setEncryptedPassword(
                    encryptionService.encryptString(user.getPassword()));
        }

        User savedUser = entityManager.merge(user);
        entityManager.getTransaction().commit();

        return savedUser;
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class, id));
        entityManager.getTransaction().commit();
    }
}
