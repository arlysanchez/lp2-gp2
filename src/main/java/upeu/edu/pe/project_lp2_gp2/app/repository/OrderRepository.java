/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.app.repository;

import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.project_lp2_gp2.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */
public interface OrderRepository {
    public OrderEntity createOrder(OrderEntity order);
    public Iterable<OrderEntity> getOrders();
    public Iterable<OrderEntity> getOrdersByUser(UserEntity user);
}
