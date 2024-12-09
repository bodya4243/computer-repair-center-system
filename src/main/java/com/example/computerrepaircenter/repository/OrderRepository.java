package com.example.computerrepaircenter.repository;

import com.example.computerrepaircenter.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.user WHERE o.user.id = :userId")
    List<Order> findByUserId(@Param("userId") Long userId);
}
