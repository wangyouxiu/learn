////给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
////
//// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
////
//// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
////输出：3
////解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
//// 
////
//// 示例 2： 
////
//// 
////输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
////输出：0
////解释：所有 1 都在边界上或可以到达边界。
//// 
////
//// 
////
//// 提示： 
////
//// 
//// m == grid.length 
//// n == grid[i].length 
//// 1 <= m, n <= 500 
//// grid[i][j] 的值为 0 或 1 
//// 
//// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 113 👎 0
//


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
        solution.numEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // bfs 方法
         int[] dx = {0,1,0,-1};
         int[] dy = {1,0,-1,0};

        boolean[][] visited;
        int n , m;
        Queue<int[]> queue = new ArrayDeque();
        public int numEnclaves(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            visited = new boolean[n][m];

            for(int i = 0 ; i< n ;i++){
                if(grid[i][0] == 1){
                    visited[i][0] = true;
                    queue.offer(new int[]{i,0});
                }
                if(grid[i][m-1] == 1){
                    visited[i][m-1] = true;
                    queue.offer(new int[]{i,m-1});
                }
            }

            for(int j = 1 ; j < m-1 ;j++){
                if(grid[0][j] == 1){
                    visited[0][j] = true;
                    queue.offer(new int[]{0,j});
                }
                if(grid[n-1][j] == 1){
                    visited[n-1][j] = true;
                    queue.offer(new int[]{n-1,j});
                }
            }

            while(!queue.isEmpty()){
                int[] curr = queue.poll();
                for(int k = 0 ; k < 4 ;k++){
                    int tx = curr[0] + dx[k];
                    int ty = curr[1] + dy[k];
                    if(tx >= 0 && tx < n && ty >= 0 && ty < m && grid[tx][ty] == 1 && !visited[tx][ty]){
                        visited[tx][ty] = true;
                        queue.offer(new int[]{tx,ty});
                    }
                }
            }

            int ans = 0;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(grid[i][j] == 1 && !visited[i][j]){
                        ans++;
                    }
                }
            }
            return ans;
        }

        // dfs 方法
        // static int[] dx = {0,1,0,-1};
        // static int[] dy = {1,0,-1,0};

        // boolean[][] visited;
        // int n , m;



        // public int numEnclaves(int[][] grid) {
        //     n = grid.length;
        //     m = grid[0].length;
        //     visited = new boolean[n][m];

        //     for(int i = 0 ; i < n ; i++){
        //         dfs(i,0,grid);
        //         dfs(i,m-1,grid);
        //     }

        //     for(int j = 1 ; j < m-1 ; j++){
        //         dfs(0,j,grid);
        //         dfs(n-1,j,grid);
        //     }

        //     int count = 0;
        //     for(int i = 0 ; i < n ; i++){
        //         for(int j = 0 ; j < m ;j++){
        //             if(grid[i][j] == 1 && !visited[i][j]){
        //                 count++;
        //             }
        //         }
        //     }
        //     return count;
        // }

        // public void dfs(int i , int j , int[][] grid){
        //     if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || visited[i][j]){
        //         return;
        //     }

        //     visited[i][j] = true;

        //     for(int k = 0 ; k < 4 ;k++){
        //         dfs( i+dx[k] , j+dy[k] , grid);
        //     }
        // }
    }
//leetcode submit region end(Prohibit modification and deletion)

}