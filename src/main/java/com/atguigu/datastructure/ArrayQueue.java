package com.atguigu.datastructure;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date:2020/9/1 21:55
 **/
public class ArrayQueue<E> {

    Object[] element;
    int capacity;
    int head;
    int tail;
    int size;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int size) {
        this.capacity = size;
        element = new Object[size];
    }

    // 加载head，从尾部先出
    public boolean add(E t) {
        if (size < capacity) {
            element[head++ % capacity] = t;
            size++;
            return true;
        } else {
            throw new ArrayIndexOutOfBoundsException("装不下了");
        }
    }

    // java.util.PriorityQueue.poll()
    public E poll() {
        if (size == 0) {
            return null;
        }
        E e = (E) element[tail++ % capacity];
        element[(tail - 1) % capacity] = null;
        size--;
        return e;
    }

    public E get(int index) {
        return (E) element[index];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Test
    public void arrayQueueTest() {
        ArrayQueue<String> stringArrayQueue = new ArrayQueue<>(4);
        stringArrayQueue.add("a");
        System.out.println(stringArrayQueue.isFull());
        stringArrayQueue.add("b");
        stringArrayQueue.add("c");
        stringArrayQueue.add("d");
        System.out.println(stringArrayQueue.isFull());
        System.out.println(Arrays.toString(stringArrayQueue.element));
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        System.out.println("size=" + stringArrayQueue.size + ";head=" + stringArrayQueue.head + ";tail=" + stringArrayQueue.tail);
        stringArrayQueue.add("a");
        stringArrayQueue.add("b");
        stringArrayQueue.add("c");
        stringArrayQueue.add("d");
        System.out.println(Arrays.toString(stringArrayQueue.element));
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        System.out.println("size=" + stringArrayQueue.size + ";head=" + stringArrayQueue.head + ";tail=" + stringArrayQueue.tail);


        stringArrayQueue.add("a");
        stringArrayQueue.add("b");
        stringArrayQueue.add("c");
        stringArrayQueue.add("d");
        System.out.println(Arrays.toString(stringArrayQueue.element));
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        stringArrayQueue.add("a");
        stringArrayQueue.add("b");
        System.out.println(stringArrayQueue.isFull());
        System.out.println(Arrays.toString(stringArrayQueue.element));
        System.out.println("size=" + stringArrayQueue.size + ";head=" + stringArrayQueue.head + ";tail=" + stringArrayQueue.tail);
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.poll());
        System.out.println(stringArrayQueue.isFull());
        System.out.println(stringArrayQueue.isEmpty());
    }

}
