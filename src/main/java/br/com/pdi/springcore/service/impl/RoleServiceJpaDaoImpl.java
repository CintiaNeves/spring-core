package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.domain.User;
import br.com.pdi.springcore.domain.security.Role;
import br.com.pdi.springcore.security.EncryptionService;
import br.com.pdi.springcore.service.RoleService;
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
public class RoleServiceJpaDaoImpl implements RoleService {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Role> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getById(Long id) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       return entityManager.find(Role.class, id);
    }


    @Override
    public Role saveOrUpdate(Role role) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Role savedRole = entityManager.merge(role);
        entityManager.getTransaction().commit();

        return savedRole;
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Role.class, id));
        entityManager.getTransaction().commit();
    }
}
