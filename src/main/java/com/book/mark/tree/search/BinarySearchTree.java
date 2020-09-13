package com.book.mark.tree.search;

import com.book.mark.tree.BinaryNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 这里的泛型<? super T>没大明白
 *
 * @date:2020/9/13 10:42
 **/
public class BinarySearchTree<T extends Comparable<? super T>> {

    /**
     * 根节点
     */
    private BinaryNode<T> root;

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T t) {
        return node(t, root) != null;
    }

    /**
     * 找到某个节点，找不到返回null
     *
     * @param t
     * @return
     */
    private BinaryNode<T> node(T t, BinaryNode<T> root) {
        if (root == null) {
            return null;
        }
        if (t.compareTo(root.getElement()) == 0) {
            return root;
        } else if (t.compareTo(root.getElement()) > 0) {
            // 元素大于当前节点，去右子树查找
            return node(t, root.getRight());
        } else {
            return node(t, root.getLeft());
        }
    }

    public T findMax() {
        BinaryNode<T> current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getElement();
    }

    public T findMin() {
        BinaryNode<T> current;
        for (current = root; current.getLeft() != null; current = current.getLeft()) {
        }
        return current.getElement();
    }

    /**
     * 插入和删除比较难呐
     * 二叉搜索树不会出现两个重复元素...所以先查找，后插入。如果存在就不插入了
     */
    public void insert(T t) {
        if (root == null) {
            root = new BinaryNode<>(t, null, null);
            return;
        }
        if (node(t, root) != null) {
            return;
        }
        // 找到一个刚刚比t大的节点，或者刚刚比t小的节点current，如果current没有子节点，则直接将t作为current子节点
        // 如果current有子节点，则将当前t作为current子节点的同时，还需要将current的子节点作为t的子节点

        // 这个思路比较简单点：一直沿着树往下找，比子树根大往右找，比子树根小往左找，直到找到空节点
        BinaryNode<T> current = root;
        BinaryNode<T> result = null;
        while (current != null) {
            // 相等的情况按照小于处理吧！！
            if (t.compareTo(current.getElement()) > 0) {
                // 往右找
                result = current;
                current = current.getRight();
            } else {
                // 小于或者等于往左找
                result = current;
                current = current.getLeft();
            }
        }

        // 找到目标result节点
        if (t.compareTo(result.getElement()) > 0) {
            result.setRight(new BinaryNode<>(t, null, null));
        } else {
            result.setLeft(new BinaryNode<>(t, null, null));
        }

    }

    /**
     * 插入和删除比较难
     *
     * @param t
     */
    public void remove(T t) {

    }

    /**
     * 遍历
     *
     * @return
     */
    public void printLMRTree() {
        printLMRNode(root);
    }

    /**
     * 左中右遍历
     *
     * @param root
     */
    private void printLMRNode(BinaryNode<T> root) {
        if (root == null) {
            return;
        }
        // 先打印左子树
        printLMRNode(root.getLeft());
        // 再打印当前节点
        System.out.print(String.valueOf(root.getElement()) + " ");
        // 再打印右子树
        printLMRNode(root.getRight());
    }

    /**
     * 遍历
     *
     * @return
     */
    public void printRMLTree() {
        printRMLNode(root);
    }

    /**
     * 左中右遍历
     *
     * @param root
     */
    private void printRMLNode(BinaryNode<T> root) {
        if (root == null) {
            return;
        }
        // 先打印右子树
        printRMLNode(root.getRight());
        // 再打印当前节点
        System.out.print(String.valueOf(root.getElement()) + " ");
        // 再打印左子树
        printRMLNode(root.getLeft());
    }

    /**
     * 获取树的高度
     *
     * @return
     */
    public int hight() {
        if (isEmpty()) {
            return 0;
        }
        return hight(root);
    }

    private int hight(BinaryNode<T> root) {
        if (root == null) {
            return 0;
        }
        // max(左子树的深度,右子树的深度)+1
        return Math.max(hight(root.getLeft()), hight(root.getRight())) + 1;
    }

    /**
     * 先序遍历看不懂，就算了；这里想办法实现层序遍历
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return super.toString();
        }
        return queue(root);
    }

    private String queue(BinaryNode<T> root) {
        Queue<BinaryNode> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        BinaryNode<T> last = root;
        BinaryNode<T> nlast = null;
        while (queue.peek() != null) {
            BinaryNode<T> current = queue.poll();
            sb.append(current.getElement().toString() + "\t");
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
                nlast = current.getLeft();
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
                nlast = current.getRight();
            }

            if (last == current) {
                sb.append("\n");
                last = nlast;
            }
        }
        return sb.toString();
    }

    public String printLevel() {
        if (isEmpty()) {
            return null;
        }
        List<StringBuilder> list = new LinkedList<>();
        Queue<BinaryNode> queue = new ArrayDeque<>();
        StringBuilder level = new StringBuilder();
        queue.add(root);
        BinaryNode<T> last = root;
        BinaryNode<T> nlast = null;
        int hight = 0;
        while (queue.peek() != null && hight < hight()) {
            BinaryNode<T> current = queue.poll();
            if (current.getElement() != null) {
                level.append(current.getElement().toString());
            } else {
                level.append("*");
            }
            level.append("\t\t");
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
                nlast = current.getLeft();
            } else {
                // 空节点占位
                queue.add(nlast = new BinaryNode<>());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
                nlast = current.getRight();
            } else {
                // 空节点占位
                queue.add(nlast = new BinaryNode<>());
            }

            if (last == current) {
                System.out.println(level.toString());
                list.add(level);
                level = new StringBuilder();
                last = nlast;
                hight++;
            }
        }
        StringBuilder result = new StringBuilder();
        // 处理list
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count = list.size() - i;
            for (int j = 0; j < count; j++) {
                result.append("\t");
            }
            result.append(list.get(i) + "\n");
        }
        return result.toString();
    }

    // 找到每行的第一个非*的位置，再加1就是移动的位数
    private int findDigit(StringBuilder s) {
        for (int i = 0; i < s.length(); i++) {
            if (!"*".equals(String.valueOf(s.charAt(i))) && !"\t".equals(String.valueOf(s.charAt(i)))) {
                return i;
            }
        }
        return -1;
    }
}
