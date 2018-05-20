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
    @PreAuthorize("hasAuthority('COMPANY_READ') and hasAuthority('DEPARTMENT_READ')")
    Order get(Long id);

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('COMPANY_READ') and hasAuthority('DEPARTMENT_READ')")
    Order get(String name);

    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('COMPANY_READ')")
    List<Order> getAll();

    @Transactional
    @PreAuthorize("hasAuthority('COMPANY_CREATE')")
    void create(Order company);

    @Transactional
    @PreAuthorize("hasAuthority('COMPANY_UPDATE')")
    Order update(Order company);

    @Transactional
    @PreAuthorize("hasAuthority('COMPANY_DELETE')")
    void delete(Long id);

    @Transactional
    @PreAuthorize("hasAuthority('COMPANY_DELETE')")
    void delete(Order company);
}
