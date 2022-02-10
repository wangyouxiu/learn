//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 👍 198 👎 0


package leetcode.editor.cn;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new KeyboardRow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            char[] one = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
            char[] two = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
            char[] three = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < one.length; i++) {
                map.put(one[i], 1);
            }
            for (int i = 0; i < two.length; i++) {
                map.put(two[i], 2);
            }
            for (int i = 0; i < three.length; i++) {
                map.put(three[i], 3);
            }

            List<String> result = new ArrayList<>();
            for (String word : words) {
                char[] chars = word.toCharArray();
                int pre = 0, i = 0;
                for (; i < chars.length; i++) {
                    // 大写转小写
                    if (chars[i] < 'a') {
                        chars[i] += 32;
                    }
                    if (i == 0) {
                        pre = map.get(chars[i]);
                    } else {
                        if (map.get(chars[i]) != pre) {
                            break;
                        }
                    }

                }
                if (i == chars.length) {
                    result.add(word);
                }
            }
            String[] res = new String[result.size()];
            result.toArray(res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}