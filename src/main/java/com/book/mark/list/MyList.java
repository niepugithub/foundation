package com.book.mark.list;

/**
 * @date:2020/9/12 17:58
 **/
public interface MyList<T> {

    /**
     * 添加元素
     *
     * @param t
     */
    void add(T t);

    /**
     * list元素格式
     *
     * @return
     */
    int size();

    /**
     * 获取某个元素
     *
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 集合是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 删除某个元素
     *
     * @param index
     * @return
     */
    T remove(int index);

    /**
     * 迭代器
     *
     * @return
     */
    ListIterator<T> iterator();
}
