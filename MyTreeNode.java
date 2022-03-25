package com.company;

//Q1 - Node in a binary search tree.
public class MyTreeNode<Key extends Comparable<Key>, Value> {
    public Key key;
    public Value data;
    public MyTreeNode<Key, Value> leftchild;
    public MyTreeNode<Key, Value> rightchild;
    public MyTreeNode<Key, Value> parent;

    public void insert(Key leafnode, Value valueOfLeafNode) {

       // we want to contruct a tree and insert leaf nodes into the tree.
        if (leafnode.compareTo(key) < 0) {
            //compare the leafnode to key. If leafnode is less than key, we want to insert to the left of the key
            //else, insert to right of key

            if (leftchild == null) {
                //if leftchild is empty, insert leafnode < 0 here
                MyTreeNode<Key, Value> node = new MyTreeNode<>();
                node.key = leafnode;
                node.data = valueOfLeafNode;
                node.leftchild = null;
                node.rightchild = null;
                node.parent = this;
                leftchild = node;
            }
            else {
                leftchild.insert(leafnode, valueOfLeafNode);
            }
        }
        else if (leafnode.compareTo(key) > 0) {
            //if leafnode is bigger than key, put it on right child position.
            if (rightchild == null) {
                MyTreeNode<Key, Value> node = new MyTreeNode<>();
                node.key = leafnode;
                node.data = valueOfLeafNode;
                node.leftchild = null;
                node.rightchild = null;
                node.parent = this;
                rightchild = node;
            } else {
                rightchild.insert(leafnode, valueOfLeafNode);
            }
        }
        else if (leafnode.compareTo(key) ==0){
            System.out.println("Nothing was inserted because leafNode equals to key and no duplication is allowed");
        }
    }

    public void printPreOrder() {
        System.out.println(key + ":" + data);
        if (leftchild != null)
            leftchild.printPreOrder();
        if (rightchild != null)
            rightchild.printPreOrder();
    }

    public void printInOrder() {
        if (leftchild != null)
            leftchild.printInOrder();
        System.out.println(key + ":" + data);
        if (rightchild != null)
            rightchild.printInOrder();
    }

    public void printPostOrder() {
        if (leftchild != null)
            leftchild.printPostOrder();
        if (rightchild != null)
            rightchild.printPostOrder();
        System.out.println(key + ":" + data);
    }
}
