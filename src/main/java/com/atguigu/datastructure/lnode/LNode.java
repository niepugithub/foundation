package com.atguigu.datastructure.lnode;

/**
 * @date:2020/9/3 21:07
 **/
public class LNode<T> {

    private T ele;

    /**
     * 当前节点指向的下一个节点
     */
    private LNode<T> next;

    public LNode(T ele) {
        this.ele = ele;
    }

    public void setNext(LNode<T> next) {
        this.next = next;
    }

    public LNode<T> getNext() {
        return next;
    }

    public T getEle() {
        return ele;
    }

}
