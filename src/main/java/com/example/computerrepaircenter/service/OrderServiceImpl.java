package com.example.computerrepaircenter.service;

import com.example.computerrepaircenter.dto.ChangedOrderRequestDto;
import com.example.computerrepaircenter.dto.OrderRequestDto;
import com.example.computerrepaircenter.dto.OrderResponseDto;
import com.example.computerrepaircenter.mapper.OrderMapper;
import com.example.computerrepaircenter.model.Component;
import com.example.computerrepaircenter.model.Order;
import com.example.computerrepaircenter.model.OrderStatus;
import com.example.computerrepaircenter.model.User;
import com.example.computerrepaircenter.repository.ComponentRepository;
import com.example.computerrepaircenter.repository.OrderRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ComponentRepository componentRepository;

    @Override
    public OrderResponseDto save(OrderRequestDto orderRequestDto, User user) {
        Order order = orderMapper.toModel(orderRequestDto);
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);
        order.setTotal(BigDecimal.ZERO);
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public List<OrderResponseDto> getAll(User user) {
        List<Order> orders = orderRepository.findByUserId(user.getId());

        return orders.stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public Page<OrderResponseDto> getAllForAdmin(Pageable pageable) {
        return orderRepository.findAll(pageable).map(orderMapper::toDto);
    }

    @Override
    public OrderResponseDto getById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(()
                -> new RuntimeException("cannot find order by id: " + id));

        return orderMapper.toDto(order);
    }

    @Override
    public OrderResponseDto updateById(Long id, ChangedOrderRequestDto orderRequestDto, User user) {
        Optional<Order> order = orderRepository.findById(id);
        Order orderToSave = buildOrder(order, orderRequestDto, user);
        componentRepository.saveAll(orderRequestDto.getComponents());

        return orderMapper.toDto(orderRepository.save(orderToSave));
    }

    @Override
    public void deleteOrderById(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        }
    }

    private Order buildOrder(Optional<Order> order,
                             ChangedOrderRequestDto orderRequestDto, User user) {
        if (order.isEmpty()) {
            throw new RuntimeException("cannot find order");
        }

        Order currentOrder = order.get();
        currentOrder.setComponents(orderRequestDto.getComponents());
        currentOrder.setDescription(orderRequestDto.getDescription());
        currentOrder.setShippingAddress(orderRequestDto.getShippingAddress());
        BigDecimal total = orderRequestDto.getComponents().stream()
                .map(Component::getPrice)
                .reduce(orderRequestDto.getTotal(), BigDecimal::add);

        currentOrder.setTotal(total);
        currentOrder.setStatus(orderRequestDto.getStatus());
        currentOrder.setUser(user);

        return currentOrder;
    }
}
