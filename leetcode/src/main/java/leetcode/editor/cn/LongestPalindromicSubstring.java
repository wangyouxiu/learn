    //给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3794 👎 0

  
package leetcode.editor.cn;

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划
        //dp[i][i] = true
        //dp[i][i+1] = s.charAt(i) == s.charAt(i+1)
        //dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j)
//        public String longestPalindrome(String s) {
//            int len = s.length();
//            //长度为1，一定是回文串
//            if (len < 2) {
//                return s;
//            }
//
//            boolean[][] dp = new boolean[len][len];
//
//            //初始化dp数组，任何一个字符都是回文串
//            for (int i = 0; i < len; i++) {
//                dp[i][i] = true;
//            }
//
//            int maxLength = 1;
//            int begin = 0;
//            //枚举长度
//            for (int L = 2; L <= len; L++) {
//                //从左边界算起
//                for (int l = 0; l < len; l++) {
//                    //根据左边界和长度L计算有边界
//                    int r = l + L - 1;
//
//                    //右边界可能超出限制
//                    if (r >= len) {
//                        break;
//                    }
//
//                    //当l位置和r位置相等时，才可能是一个回文串
//                    if (s.charAt(l) != s.charAt(r)) {
//                        dp[l][r] = false;
//                    } else {
//                        //l位置和r位置相等还不够，还要判断dp[l+1][r-1]是否是回文串
//                        if (r - l < 3) {
//                            //也就是中间只有一个数，一个数必定是回文串
//                            //或者一共是2个数，外面已经判断过l位置和r位置相等，因此一定是true
//                            dp[l][r] = true;
//                        } else {
//                            dp[l][r] = dp[l + 1][r - 1];
//                        }
//                    }
//
//                    //做记录，如果是回文串，并且长度大于最大长度，就要记录下来
//                    if (dp[l][r] && L > maxLength) {
//                        maxLength = L;
//                        begin = l;
//                    }
//
//                }
//            }
//
//            return s.substring(begin, begin + maxLength);
//        }


        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0 ,end = 0;

            for (int i = 0; i < s.length(); i++) {
                //以i位置为中心，尽可能的像两端扩展
                int len1 = expand(s, i, i);
                int len2 = expand(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        public int expand(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return r - l - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}