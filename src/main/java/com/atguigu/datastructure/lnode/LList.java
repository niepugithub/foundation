package com.atguigu.datastructure.lnode;

/**
 * 单向链表：只要一个头节点吧
 *
 * @date:2020/9/3 21:07
 **/
public class LList<T> {

    private LNode<T> first;
    private LNode<T> last;
    private int size;

    public LList() {
        first = new LNode<>(null);
        last = new LNode<>(null);
        first.setNext(last);
        last.setNext(first);
    }

    public void add(T t) {
        LNode<T> lNode = new LNode<>(t);
        last.getNext().setNext(lNode);
        lNode.setNext(last);
        last.setNext(lNode);
        size++;
    }

    public boolean isEmpty() {
        // 如果头节点的下一个节点就是尾节点，说明链表是空的
        return first.getNext() == last;
    }

    public Iterator<T> iterator() {
        return new Iterator<>(first, last);
    }

    public class Iterator<T> {

        LNode<T> current;
        LNode<T> last;

        private Iterator(LNode<T> current, LNode<T> last) {
            this.current = current;
            this.last = last;
        }

        public boolean hasNext() {
            return current.getNext() != last;
        }

        public T next() {
            current = current.getNext();
            return current.getEle();
        }
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            StringBuffer sb = new StringBuffer("[");
            LNode<T> current = first;
            while (current.getNext() != last) {
                sb.append(current.getNext().getEle() + ",");
                current = current.getNext();
            }
            return sb.replace(sb.length() - 1, sb.length(), "]").toString();
        }
        return super.toString();
    }

}
