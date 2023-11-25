package com.example.flower.decorator;
import com.example.flower.store.Item;


public class PaperDecorator extends ItemDecorator {
    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Paper";
    }

    public double getPrice() {
        final int THIRTEEN = 13;
        return THIRTEEN + super.getPrice();
    }
    
}
