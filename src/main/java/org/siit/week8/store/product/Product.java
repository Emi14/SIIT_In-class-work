package org.siit.week8.store.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@ToString
@Getter
public class Product {

    private final UUID id;
    @Setter
    private String name;
    @Setter
    private double price;
    @Setter
    private int stock;
}
