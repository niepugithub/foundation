package com.atguigu.datastructure.lnode;

import org.junit.Test;

/**
 * @date:2020/9/3 21:23
 **/
public class LListTest {

    @Test
    public void testLlist() {
        LList<String> lList = new LList<>();
        lList.add("aa");
        lList.add("bb");
        lList.add("cc");
        lList.add("dd");
        lList.add("ee");
        LList<String>.Iterator<String> iterator = lList.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println("第" + count++ + "个元素的值====" + s);
        }
        System.out.println(lList.toString());
    }

}
