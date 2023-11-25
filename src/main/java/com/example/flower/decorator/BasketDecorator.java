package com.example.flower.decorator;

import com.example.flower.store.Item;


public class BasketDecorator extends ItemDecorator {
    public BasketDecorator(Item item){
        super(item);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Basket";
    }

    public double getPrice() {
        final int HUNDRED = 4;
        return HUNDRED + super.getPrice();
    }
    
}