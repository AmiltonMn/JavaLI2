package com.desktopapp.implementations;

import com.desktopapp.Context;
import com.desktopapp.model.Produto;
import com.desktopapp.repositories.ProductRepository;

public class DatabaseProductRepository implements ProductRepository {
    @Override
    public void update(Produto product) {
        Context ctx = new Context();
        ctx.begin();
        ctx.update(product);
        ctx.commit();
    }

    @Override
    public void delete(Produto product) {
        Context ctx = new Context();
        ctx.begin();
        ctx.delete(product);
        ctx.commit();
    }
}