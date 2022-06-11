package com.ms.pedido.vallegrande.domain;

import java.util.List;

public interface StockRepository {
    List<Stock> findAll();
    Stock findItemById(String id);

    Stock create(Stock stock);

    void update(Stock stock);

    void delete(String id);
}
