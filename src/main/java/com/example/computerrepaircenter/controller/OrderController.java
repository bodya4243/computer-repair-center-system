package com.example.computerrepaircenter.controller;

import com.example.computerrepaircenter.dto.ChangedOrderRequestDto;
import com.example.computerrepaircenter.dto.OrderRequestDto;
import com.example.computerrepaircenter.dto.OrderResponseDto;
import com.example.computerrepaircenter.model.User;
import com.example.computerrepaircenter.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/orders")
@RestController
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    List<OrderResponseDto> getAllOrders(@AuthenticationPrincipal User user) {
        return orderService.getAll(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/allOrders")
    Page<OrderResponseDto> getAllOrdersForAdmin(Pageable pageable) {

        return orderService.getAllForAdmin(pageable);
    }

    @GetMapping("/{id}")
    OrderResponseDto getOrderById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PostMapping
    OrderResponseDto save(@RequestBody OrderRequestDto orderRequestDto,
                          @AuthenticationPrincipal User user) {
        return orderService.save(orderRequestDto, user);
    }

    @PutMapping("/{id}")
    OrderResponseDto updateById(@PathVariable Long id,
                                @RequestBody ChangedOrderRequestDto orderRequestDto,
                                @AuthenticationPrincipal User user) {
        return orderService.updateById(id, orderRequestDto, user);
    }

    @DeleteMapping("/{id}")
    void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }

}
