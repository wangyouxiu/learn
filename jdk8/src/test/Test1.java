package test;

import com.sun.tools.javac.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/2/24 14:16
 */

public class Test1 {

    /*给你一个数组，找出符合要求的数列，使得这个数列的和最大。
要求: 数列中的元素下标不能连续


示例 1：
输入： [1,2,3,1]
输出： 4
解释： 选择第1，第3个，sum = 1 + 3 = 4。
示例 2：


输入： [2,7,9,3,1]
输出： 12
解释： 选择第1，第3，第5，sum = 2 + 9 + 1 = 12。
示例 3：


输入： [2,1,4,5,3,1,1,3]
输出： 12
解释： 选择第1，第3，第5和第8，sum = 2 + 4 + 3 + 3 = 12。


输入： []
输出： 0


Notes：
1. 程序里面一个类要实现这个方法，用main程序测试
 public int process(int[] nums) {}
2. 不能使用任何java.util.*; java.lang.*; 以外的包*/


    public static void main(String[] args) {
        int res = new Test1().process(new int[]{2, 1, 4, 5, 3, 1, 1, 3});
        System.out.println(res);
    }

    public int process(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums[0];
        }
        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        opt[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i++) {
            int a = nums[i] + opt[i-2];
            int b = opt[i - 1];
            opt[i] = a > b ? a : b;
        }
        return opt[nums.length - 1];
    }

}