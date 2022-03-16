package com.doubleEndedQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDoubleEndedQueue<E> implements DoubleEndedQueue<E>
{
    private int numElements;
    private Node<E> frontNode;
    private Node<E> rearNode;

    // default constructor that creates a new queue
    // that is initially empty
    public LinkedDoubleEndedQueue()
    {  super();
        numElements = 0;
        frontNode = null;
        rearNode = null;
    }

    // constructor for creating a new queue which
    // initially holds the elements in the collection c
    public LinkedDoubleEndedQueue(Collection<? extends E> c)
    {  this();
        for (E element : c)
            offerFront(element);
    }

    public void offerFront(E element) {
        Node<E> newNode = new Node<E>(element);
        // add the new node to the end of the list
        if(rearNode==null) {
            frontNode = newNode;
            rearNode = newNode;
        } else {
            newNode.next = frontNode;
            frontNode = newNode;
        }
        numElements++;
    }

    public void offerRear(E element) {
        Node<E> newNode = new Node<E>(element);
        // add the new node to the end of the list
        if(rearNode==null) {
            frontNode = newNode;
            rearNode = newNode;
        } else {
            rearNode.next = newNode;
            rearNode = newNode;
        }
        numElements++;
    }

    public E pollRear() throws NoSuchElementException{
        if(numElements > 0) {
            Node<E> frontTemp = frontNode;
            frontNode = frontNode.next;
            numElements--;
            return frontTemp.element;
        } else {
            throw new NoSuchElementException();
        }
    }

    public E pollFront() throws NoSuchElementException{
        if(numElements > 0) {
            Node<E> RearTemp = rearNode;
            Node<E> current = frontNode;
            for(int i=0; i<numElements-2; i++) current=current.next;
            rearNode = current;
            current.next = null;
            numElements--;
            return RearTemp.element;
        } else {
            throw new NoSuchElementException();
        }
    }

    public E front() throws NoSuchElementException
    {  if (numElements > 0)
        return rearNode.element;
    else
        throw new NoSuchElementException();
    }

    public E rear() throws NoSuchElementException
    {  if (numElements > 0)
        return frontNode.element;
    else
        throw new NoSuchElementException();
    }

    // returns true if this queue contains no elements
    public boolean isEmpty()
    {  return (numElements==0);
    }

    // returns the number of elements in this queue
    public int size()
    {  return numElements;
    }

    public void clear() {
        numElements = 0;
        frontNode = null;
        rearNode = null;
    }

    public Iterator<E> iterator() {
        // Finish this question
        return new LinkedIterator<E>(frontNode);
    }

    // returns a string representation of the queue from front to rear
    public String toString()
    {  String output = "[";
        Node currentNode = frontNode;
        while (currentNode != null)
        {  output += currentNode.element;
            if (currentNode.next != null)
                output += ",";
            currentNode = currentNode.next;
        }
        output += "]";
        return output;
    }

    // inner class which represents a node in a singly-linked list
    private class Node<E>
    {
        public E element;
        public Node<E> next;

        public Node(E element)
        {  this.element = element;
            next = null;
        }
    }

    // inner class which represents an iterator for a singly-linked list
    private class LinkedIterator<E> implements Iterator<E>
    {
        private Node<E> nextNode; // next node to use for the iterator

        // constructor which accepts a reference to first node in list
        // and prepares an iterator which will iterate through the
        // entire linked list
        public LinkedIterator(Node<E> firstNode)
        {  nextNode = firstNode; // start with first node in list
        }

        // returns whether there is still another element
        public boolean hasNext()
        {  return (nextNode!=null);
        }

        // returns the next element or throws a NoSuchElementException
        // it there are no further elements
        public E next() throws NoSuchElementException
        {  if (!hasNext())
            throw new NoSuchElementException();
            E element = nextNode.element;
            nextNode = nextNode.next;
            return element;
        }

        // remove method not supported by this iterator
        public void remove() throws UnsupportedOperationException
        {  throw new UnsupportedOperationException();
        }
    }
}