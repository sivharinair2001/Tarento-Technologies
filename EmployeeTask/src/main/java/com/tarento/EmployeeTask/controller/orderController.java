package com.tarento.EmployeeTask.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tarento.EmployeeTask.service.orderService;
import com.tarento.EmployeeTask.entity.order;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/orders")
public class orderController {
    private final orderService orderService;

    @Autowired
    public orderController(orderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<order> getOrderById(@PathVariable Long id) {
        return  orderService.getOrderById(id);
    }

    @PostMapping
    public order createOrder(@RequestBody order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public order updateOrder(@PathVariable Long id, @RequestBody order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
