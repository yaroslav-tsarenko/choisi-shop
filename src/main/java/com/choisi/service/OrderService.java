package com.choisi.service;


import com.choisi.entity.OrderEntity;
import com.choisi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderEntity> loadAll() {
        return orderRepository.findAll();
    }

    public OrderEntity loadOne(Long id) {
        return orderRepository.findOrderById(id);
    }

    public OrderEntity save(OrderEntity order) {
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        OrderEntity orderEntity = loadOne(id);
        orderRepository.delete(orderEntity);
    }

    public OrderEntity update(OrderEntity newOrder) {
        OrderEntity oldOrder = loadOne(newOrder.getId());
        boolean exists = Objects.nonNull(oldOrder);
        if (exists) {
            BeanUtils.copyProperties(newOrder, oldOrder);
            return save(oldOrder);
        } else {
            return save(newOrder);
        }
    }

}
