package com.springboot.jpa.data.dao.impl;

import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product){
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Optional<Product> selectProduct(Long number){
        Optional<Product> selectedProduct = productRepository.findById(number);
        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number , String name) throws  Exception{
        Optional<Product> selectedProduct = productRepository.findById(number); // 데이터를 가져옴

        Product updatedProduct;
        if(selectedProduct.isPresent()){ //Optional 객체가 값을 가지고 있다면 true, 값이 없다면 false 리턴
            Product product = selectedProduct.get(); //한 줄 가져와서 Product 객체에 담는다.
            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());
            updatedProduct = productRepository.save(product);
        }else{
          throw new Exception();
        }
        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws  Exception{
        Optional<Product> selectedProduct = productRepository.findById(number);
        if(selectedProduct.isPresent()){ //Optional 객체가 값을 가지고 있다면 true, 값이 없다면 false 리턴
            Product product = selectedProduct.get(); //한 줄 가져와서 Product 객체에 담는다.

           productRepository.delete(product);
        }else{
            throw new Exception();
        }
    }
}
