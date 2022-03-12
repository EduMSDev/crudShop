package com.sprinter.demo.repository;

import com.sprinter.demo.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepository extends GenericRepository<Order> {
}
