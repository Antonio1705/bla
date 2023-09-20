package com.programmingtechie.orderService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "ordernumber")
    private String orderNumber;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_line_items_id")
    private List<OrderLineItems> orderLineItems = new ArrayList<>();

}
