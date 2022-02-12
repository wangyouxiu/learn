//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 470 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        solution.isPalindrome("Zeus was deified, saw Suez.");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
// 生成新的字符串，然后反转比较即可
            int n = s.length();
            StringBuilder sb = new StringBuilder();

            //
            char[] a = {'a'};
            
            //

            for(int i = 0 ; i < n ; i++){
                if(Character.isLetterOrDigit(s.charAt(i))){
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
            }
            String s1 = sb.toString();
            String s2 = sb.reverse().toString();

            return s1.equals(s2);


            // 直接在原字符串判断
            // int i = 0 , j = s.length()-1;
            // while(i<j){
            //     while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
            //         i++;
            //     }
            //     while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
            //         j--;
            //     }
            //     if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
            //         return false;
            //     }
            //     i++;
            //     j--;
            // }

            // return true;



            // 生成新的字符串，再进行判断
            // StringBuilder sb = new StringBuilder();
            // for(int i = 0 ; i < s.length() ;i++){
            //     if(Character.isLetterOrDigit(s.charAt(i))){
            //         sb.append(Character.toLowerCase(s.charAt(i)));
            //     }
            // }
            // int i ,j;
            // if(sb.length() %2 ==0){
            //     i = sb.length()/2 - 1;
            //     j = sb.length()/2;
            // }else{
            //     i = sb.length()/2 - 1;
            //     j = sb.length()/2 + 1;
            // }
            // while(i >= 0 && j < sb.length() ){
            //     if(sb.charAt(i) != sb.charAt(j)){
            //         break;
            //     }
            //     i--;
            //     j++;
            // }

            // if(i < 0 && j >= sb.length()){
            //     return true;
            // }

            // return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}