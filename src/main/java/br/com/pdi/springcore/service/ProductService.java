package br.com.pdi.springcore.service;

import br.com.pdi.springcore.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Long id);

    Product saveOrUpdate(Product product);
}