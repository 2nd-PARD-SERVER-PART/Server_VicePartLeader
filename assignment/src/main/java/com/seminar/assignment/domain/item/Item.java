package com.seminar.assignment.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
    public Item( String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
