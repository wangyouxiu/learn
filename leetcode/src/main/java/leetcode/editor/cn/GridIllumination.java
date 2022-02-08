//在大小为 n x n 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。
//
// 给你一个由灯的位置组成的二维数组 lamps ，其中 lamps[i] = [rowi, coli] 表示 打开 位于 grid[rowi][coli] 
//的灯。即便同一盏灯可能在 lamps 中多次列出，不会影响这盏灯处于 打开 状态。 
//
// 当一盏灯处于打开状态，它将会照亮 自身所在单元格 以及同一 行 、同一 列 和两条 对角线 上的 所有其他单元格 。 
//
// 另给你一个二维数组 queries ，其中 queries[j] = [rowj, colj] 。对于第 j 个查询，如果单元格 [rowj, colj]
// 是被照亮的，则查询结果为 1 ，否则为 0 。在第 j 次查询之后 [按照查询的顺序] ，关闭 位于单元格 grid[rowj][colj] 上及相邻 8 个
//方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。 
//
// 返回一个整数数组 ans 作为答案， ans[j] 应等于第 j 次查询 queries[j] 的结果，1 表示照亮，0 表示未照亮。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
//输出：[1,0]
//解释：最初所有灯都是关闭的。在执行查询之前，打开位于 [0, 0] 和 [4, 4] 的灯。第 0 次查询检查 grid[1][1] 是否被照亮（蓝色方框）
//。该单元格被照亮，所以 ans[0] = 1 。然后，关闭红色方框中的所有灯。
//
//第 1 次查询检查 grid[1][0] 是否被照亮（蓝色方框）。该单元格没有被照亮，所以 ans[1] = 0 。然后，关闭红色矩形中的所有灯。
//
// 
//
// 示例 2： 
//
// 
//输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
//输出：[1,1]
// 
//
// 示例 3： 
//
// 
//输入：n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
//输出：[1,1,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 0 <= lamps.length <= 20000 
// 0 <= queries.length <= 20000 
// lamps[i].length == 2 
// 0 <= rowi, coli < n 
// queries[j].length == 2 
// 0 <= rowj, colj < n 
// 
// Related Topics 数组 哈希表 👍 66 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class GridIllumination {
    public static void main(String[] args) {
        Solution solution = new GridIllumination().new Solution();
        //5
        //[[0,0],[4,4]]
        //[[1,1],[1,0]]
        int[][] lamps = {{0, 0}, {0, 4}};
        int[][] queries = {{0, 4}, {0, 1}, {1, 4}};
        solution.gridIllumination(5, lamps, queries);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
            // 使用4个map存储 行、列、正对角、反对角 的照明情况
            HashMap<Integer, Integer> row = new HashMap<>();
            HashMap<Integer, Integer> col = new HashMap<>();
            HashMap<Integer, Integer> diagonal = new HashMap<>();
            HashMap<Integer, Integer> antiDiagonal = new HashMap<>();

            // 使用一个set存储灯的灯的情况
            HashSet<Long> lights = new HashSet<>();

            // 遍历 lamps 存储灯，并且计算照亮的行、列、正对角、反对角
            for (int[] lamp : lamps) {
                // 因为 lamps 可能会有重复
                if (lights.add(hash(lamp[0], lamp[1]))) {
                    // 记录照亮的 行、列、正对角、反对角
                    row.put(lamp[0], row.getOrDefault(lamp[0], 0) + 1);
                    col.put(lamp[1], col.getOrDefault(lamp[1], 0) + 1);
                    // 正对角  y = kx + b , x = 1 ,所以 b = y-x
                    diagonal.put(lamp[1] - lamp[0], diagonal.getOrDefault(lamp[1] - lamp[0], 0) + 1);
                    antiDiagonal.put(lamp[1] + lamp[0], antiDiagonal.getOrDefault(lamp[1] + lamp[0], 0) + 1);
                }
            }

            int[] result = new int[queries.length];
            int index = 0;
            // 遍历 queries 查看照亮情况
            for (int[] query : queries) {
                int i = query[0], j = query[1];
                if (row.getOrDefault(i, 0) > 0 || col.getOrDefault(j, 0) > 0
                        || diagonal.getOrDefault(j - i, 0) > 0 || antiDiagonal.getOrDefault(j + i, 0) > 0) {
                    result[index] = 1;
                }

                // 处理照亮的位置
                for (int i1 = i - 1; i1 <= i + 1; i1++) {
                    for (int j1 = j - 1; j1 <= j + 1; j1++) {
                        if (i1 < 0 || i1 >= n || j1 < 0 || j1 >= n) {
                            continue;
                        }
                        // 删除灯，能删除就是能关掉，说明该位置有灯，就要处理照亮的部分
                        if (lights.remove(hash(i1, j1))) {
                            // 处理照亮的部分
                            int countRow = row.get(i1) - 1;
                            if (countRow > 0) {
                                row.put(i1, countRow);
                            } else {
                                row.remove(i1);
                            }

                            int countCol = col.get(j1) - 1;
                            if (countCol > 0) {
                                col.put(j1, countCol);
                            } else {
                                col.remove(j1);
                            }

                            int countDiagonal = diagonal.get(j1 - i1) - 1;
                            if (countDiagonal > 0) {
                                diagonal.put(j1 - i1, countDiagonal);
                            } else {
                                diagonal.remove(j1 - i1);
                            }

                            int countAntiDiagonal = antiDiagonal.get(j1 + i1) - 1;
                            if (countAntiDiagonal > 0) {
                                antiDiagonal.put(j1 + i1, countAntiDiagonal);
                            } else {
                                antiDiagonal.remove(j1 + i1);
                            }
                        }
                    }
                }

                index++;
            }

            return result;
        }


        public long hash(int i, int j) {
            return (long) i + ((long) j << 32);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}