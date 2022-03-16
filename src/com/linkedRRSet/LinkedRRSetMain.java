package com.linkedRRSet;

public class LinkedRRSetMain {
    public static void main(String[] args) {
        LinkedRRSet<Integer> linkedRRSet = new LinkedRRSet<>();
        linkedRRSet.add(2);
        linkedRRSet.add(1);
        linkedRRSet.add(3);
        linkedRRSet.add(4);
        linkedRRSet.add(5);
        linkedRRSet.add(6);
        linkedRRSet.add(7);

//        System.out.println(linkedRRSet.retain(2, 6));

//        System.out.println(linkedRRSet.remove(2, 6));

//        System.out.println(linkedRRSet.retain(4, 5));

//        System.out.println(linkedRRSet.retain(6,7));

//        System.out.println(linkedRRSet.retain(4, null));

//        System.out.println(linkedRRSet.remove(4, null));

        System.out.println(linkedRRSet.remove(null, null));

        System.out.println(linkedRRSet);

//      String LinkedRRSet test
        LinkedRRSet<String> linkedRRSet2 = new LinkedRRSet<>();

        linkedRRSet2.add("Hi");
        linkedRRSet2.add("Bye");

        System.out.println(linkedRRSet2);

        System.out.println(linkedRRSet2.remove("Bye", "Hi"));

        System.out.println(linkedRRSet2);
    }
}
