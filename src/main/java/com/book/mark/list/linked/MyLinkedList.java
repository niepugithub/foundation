package com.book.mark.list.linked;

import com.book.mark.list.ListIterator;
import com.book.mark.list.MyList;

/**
 * @date:2020/9/12 17:57
 **/
public class MyLinkedList<T> implements MyList<T> {

    private LNode<T> first;
    private LNode<T> last;
    private int size;

    public MyLinkedList() {

    }

    @Override
    public void add(T t) {
        linkLast(t);
    }

    /**
     * 在链表末尾添加元素
     *
     * @param t
     */
    private void linkLast(T t) {
        LNode<T> l = last;
        LNode<T> newNode = new LNode<>(l, t, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    /**
     * 定位到index位置位置处的node;
     *
     * @param index
     * @return
     */
    private LNode<T> node(int index) {
        //TODO这里值得学习
        // 检查index是否越界抽取出去
        if (index < size >> 1) {
            // 从左半部分开始查找
            LNode<T> currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        } else {
            // 从右半部分开始查找
            LNode<T> currentNode = last;
            for (int j = size - 1; j > index; j--) {
                currentNode = last.prex;
            }
            return currentNode;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private T unlink(LNode<T> node) {
        LNode<T> prex = node.prex;
        LNode<T> next = node.next;
        T item = node.item;

        if (prex == null) {
            // 说明删除的是头节点
            first = node.next;
        } else {
            prex.next = next;
            node.prex = null;
        }

        // 说明删除的是尾节点
        if (next == null) {
            last = prex;
        } else {
            next.prex = prex;
            node.next = null;
        }
        node.item = null;
        size--;
        return item;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (LNode<T> current = first; ; current = current.next) {
            b.append(String.valueOf(current.item));
            if (current == last) {
                return b.append(']').toString();
            }
            b.append(", ");
        }

    }

    @Override
    public ListIterator<T> iterator() {
        return new MyIterator(this);
    }

    private class MyIterator implements ListIterator<T> {

        private MyLinkedList<T> linkedList;
        LNode<T> current;

        public MyIterator(MyLinkedList<T> linkedList) {
            this.linkedList = linkedList;
            // 不像数组表，这里需要初始化current的值
            current = linkedList.first;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T remove() {
            if (current == null || current.prex == null) {
                throw new IllegalStateException();
            }
            // 上面先将current向前移一位，然后删除
            return linkedList.unlink(current.prex);
        }
    }

    private class LNode<T> {

        private T item;

        private LNode<T> prex;

        private LNode<T> next;

        public LNode() {
        }

        public LNode(LNode<T> prex, T item, LNode<T> next) {
            this.prex = prex;
            this.item = item;
            this.next = next;
        }

    }

}
