package com.book.mark.list;

import com.book.mark.list.array.MyArrayList;
import com.book.mark.list.linked.MyLinkedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @date:2020/9/12 16:01
 **/
public class ListTest {

    @Test
    public void testArrayList() {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("aa");
        arrayList.add("bb");
        arrayList.add("cc");
        arrayList.add("dd");
        System.out.println(arrayList);
        System.out.println(arrayList.remove(1));
        System.out.println(arrayList);

        ListIterator<String> iterator = arrayList.iterator();
        try {
            while (iterator.hasNext()) {
                // 迭代器是禁止 hasNext判断后，紧接着调用remove方法的
                System.out.println(iterator.remove());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        MyArrayList<Integer> ll = new MyArrayList<>();
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        ll.add(10);
        ll.add(9);
        ll.add(9);
        ll.add(9);
        ListIterator<Integer> listIterator = ll.iterator();

        for (; listIterator.hasNext(); ) {
            if (listIterator.next() % 2 == 0) {
                listIterator.remove();
            }
        }
        System.out.println(ll);
    }

    @Test
    public void testJdkArrayList2() {
        List<Integer> ll = new ArrayList<>();
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        Iterator<Integer> listIterator = ll.iterator();
        for (; listIterator.hasNext(); ) {
            listIterator.remove();
        }
        System.out.println(ll);
    }

    @Test
    public void testLinkedList() {
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");
        linkedList.add("cc");
        linkedList.add("dd");
        System.out.println(linkedList);
        System.out.println(linkedList.remove(1));
        System.out.println(linkedList);
        System.out.println("------------------------");
        ListIterator<String> iterator = linkedList.iterator();
        try {
            while (iterator.hasNext()) {
                // 迭代器是禁止 hasNext判断后，紧接着调用remove方法的
                System.out.println("1111111111=====" + iterator.remove());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        MyList<Integer> ll = new MyLinkedList<>();
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        ll.add(10);
        ll.add(9);
        ll.add(9);
        ll.add(9);
        ListIterator<Integer> listIterator = ll.iterator();
        System.out.println(ll);
        for (; listIterator.hasNext(); ) {
            if (listIterator.next() % 2 == 0) {
                System.out.print(listIterator.remove() + " ");
            }
        }
        System.out.println();
        System.out.println(ll);
    }
}
