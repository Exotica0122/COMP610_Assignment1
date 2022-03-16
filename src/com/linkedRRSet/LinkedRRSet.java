package com.linkedRRSet;

import java.util.InputMismatchException;

public class LinkedRRSet<E extends Comparable<E>> extends LinkedSet<E> {

    public LinkedRRSet() {
        super();
    }

    public boolean add(E o) {
        Node newNode = new Node<>(o);

//      If there is no head node or adding element is smaller than head node
        if(this.firstNode == null || this.firstNode.element.compareTo(o) > 0) {
            newNode.next = this.firstNode;
            this.firstNode = newNode;
            this.numElements++;
            return true;
        }

        Node<E> current = firstNode;
//      loop until greater value or same value is found
        while(current.next != null && current.element.compareTo(o) < 0) {
            current = current.next;
            if(current.element.compareTo(o) == 0) return false; // exit when value exists
        }

        Node connect = current.next;
        current.next = newNode;
        newNode.next = connect;
        this.numElements++;
        return true;
    }


    public LinkedRRSet remove(E start, E end) throws InputMismatchException {
        // clause cases
        if((start == end && start !=null) || firstNode.element == end) return null;

//      Initialize return value and current node to loop
        LinkedRRSet<E> removedSets = new LinkedRRSet<>();

//      clause case when start and end is null
        if(start == null && end == null) {
            removedSets.firstNode = this.firstNode;
            this.clear();
            return removedSets;
        }

        Node<E> previous = firstNode;
        Node<E> current = firstNode.next;

//      special case
        if(start == firstNode.element || start == null) { current = firstNode; start = firstNode.element; }

//      Loop till start found
        while(current.next != null && current.element != start) {
            previous = current;
            current = current.next;
        }

        if(current.element != start) throw new InputMismatchException("Start is not a value input");

        Node<E> cache = previous;

//      Loop till end found
        while(current.next != null && current.element != end) {
            removedSets.add(current.element);
            current = current.next;
        }


        if(current.element != end && end != null) throw new InputMismatchException("End is not a value input");

//      when start = null
        if(start == firstNode.element) firstNode = current;
//      when end == null
        else if (end == null) { removedSets.add(current.element);cache.next = null; }
        else cache.next = current;

        return removedSets;
    }

    public LinkedRRSet retain(E start, E end) {
        LinkedRRSet<E> retain = this.remove(start, end);
        Node retainNode = retain.firstNode;
        retain.firstNode = this.firstNode;
        this.firstNode = retainNode;
        return retain;
    }


    public String toString() {
        Node<E> current = firstNode;
        String str = "[ ";
        while(current != null) {
            str += (current.element);
            if(current.next!=null) str+=", ";
            current = current.next;
        }
        str += " ]";
        return str;
    }
}
