package com.company;

interface MyBST <Key extends Comparable <Key>, Value> {
    public void insert(Key x, Value v);
    public void delete(Key x);
    public Value lookup(Key x);
    public void printPreOrder();
    public void printInOrder();
    public void printPostOrder();
}


class Main {

    public static void main(String[] args) {
       // System.out.println("Let's transform an array into a tree using a for loop");
        MyBinarySearchTree<Integer, String> tree = new MyBinarySearchTree<>();
        /*
        int [] Key = { 10, 11, 2, 4, 12, 61, 69, 24, 90, 32, 51, 41, 6};
        Arrays [] match;
        match = new Arrays[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'};
        //inset for loop
         for (int i : Key) {
            for (Arrays a : match) {
                tree.insert(i, match);
            }
        }
        //will have to convert string to array. Not using this anymore
         */
        tree.insert(10, "A");
        tree.insert(11, "B");
        tree.insert(2,  "C");
        tree.insert(4, "D");
        tree.insert(12, "E");
        tree.insert(61, "F");
        tree.insert(69, "G");
        tree.insert(24, "H");
        tree.insert(90, "I");

        System.out.println("Print after insertion\n");
        System.out.print("In Order:\n");
        tree.printInOrder();
        System.out.println("\nPost Order:");
        tree.printPostOrder();
        System.out.println("\nPre Order:");
        tree.printPreOrder();

        System.out.println("\nPrint after deletion");
        tree.delete(24);
        tree.delete(4);
        System.out.println("After deleting 24 and 4:\n");
        System.out.print("In Order:\n");
        tree.printInOrder();
        System.out.println("\nPost Order:");
        tree.printPostOrder();
        System.out.println("\nPre Order:");
        tree.printPreOrder();

        System.out.println("\nLook up the values of the leafNodes deleted");
        System.out.println("\nIf the leafNodes were deleted, it will return null because they dont exist in the tree anymore");
        System.out.println("Look up 24: "+ tree.lookup(24));
        System.out.println("Look up 4: "+ tree.lookup(4));
        System.out.println("Look up 61 and 69: "+
                "\nif present, return their values" + "\n" + tree.lookup(61) + tree.lookup(69));


        System.out.println("\nThere are three more lookups which" +
                " all return null because I do not have any " +
                "of those elements in the tree.");
        System.out.println(tree.lookup(6));
        System.out.println(tree.lookup(0));
        System.out.println(tree.lookup(53));



    }
}
