package com.tarento.EmployeeTask.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tarento.EmployeeTask.repository.orderRepository;
import com.tarento.EmployeeTask.entity.order;
import java.util.List;
import java.util.Optional;

@Service
public class orderService {
    private final orderRepository orderRepository;

    @Autowired
    public orderService(orderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public order createOrder(order order) {
        return orderRepository.save(order);
    }

    public order updateOrder(Long id, order updatedOrder) {
        order existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setStatus(updatedOrder.getStatus());
        existingOrder.setOrderDate(updatedOrder.getOrderDate());
        return orderRepository.save(existingOrder);
    }


    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
