package com.algorithm;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @date:2020/10/6 14:53
 **/
public class SimpleAlgo {

    // 有物品：2,3,5,7,8,13,15 能否装下26的包，怎么装？
    @Test
    public void packageTest() {
        int[] goods = {2, 3, 5, 7, 8, 13, 15};
        List<Integer> result = new LinkedList<>();
        System.out.println(packageResult(goods, 26, result));
        System.out.println(result);
    }

    private boolean packageResult(int[] goods, int i, List<Integer> result) {
        if (i == 0) {
            return true;
        }
        // 物品小于0或者包空了，返回false
        if (i < 0 || goods.length == 0) {
            return false;
        }
        // 拿出一个物品出来
        int first = goods[0];
        int[] part = new int[goods.length - 1];
        System.arraycopy(goods, 1, part, 0, part.length);
        // 扣除一个，重量减一仍能成功
        if (packageResult(part, i - first, result)) {
            result.add(first);
            return true;
        }
        return packageResult(part, i, result);
    }

}
