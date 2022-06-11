package com.ms.pedido.vallegrande.infraestructure;

import com.ms.pedido.vallegrande.domain.Stock;
import com.ms.pedido.vallegrande.domain.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Repository
public class StockImpl implements StockRepository {

    @Autowired
    private final MongoOperations mongoOperations;

    protected StockImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<Stock> findAll() {
        return this.mongoOperations.findAll(Stock.class);
    }

    @Override
    public Stock findItemById(String id) {
        return this.mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Stock.class);
    }

    @Override
    public Stock create(Stock stock) {
        System.out.println(stock.toString());
        return this.mongoOperations.save(stock);
    }

    @Override
    public void update(Stock stock) {
        this.mongoOperations.save(stock);
    }

    @Override
    public void delete(String id) {
        this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(id)), Stock.class);
    }
}
