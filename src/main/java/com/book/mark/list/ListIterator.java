package com.book.mark.list;

/**
 * 迭代器接口
 *
 * @date:2020/9/12 15:34
 **/
public interface ListIterator<T> {

    /**
     * 下一个元素
     *
     * @return
     */
    T next();

    /**
     * 是否还有下一个元素
     *
     * @return
     */
    boolean hasNext();

    /**
     * 删除当前元素
     */
    T remove();

}
