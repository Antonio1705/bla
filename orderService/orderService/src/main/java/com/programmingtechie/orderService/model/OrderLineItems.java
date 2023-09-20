package com.programmingtechie.orderService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "order_line_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_line_items_id")
    private String id;

    @Column(name = "order_line_items_sku_code")
    private String skuCode;

    @Column(name = "order_line_items_price")
    private BigDecimal price;

    @Column(name = "order_line_items_quantity")
    private Integer quantity;
}
