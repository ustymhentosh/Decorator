package com.example.flower.decorator;

import com.example.flower.store.Item;

public class RibbonDecorator extends ItemDecorator {
    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Ribbon";
    }

    public double getPrice() {
        final int FORTY = 40;
        return FORTY + super.getPrice();
    } 
}