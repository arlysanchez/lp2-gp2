/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.app.repository;

import java.util.List;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.StockEntity;

/**
 *
 * @author LAB-2
 */
public interface StockRepository {
    StockEntity saveStock(StockEntity stockEntity);
    List<StockEntity> getStockByProductEntity(ProductEntity productEntity);  
}
