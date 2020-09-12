package com.book.mark.list.array;

import com.book.mark.list.ListIterator;
import com.book.mark.list.MyList;

/**
 * 实现数组链表
 *
 * @date:2020/9/12 15:31
 **/
public class MyArrayList<T> implements MyList<T> {

    private int size;
    private T[] ele;
    private int capacity;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        ele = (T[]) new Object[capacity];
    }

    @Override
    public ListIterator<T> iterator() {
        return new MyIterator<T>(this);
    }

    @Override
    public void add(T t) {
        if (size == capacity) {
            // 需要扩容操作了
            T[] expand = (T[]) new Object[this.capacity = capacity * 2];
            System.arraycopy(ele, 0, expand, 0, size);
            ele = expand;
        }
        ele[size++] = t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        return ele[index];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T remove(int index) {
        T t = ele[index];
        for (int i = index; i < size - 1; i++) {
            ele[i] = ele[i + 1];
        }
        size--;
        return t;
    }

    private class MyIterator<T> implements ListIterator<T> {

        private MyArrayList<T> arrayList;
        int current;

        public MyIterator(MyArrayList<T> arrayList) {
            this.arrayList = arrayList;
        }

        @Override
        public T next() {
            return arrayList.get(current++);
        }

        @Override
        public boolean hasNext() {
            return current != arrayList.size();
        }

        @Override
        public T remove() {
            if (--current < 0) {
                throw new IllegalStateException();
            }
            return arrayList.remove(current);
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            //TODO 这个地方还是蛮巧妙的，得到最后一个加]
            b.append(String.valueOf(ele[i]));
            if (i == size - 1) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }


}
