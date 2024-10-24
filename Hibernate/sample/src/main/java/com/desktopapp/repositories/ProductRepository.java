package com.desktopapp.repositories;

import com.desktopapp.model.Produto;

public interface ProductRepository {
    void update(Produto product);
    void delete(Produto product);
}