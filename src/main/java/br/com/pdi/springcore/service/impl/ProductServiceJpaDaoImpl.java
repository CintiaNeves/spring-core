package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.domain.Product;
import br.com.pdi.springcore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl implements ProductService {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Product> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Long id) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       return entityManager.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product product) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Product savedProduct = entityManager.merge(product);
        entityManager.getTransaction().commit();

        return savedProduct;
    }

    @Override
    public void delete(Long id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Product.class, id));
        entityManager.getTransaction().commit();
    }
}
