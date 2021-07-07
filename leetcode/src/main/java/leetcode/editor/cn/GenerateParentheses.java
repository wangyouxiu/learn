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

        /**
         * 回溯法
         * 回溯法在根本上也是一种穷举，只是在穷举的过程中，只选择有可能的结果。因此比穷举效率高。
         * 对于回溯法来讲 backtrack 方法本身可以完成某个位置之后的穷举。
         * 而对于当前位置来讲，做出自己的选择，之后交给该方法。需要注意的是在 backtrack 完成之后，要清除自己的选择。
         * @param n
         * @return
         */
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result, new StringBuilder(), 0, 0, n);
            return result;
        }

        public void backtrack(List<String> result, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == 2 * max) {
                result.add(cur.toString());
            }
            if (open < max) {
                cur.append('(');
                backtrack(result, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() -1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(result, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }

        }


        /**
         * 穷举，在穷举过程中校验是否否和要求，符合要求则加入结果集中，否则丢弃
         * 穷举的核心是，在每个选择的节点上，都有'(' ')'两种选择。而穷举就是要走遍每一种选择
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