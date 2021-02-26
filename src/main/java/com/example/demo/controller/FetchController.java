package com.example.demo.controller;

import com.example.demo.service.FetchProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FetchController {

    FetchProductService service;

    public FetchController(FetchProductService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    @ResponseBody
    public List<String> getFetchProducts(@RequestParam("name") String name) {
        return service.getFetchProducts(name);
    }
}