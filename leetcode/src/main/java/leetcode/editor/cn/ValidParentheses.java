//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2483 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("(])");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            int len = s.length();
            if (len % 2 != 0) {
                return false;
            }

            Stack<Character> chars = new Stack<>();
            HashMap<Character, Character> charMap = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};

            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (charMap.containsKey(c)) {
                    if (chars.isEmpty() || !chars.peek().equals(charMap.get(c))) {
                        return false;
                    }
                    chars.pop();
                } else {
                    chars.push(c);
                }
            }
            return chars.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}