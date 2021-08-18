package com.codegym.demo.service;

import com.codegym.demo.model.Products;

public interface IProductService extends IGeneraService<Products> {
    Iterable<Products> findProductsByNameContaining(String Name);
}
