package com.sangura.ruralconnect.orderService.services;

import com.sangura.ruralconnect.orderService.dto.OrderDto;
import com.sangura.ruralconnect.orderService.dto.OrderItemDto;
import com.sangura.ruralconnect.orderService.entities.Order;
import com.sangura.ruralconnect.orderService.entities.OrderItem;
import com.sangura.ruralconnect.orderService.mappers.OrderItemMapper;
import com.sangura.ruralconnect.orderService.mappers.OrderMapper;
import com.sangura.ruralconnect.orderService.repo.OrderItemRepo;
import com.sangura.ruralconnect.orderService.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final OrderRepo orderRepo;
    private final OrderItemRepo orderItemRepo;
    @Override
    @Transactional
    public Order createOrder(OrderDto orderDto) {
        return orderRepo.save(orderMapper.toEntity(orderDto));
    }

    @Override
    @Transactional
    public Order updateOrder(Long id, OrderDto orderDto) {
        Order existingOrder = orderRepo.findById(id).orElseThrow(()-> new RuntimeException("Please Enter Valid ID"));
        try{
            orderMapper.updateOrder(orderDto, existingOrder);
            return orderRepo.save(existingOrder);
        }catch(Exception e){
            throw new RuntimeException ("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteOrder(Long id) {
        orderRepo.findById(id).orElseThrow(()-> new RuntimeException("Please Enter Valid ID"));
        orderRepo.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllOrder() {
        try{
            return orderRepo.findAll();
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }

    }

    @Override
    @Transactional
    public OrderItem createOrderItem(OrderItemDto orderItemDto) {
        try{
            OrderItem newOrderItem = orderItemMapper.toEntity(orderItemDto);
            return orderItemRepo.save(newOrderItem);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderItem updateOrderItem(Long id, OrderItemDto orderItemDto) {
        try {
            OrderItem existingOrderItem = orderItemRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
            orderItemMapper.updateOrderItem(orderItemDto, existingOrderItem);
            return orderItemRepo.save(existingOrderItem);
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred " +e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteOrderItem(Long id) {
        try{
            orderItemRepo.findById(id).orElseThrow(() -> new RuntimeException("Please Enter Valid ID"));
            orderItemRepo.deleteById(id);
            return "Successfully Deleted";
        }catch(Exception e){
            throw new RuntimeException ("Unexpected Error Occurred "+e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderItem> getAllOrderItem() {
        try{
            return orderItemRepo.findAll();
        }catch (Exception e){
            throw new RuntimeException("Unexpected Error Occurred "+ e.getMessage());
        }

    }
}
