package com.dmux.jarnbjorn.service;

import com.dmux.jarnbjorn.model.Order;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pranayk on 17/05/18.
 */
public interface OrderService {

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    Order get(Long id);

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    Order get(String name);

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    List<Order> getAll();

    @Transactional
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    void create(Order order);

    @Transactional
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    Order update(Order order);

    @Transactional
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    void delete(Long id);

    @Transactional
    @PreAuthorize("hasAuthority('MERCHANT') or hasAuthority('ADMIN')")
    void delete(Order order);
}
