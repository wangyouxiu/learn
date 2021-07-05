### 解题思路
   利用数组下标计数实现对目标数组的每个元素的计数，随后在循环一次的循环中查找并添加计数为零的元素即可实现！

### 代码

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
             int[] count=new int[nums.length+1];
             for(int num:nums)
             count[num]++;
             List<Integer> res=new ArrayList<>();
             for(int m=1;m<=nums.length;m++)
             if(count[m]==0)
             res.add(m);
             return res;
    }
}
```