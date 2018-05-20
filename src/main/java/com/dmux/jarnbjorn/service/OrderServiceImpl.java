package com.dmux.jarnbjorn.service;

import com.dmux.jarnbjorn.model.Order;
import com.dmux.jarnbjorn.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    public Order get(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    public Order get(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    public void delete(Long id) {
        orderRepository.delete(id);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
