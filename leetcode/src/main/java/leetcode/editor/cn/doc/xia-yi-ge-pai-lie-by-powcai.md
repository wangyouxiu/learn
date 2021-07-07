## 思路：

这道题是根据 [维基百科](https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order) ,下图所示:



![1556953035922.png](https://pic.leetcode-cn.com/4169e8e0c8b4d71d4d32b4f50b09a57c0ea951cb4bdbd16a785d5847959e261f-1556953035922.png)

**翻译过来：**

1. 先找出最大的索引 `k` 满足 `nums[k] < nums[k+1]`，如果不存在，就翻转整个数组；
2. 再找出另一个最大索引 `l` 满足 `nums[l] > nums[k]`；
3. 交换 `nums[l]` 和 `nums[k]`；
4. 最后翻转 `nums[k+1:]`。

**举个例子：**

比如 `nums = [1,2,7,4,3,1]`，下一个排列是什么？

我们找到第一个最大索引是 `nums[1] = 2`

再找到第二个最大索引是 `nums[4] = 3`

交换，`nums = [1,3,7,4,2,1]`;

翻转，`nums = [1,3,1,2,4,7]`

完毕!

所以,

时间复杂度：*O(n)*

空间复杂度：*O(1)*

------


## 代码：
```Python []
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        firstIndex = -1
        n = len(nums)
        def reverse(nums, i, j):
            while i < j:
                nums[i],nums[j] = nums[j], nums[i]
                i += 1
                j -= 1
        for i in range(n-2, -1, -1):
            if nums[i] < nums[i+1]:
                firstIndex = i
                break
        #print(firstIndex)
        if firstIndex == -1:
            reverse(nums, 0, n-1)
            return 
        secondIndex = -1
        for i in range(n-1, firstIndex, -1):
            if nums[i] > nums[firstIndex]:
                secondIndex = i
                break
        nums[firstIndex],nums[secondIndex] = nums[secondIndex], nums[firstIndex]
        reverse(nums, firstIndex+1, n-1)
```
```Java []
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int firstIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int secondIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1, nums.length - 1);
        return;

    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
```

 