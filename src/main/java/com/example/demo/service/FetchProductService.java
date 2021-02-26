package com.example.demo.service;

import com.example.demo.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchProductService {

    ProductsRepository pRep;

    public FetchProductService(ProductsRepository pRep) {
        this.pRep = pRep;
    }

    public List<String> getFetchProducts(String name) {
        return pRep.getProductName(name);
    }
}