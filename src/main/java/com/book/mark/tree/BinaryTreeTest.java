package com.book.mark.tree;

import com.book.mark.tree.search.BinarySearchTree;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @date:2020/9/13 12:13
 **/
public class BinaryTreeTest {

    @Test
    public void testSearch() {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(0);
        tree.insert(9);
        tree.insert(3);
        tree.printLMRTree();
        System.out.println();
        tree.printRMLTree();
        System.out.println();
        System.out.println(tree.findMax());
        System.out.println(tree.findMin());
        System.out.println("层序遍历--------------------------------");
        System.out.println(tree);
    }

    @Test
    public void testJdkQueue() {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
