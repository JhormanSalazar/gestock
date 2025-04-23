package com.gestock.gestock.services;

import com.gestock.gestock.persistence.entity.ProductEntity;
import com.gestock.gestock.persistence.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findAll(){
        return this.productRepository.findAll();
    }

    @Transactional
    public ProductEntity save(ProductEntity product){
        return this.productRepository.save(product);
    }

    @Transactional
    public void delete(ProductEntity product){
        this.productRepository.delete(product);
    }

    public List<ProductEntity> getByCategoryId(Integer categoryId){
        return this.productRepository.findByCategory_CategoryId(categoryId);
    }

    public List<ProductEntity> getByName(String name){
        return this.productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<ProductEntity> getByPrice(Integer maxPrice){
        return this.productRepository.findByPriceLessThanEqual(maxPrice);
    }

}
