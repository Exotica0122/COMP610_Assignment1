package com.pancake;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class PancakeStack extends ArrayList<Pancake> {

    protected ArrayList<Pancake> arrayStack;

    public PancakeStack() {
        this.arrayStack = new ArrayList<>();
    }

    public void push(Pancake element) {
        this.arrayStack.add(element);
    }

    public Pancake pop() throws NoSuchElementException {
        if(this.isEmpty()) throw new NoSuchElementException("No Elements to pop");
        Pancake popElement = this.peek();
        arrayStack.remove(0);

        return popElement;
    }

    public Pancake peek() throws NoSuchElementException {
        if(this.isEmpty()) throw new NoSuchElementException("No Elements to peek");

        return arrayStack.get(0);
    }

    public boolean isEmpty() { return this.arrayStack.size()==0; }

    public int findMax(int offset) {
        int maxIndex = offset;
        for(int i = 0; i< offset; i++) {
            if(arrayStack.get(maxIndex).compareTo(arrayStack.get(i)) < 0) { maxIndex = i; }
        }

        return maxIndex;
    }

    public int size() {
        return this.arrayStack.size();
    }

    public void flip(int offset) {
        if(this.isEmpty()) { System.out.println("Index out of bounds"); return; }
        offset++;
        ArrayList<Pancake> newArray = new ArrayList<>(arrayStack.subList(0, offset));
        Collections.reverse(newArray);
        newArray.addAll(offset, new ArrayList<>(arrayStack.subList(offset, this.size())));
        this.arrayStack = newArray;
    }
}