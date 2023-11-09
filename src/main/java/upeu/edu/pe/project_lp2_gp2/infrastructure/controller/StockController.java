/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.infrastructure.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upeu.edu.pe.project_lp2_gp2.app.service.StockService;
import upeu.edu.pe.project_lp2_gp2.app.service.ValidateStock;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.StockEntity;

/**
 *
 * @author LAB-2
 */
@Controller
@RequestMapping("/admin/products/stock")
public class StockController {
    private final StockService stockService;
    private final ValidateStock validateStock;

    public StockController(StockService stockService, ValidateStock validateStock) {
        this.stockService = stockService;
        this.validateStock = validateStock;
    }
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model){
        ProductEntity product = new ProductEntity();
        product.setId(id);
        List<StockEntity> stocks = stockService.getStockByProductEntity(product);
        model.addAttribute("stocks", stocks);
        model.addAttribute("idproduct", id);
        return "admin/stock/show";
        
    }
    @GetMapping("create-unit-product/{id}")
    public String create(@PathVariable Integer id, Model model){
        model.addAttribute("idproduct", id);
      return"admin/stock/create";  
    } 
    
    @PostMapping("save-unit-product")
    public String save(StockEntity stock, @RequestParam("idproduct") Integer idproduct){
      stock.setDescripcion("entradas");
      ProductEntity product = new ProductEntity();
      product.setId(idproduct);
      stock.setProductEntity(product);
      stockService.saveStock(validateStock.calculateBalance(stock));
      return "redirect:/admin";
    }
}
