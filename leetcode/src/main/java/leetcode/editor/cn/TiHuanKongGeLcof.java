//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 122 👎 0

  
package leetcode.editor.cn;
public class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        String s = solution.replaceSpace("We are happy.");
        System.out.print(s);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            char[] chars = new char[s.length()*3];
            char[] charsS = s.toCharArray();
            int j = 0;
            for(int i = 0 ;i< charsS.length;i++){
                if (charsS[i] == ' '){
                    chars[j++] = '%';
                    chars[j++] = '2';
                    chars[j++] = '0';
                }else{
                    chars[j++] = charsS[i];
                }
            }
            return new String(chars, 0, j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}