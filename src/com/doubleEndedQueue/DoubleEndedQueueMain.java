package com.doubleEndedQueue;


public class DoubleEndedQueueMain {
    public static void main(String[] args) {
//        ArrayDoubleEndedQueue<String> doubleEndedQueue = new ArrayDoubleEndedQueue<>();
//        doubleEndedQueue.offerFront("A");
//        System.out.println(doubleEndedQueue);
//        doubleEndedQueue.offerFront("B");
//        System.out.println(doubleEndedQueue);
//        doubleEndedQueue.offerRear("C");
//        System.out.println(doubleEndedQueue);
//        doubleEndedQueue.pollFront();
//        System.out.println(doubleEndedQueue);
//        doubleEndedQueue.pollRear();
//        System.out.println(doubleEndedQueue);
//        System.out.println(doubleEndedQueue.front());
//        System.out.println(doubleEndedQueue.rear());
//        doubleEndedQueue.offerRear("B");
//        System.out.println(doubleEndedQueue);
//        System.out.println(doubleEndedQueue.isEmpty());

        LinkedDoubleEndedQueue<String> linkedDoubleEndedQueue = new LinkedDoubleEndedQueue<>();
        linkedDoubleEndedQueue.offerFront("A");
        System.out.println(linkedDoubleEndedQueue);
        linkedDoubleEndedQueue.offerFront("B");
        System.out.println(linkedDoubleEndedQueue);
        linkedDoubleEndedQueue.offerFront("C");
        System.out.println(linkedDoubleEndedQueue);
        linkedDoubleEndedQueue.offerFront("D");
        System.out.println(linkedDoubleEndedQueue);
        System.out.println(linkedDoubleEndedQueue.pollRear());
        System.out.println(linkedDoubleEndedQueue.pollFront());
        System.out.println(linkedDoubleEndedQueue.front());
        System.out.println(linkedDoubleEndedQueue.rear());
        System.out.println(linkedDoubleEndedQueue.isEmpty());
        System.out.println(linkedDoubleEndedQueue.size());
        linkedDoubleEndedQueue.clear();
        System.out.println(linkedDoubleEndedQueue);
        linkedDoubleEndedQueue.offerRear("A");
        System.out.println(linkedDoubleEndedQueue);
    }
}
