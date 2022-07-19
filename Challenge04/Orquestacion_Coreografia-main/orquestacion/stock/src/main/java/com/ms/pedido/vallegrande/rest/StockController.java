package com.ms.pedido.vallegrande.rest;

import com.ms.pedido.vallegrande.application.StockService;
import com.ms.pedido.vallegrande.domain.Stock;
import com.ms.pedido.vallegrande.domain.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    StockRepository stockRepository;
    @Autowired
    StockService stockService = new StockService(stockRepository);

    @GetMapping("/listStock")
    public List<Stock> findAll(){
        return stockService.findAll();
    }

    @GetMapping("/{id}")
    public Stock findItemById(@PathVariable String id){
        return stockService.findItemById(id);
    }

    @PostMapping
    public Stock saveStudent(@RequestBody Stock stock){
        return stockService.create(stock);
    }

    @PutMapping
    public ResponseEntity<?>  update(@RequestBody Stock stock) {
        return stockService.update(stock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return stockService.delete(id);
    }
}
