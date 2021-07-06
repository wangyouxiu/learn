//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1864 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();

            return result;
        }


        /**
         * 穷举，在穷举过程中校验是否否和要求，符合要求则加入结果集中，否则丢弃
         * @param n
         * @return
         */
        /*public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            buildAll(result, new char[2 * n], 0);
            return result;
        }

        public void buildAll(List<String> result, char[] cur, int i) {
            if (i == cur.length) {
                if (check(cur)) {
                    result.add(new String(cur));
                }
            } else {
                cur[i] = '(';
                buildAll(result, cur, i + 1);
                cur[i] = ')';
                buildAll(result, cur, i + 1);
            }
        }

        public boolean check(char[] cur) {
            int count = 0;
            for (char c : cur) {
                if (c == '(') {
                    count++;
                }else {
                    count--;
                }
                if (count < 0) {
                    return false;
                }
            }
            return count == 0;
        }*/


    }
//leetcode submit region end(Prohibit modification and deletion)

}