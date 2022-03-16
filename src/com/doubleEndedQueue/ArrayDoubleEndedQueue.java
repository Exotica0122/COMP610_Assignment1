package com.doubleEndedQueue;

import java.util.*;

public class ArrayDoubleEndedQueue<E> implements DoubleEndedQueue<E> {
    private final int INITIAL_CAPACITY = 20;
    protected int numElements;
    protected E[] elements;
    protected int front;
    protected int rear;

    public ArrayDoubleEndedQueue() {
        elements = (E[])(new Object[INITIAL_CAPACITY]);
        numElements = 0;
        front = 0;
        rear = elements.length-1;
    }

    public ArrayDoubleEndedQueue(Collection<? extends E> c)
    {
        this();
        for (E element : c)
        	offerFront(element);
    }

    public void offerFront(E element) {
        if (front + 1 != rear) {
            elements[front] = element;
            front = (front + 1) % elements.length;
            numElements++;
        }
    }

    public void offerRear(E element) {
        if(rear - 1 != front) {
            elements[rear] = element;
            rear = (rear - 1) % elements.length;
            numElements++;
        }
    }

    public E pollFront() throws NoSuchElementException {
        if(numElements > 0) {
            E frontElement = elements[front-1];
            elements[front-1] = null;
            front = (front-1)%elements.length;
            numElements--;
            return frontElement;
        } else {
            throw new NoSuchElementException();
        }
    }

    public E pollRear() throws NoSuchElementException {
        if(numElements > 0) {
            E rearElement = elements[rear+1];
            elements[rear+1] = null;
            rear=(rear+1)%elements.length;
            numElements--;
            return rearElement;
        } else {
            throw new NoSuchElementException();
        }
    }

    public E front() {
        return elements[(front-1)%elements.length];
    }

    public E rear() {
        return elements[(rear+1)%elements.length];
    }

    public boolean isEmpty() {
        return (numElements==0);
    }

    public int size() {
        return numElements;
    }

    public void clear() {
        elements = (E[])(new Object[INITIAL_CAPACITY]);
        numElements = 0;
        front = 0;
        rear = elements.length-1;
    }

    public Iterator iterator() {
        return Arrays.stream(elements).iterator();
    }

//    public String toString() {
//        String output = "[";
//        for(int i=(rear+1)%elements.length; i != front ; i=(i+1)%elements.length)
//        {
//            output += elements[i];
//            if (i!= front-1) {
//                output += ",";
//
//            }
//        }
//        output += "]";
//        return output;
//    }

    public String toString() {
        String output = "[";
        for(int i=0; i<elements.length ; i++)
        {
            output += elements[i];
            if (i<elements.length-1) {
                output += ",";

            }
        }
        output += "]";
        return output;
    }
}
