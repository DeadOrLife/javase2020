package wz.life.collection.day01.Iist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一组连续的整数，例如：10，11，12，……，20，但其中缺失一个数字，试找出缺失的数字：
 *
 * @DESCRIPTION
 * @AUTHOR: jamesbean
 * @DATE: 2021/2/14 10:25 上午
 */
public class Practice {

    public static void main(String[] args) {
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = start; i <=end ; i++) {
            list.add(i);
        }
        //随机删除List中的一个元素
        int removed = list.remove((int)(Math.random()*list.size()));
        int found = findMissingNumber(start,end,list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");


    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        //方法1
        //
        // 有首项、有尾项，且是一组连续的整数，那刚好符合数学中的 等差数列
        // 求和：（首相+尾项）*项数/2
        // 求和-元素的总和 = 被移除的元素
//        int sum = 0;
//        for(int i:list) {sum += i;}
//        int x = (start+end)*(end-start+1)/2 - sum;
//        return x;
        //缺点：针对数字进行

        //方法2
        while (list.contains(start)){
            start++;
        }
        return start;

//        0 ^ X = X;
//        X ^ X = 0;
//        交换律;
//        结合律.

    }
}
