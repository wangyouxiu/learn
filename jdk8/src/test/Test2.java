package test;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/2/25 9:50
 */

import java.util.HashMap;

/**
 * 背包载重问题：
 * https://mp.weixin.qq.com/s/MgNGAWfKp9O0j4lwsx4qLA
 */
public class Test2 {

    public static void main(String[] args) {
        int W = 5;
        int[] w = new int[]{1, 2, 3, 4};
        int[] v = new int[]{3, 4, 5, 6};
        int i = new Test2().doProblem(W, w, v);
        System.out.println(i);
    }

    public int doProblem(int W, int[] w,int[] v) {
        //商品重量按照下标取
        //背包容量直接存对应值
        int n = w.length;
        int[][] f = new int[n][W + 1];
        //先计算边界，当背包容量为0，则全部为0，这个不用初始化
        //当只考虑第一件商品，则只要容量大于1，其最大价值就是商品价值
        for (int i = 1; i < W + 1; i++) {
            f[0][i] = v[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (j < w[i]) {
                    //背包容量放不下当前商品，选之前的就行
                    f[i][j] = f[i - 1][j];
                } else {
                    //如果能放下
                    f[i][j] = Math.max(v[i] + f[i - 1][j - w[i]], f[i - 1][j]);
                }
            }
        }

        return f[n-1][W];
    }
}