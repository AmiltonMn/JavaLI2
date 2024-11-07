package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductData;
import com.example.demo.dto.Token;
import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;

@RestController
public class ProductCadController 
{
    @Autowired
    ProductRepository prodRepo;

    // Aqui foi pego da Header o nosso Token, ele já é verificado pelo Login. Este token foi pego do Login e adicionado depois no campo
    @PostMapping("/product")
    public ResponseEntity<String> cadNewProduct(@RequestAttribute("token") Token token, @RequestBody ProductData data) 
    {
        Integer position = token.getEmail().indexOf("@");

        if (!token.getEmail().substring(position).equals("@loja.com")) {
            return new ResponseEntity<>("Usuário sem permissão!", HttpStatus.FORBIDDEN);
        }

        Product newProduct = new Product();

        System.out.println(data);

        newProduct.setTitulo(data.title());
        newProduct.setValor(data.value());

        prodRepo.save(newProduct);

        return new ResponseEntity<>("Produto cadastrado com sucesso!", HttpStatus.OK);
    }
}
