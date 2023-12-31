package com.example.demo;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import com.example.flower.decorator.BasketDecorator;
import com.example.flower.decorator.PaperDecorator;
import com.example.flower.decorator.RibbonDecorator;
import com.example.flower.store.FlowerBucket;
import com.example.flower.store.Item;

public class DecoratorTest {
    @Test
    public void testBasketDecorator() {
        Item itemToDecorate = new FlowerBucket();
        BasketDecorator basketDecorator = 
            new BasketDecorator(itemToDecorate);
        final double FOUR = 4.0;
        Assertions.assertEquals(FOUR, basketDecorator.getPrice());
    }

    @Test
    public void testRibbonDecorator() {
        Item itemToDecorate = new FlowerBucket();
        RibbonDecorator ribbonDecorator = 
            new RibbonDecorator(itemToDecorate);
        final double FORTY = 40.0;
        Assertions.assertEquals(FORTY, ribbonDecorator.getPrice());
    }

    @Test
    public void testPaperDecorator() {
        Item itemToDecorate = new FlowerBucket();
        PaperDecorator paperDecorator = 
            new PaperDecorator(itemToDecorate);
            final double THIRTEEN = 13.0;
        Assertions.assertEquals(THIRTEEN, paperDecorator.getPrice());
    }
}
