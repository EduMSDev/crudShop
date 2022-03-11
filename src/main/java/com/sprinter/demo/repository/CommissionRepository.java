package com.sprinter.demo.repository;

import com.sprinter.demo.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepository extends GenericRepository<Order> {
}
