package com.codegym.demo.service;

import com.codegym.demo.model.Products;
import com.codegym.demo.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductsRepository productsRepository;
    @Override
    public Iterable<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public Optional<Products> findById(Long id) {
        return productsRepository.findById(id);
    }

    @Override
    public Products save(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public void remote(Long id) {
        productsRepository.deleteById(id);
    }


    @Override
    public Iterable<Products> findProductsByNameContaining(String Name) {
        return productsRepository.findProductsByNameContaining(Name);
    }
}
