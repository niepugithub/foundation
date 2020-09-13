package com.book.mark.tree;

/**
 * 树节点
 *
 * @date:2020/9/13 10:38
 **/
public class BinaryNode<T> {

    T element;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode() {

    }

    public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    // @Override
    // public String toString() {
    //     if (element == null) {
    //         return super.toString();
    //     }
    //     return String.valueOf(element);
    // }

}
