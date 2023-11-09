/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.infrastructure.adapter;

import java.util.List;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.project_lp2_gp2.app.repository.OrderProductRepository;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.OrderProductEntity;

/**
 *
 * @author LAB-2
 */
@Repository
public class OrderProductRepositoryImpl implements OrderProductRepository {
    private final OrderProductCrudRepository orderCrudRepository;

    public OrderProductRepositoryImpl(OrderProductCrudRepository orderCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
    }
    

    @Override
    public OrderProductEntity create(OrderProductEntity orderProduct) {
        return orderCrudRepository.save(orderProduct);
    }

    @Override
    public Iterable<OrderProductEntity> getOrderProducts() {
        return orderCrudRepository.findAll();
    }

    @Override
    public List<OrderProductEntity> getOrdersProductByOrder(OrderEntity orderEntity) {
        return orderCrudRepository.findByOrderEntity(orderEntity);
    }
}
