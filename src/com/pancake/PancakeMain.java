package com.pancake;

import java.awt.*;

public class PancakeMain {
    public static void main(String[] args) {
        Pancake pancake = new Pancake(2, new Color(1,1,1));
        Pancake pancake2 = new Pancake(5, new Color(1,107,5));
        Pancake pancake3 = new Pancake(12, new Color(14,107,54));
        PancakeStack pancakeStack = new PancakeStack();
        pancakeStack.push(pancake);
        pancakeStack.push(pancake2);
        pancakeStack.push(pancake3);

        System.out.println(pancakeStack.isEmpty());
        System.out.println(pancakeStack.arrayStack);
        pancakeStack.flip(4);
        System.out.println(pancakeStack.arrayStack);
        System.out.println(pancakeStack.pop().getSize());
        System.out.println(pancakeStack.pop().getSize());
        System.out.println(pancakeStack.pop().getSize());

    }

}
