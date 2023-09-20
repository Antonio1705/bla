package com.programmingtechie.orderService.service;

import com.programmingtechie.orderService.dto.OrderLineItemsDto;
import com.programmingtechie.orderService.dto.OrderRequest;
import com.programmingtechie.orderService.model.Order;
import com.programmingtechie.orderService.model.OrderLineItems;
import com.programmingtechie.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setId(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItems(orderLineItems);

        orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(UUID.randomUUID().toString());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;
    }

}
