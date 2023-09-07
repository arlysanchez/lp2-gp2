/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.app.service;

import java.util.List;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.StockEntity;

/**
 *
 * @author LAB-2
 */
public class ValidateStock {
    private final StockService stockService;

    public ValidateStock(StockService stockService) {
        this.stockService = stockService;
    }
    
    private boolean existBalance(ProductEntity product){
        List<StockEntity> stockList = stockService.getStockByProductEntity(product);
        return stockList.isEmpty() ? false : true;
    }
    
    public StockEntity calculateBalance(StockEntity stock){
        
        if(stock.getEntradas() != 0){
            if(existBalance(stock.getProductEntity())){
                List<StockEntity> stockList = stockService.getStockByProductEntity(stock.getProductEntity());
                Integer balance = stockList.get(stockList.size()-1).getBalance();
                stock.setBalance(balance + stock.getEntradas());
            }else{
                stock.setBalance(stock.getEntradas());
            }
            
        }else{
            List<StockEntity> stockList = stockService.getStockByProductEntity(stock.getProductEntity());
                Integer balance = stockList.get(stockList.size()-1).getBalance();
                stock.setBalance(balance - stock.getSalidas());
                    
        }
        
        return stock;
    }
}
