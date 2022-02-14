//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 你可以删除c字符。
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 贪心 双指针 字符串 👍 449 👎 0


package leetcode.editor.cn;

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            char[] ch = s.toCharArray();
            int low = 0, high = ch.length - 1;
            while (low < high) {
                if (ch[low] != ch[high]) {
                    if (isPalindrome(ch, low + 1, high) || isPalindrome(ch, low, high - 1)) {
                        return true;
                    }else{
                        return false;
                    }
                }
                low++;
                high--;
            }
            return true;
        }

        public boolean isPalindrome(char[] ch, int low, int high) {
            while (low < high) {
                if (ch[low] != ch[high]) {
                    break;
                }
                low++;
                high--;
            }
            return low >= high;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}