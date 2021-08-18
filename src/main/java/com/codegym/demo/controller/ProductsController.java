package com.codegym.demo.controller;

import com.codegym.demo.model.Products;

import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    ResponseEntity<Iterable<Products>> findAll(){
        return  new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    ResponseEntity<Products> createProduct(@RequestBody Products products){
return  new ResponseEntity<>(productService.save(products),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    ResponseEntity<Products> findProductById(@PathVariable Long id){
        Optional<Products> productsOptional = productService.findById(id);
        if(!productsOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productsOptional.get(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    ResponseEntity<Products> updateProduct(@PathVariable Long id,@RequestBody Products products){
        Optional<Products> productsOptional= productService.findById(id);
        if(!productsOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        products.setId(productsOptional.get().getId());
        return new ResponseEntity<>(productService.save(products),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Products> deleteProducts(@PathVariable Long id){
        Optional<Products> productsOptional = productService.findById(id);
        if(!productsOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
