package com.ms.pedido.vallegrande.application;

import com.ms.pedido.vallegrande.domain.Stock;
import com.ms.pedido.vallegrande.domain.StockRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockService {

    StockRepository stockRepository;

    public StockService(StockRepository stockRepository){ this.stockRepository = stockRepository;
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public Stock findItemById(String id) {
        return stockRepository.findItemById(id);
    }

    public Stock create(Stock stock) {
        System.out.println(stock.toString());
        return stockRepository.create(stock);
    }

    public ResponseEntity<?> update(Stock stock) {
        stockRepository.update(stock);
        return new ResponseEntity<String>("Stock update.", HttpStatus.CREATED);
    }

    public ResponseEntity<?> delete(String id) {
        stockRepository.delete(id);
        return new ResponseEntity<String>("Stock delete.", HttpStatus.CREATED);
    }
}
