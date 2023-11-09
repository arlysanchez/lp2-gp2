/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.app.service;

import java.util.List;
import upeu.edu.pe.project_lp2_gp2.app.repository.OrderProductRepository;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.OrderProductEntity;

/**
 *
 * @author LAB-2
 */
public class OrderProductService {
    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }
    
     public OrderProductEntity create (OrderProductEntity orderProduct){
         return orderProductRepository.create(orderProduct);
     }
    public Iterable<OrderProductEntity> getOrderProducts(){
        return orderProductRepository.getOrderProducts();
        
    }
    public List<OrderProductEntity> getOrdersProductByOrder(OrderEntity orderEntity){
        return orderProductRepository.getOrdersProductByOrder(orderEntity);
    } 
}
