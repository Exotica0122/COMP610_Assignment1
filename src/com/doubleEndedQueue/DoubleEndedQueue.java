package com.doubleEndedQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;

/**
 *
 * @author sehall
 */
interface DoubleEndedQueue<E> {
    public void offerRear(E element);

    public void offerFront(E element);

    public E pollRear();

    public E pollFront();

    public E front();

    public E rear();

    public boolean isEmpty();

    public int size();

    public void clear();

    public Iterator<E> iterator();
}