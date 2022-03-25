package com.company;

class MyBinarySearchTree<Key extends Comparable<Key>, Value> implements MyBST<Key, Value> {

    private MyTreeNode<Key, Value> root;

    public MyBinarySearchTree() {
        root = null;
    }
    //public void insert(Key leafNode, Value valueOfLeafNode) {
        //MyTreeNode nodeToAdd = new MyTreeNode<Key, Value>();
      //  if(root == null)
          //  root = nodeToAdd;
        //traverseAndAddNode(root, nodeToAdd);
   // }
    @Override
    public void insert(Key leafNode, Value valueOfLeafNode) {
        if (root == null) {
            // if root is empty, insert leafnode either to left or right depending on valueofleafNode
            root = new MyTreeNode<Key, Value>();
            root.key = leafNode;
            root.data = valueOfLeafNode;
            root.leftchild = null;
            root.rightchild = null;
            root.parent = null;
        }
        else
            root.insert(leafNode, valueOfLeafNode);
    }

    @Override
    public void delete(Key x) {
        MyTreeNode<Key, Value> nodeToDelete = root;
        while (nodeToDelete != null) {
            if (nodeToDelete.key.compareTo(x) == 0)
                break;
            else if (nodeToDelete.key.compareTo(x) > 0)
                nodeToDelete = nodeToDelete.leftchild;
            else
                nodeToDelete = nodeToDelete.rightchild;
        }

        if (nodeToDelete != null) {

            if (nodeToDelete.leftchild == null && nodeToDelete.rightchild == null) {
                //case 1: no child
                if (nodeToDelete == root)
                    root = null;
                else if (nodeToDelete.parent.leftchild == nodeToDelete)
                    nodeToDelete.parent.leftchild = null;
                else
                    nodeToDelete.parent.rightchild = null;
            }
            else if (nodeToDelete.leftchild == null) {
                //case2: one left child
                if (nodeToDelete == root) {
                    root = nodeToDelete.rightchild;
                    root.parent = null;
                } else if (nodeToDelete.parent.leftchild == nodeToDelete)
                    nodeToDelete.parent.leftchild = nodeToDelete.rightchild;
                else
                    nodeToDelete.parent.rightchild = nodeToDelete.rightchild;
            }
            else if (nodeToDelete.rightchild == null) {
                //case3: one right child
                if (nodeToDelete == root) {
                    root = nodeToDelete.leftchild;
                    root.parent = null;
                } else if (nodeToDelete.parent.leftchild == nodeToDelete)
                    nodeToDelete.parent.leftchild = nodeToDelete.leftchild;
                else
                    nodeToDelete.parent.rightchild = nodeToDelete.leftchild;
            }
            else{
                //case4: two children
                MyTreeNode<Key, Value> newNode = nodeToDelete.rightchild;
                while (newNode.leftchild != null)
                    newNode = newNode.leftchild;

                if (nodeToDelete == root) {
                    root.key = newNode.key;
                    root.data = newNode.data;

                    if (newNode.parent == nodeToDelete)
                        root.rightchild = newNode.rightchild;
                    else
                        newNode.parent.leftchild = newNode.rightchild;
                } else {
                    nodeToDelete.key = newNode.key;
                    nodeToDelete.data = newNode.data;

                    if (newNode.parent == nodeToDelete)
                        nodeToDelete.rightchild = newNode.rightchild;
                    else
                        newNode.parent.leftchild = newNode.rightchild;
                }
            }
        }

    }

    @Override
    public Value lookup(Key x) {
        MyTreeNode<Key, Value> leafNode = root;
        while (leafNode != null) {
            if (leafNode.key.compareTo(x) == 0)
                return leafNode.data;
            else if (leafNode.key.compareTo(x) > 0)
                leafNode = leafNode.leftchild;
            else
                leafNode = leafNode.rightchild;
        }
        return null;
    }

    public void printPreOrder() {if(root != null)
            root.printPreOrder();}

    public void printInOrder() {if(root != null)
            root.printInOrder();}

    public void printPostOrder() { if(root != null)
            root.printPostOrder();}
}
