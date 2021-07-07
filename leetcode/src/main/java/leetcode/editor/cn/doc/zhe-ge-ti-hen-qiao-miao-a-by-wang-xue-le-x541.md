### 解题思路
1、[1,2,3,6,5,4]下一个排列是[1,2,4,3,5,6]完全题解题意后就好写了
2、从后往前找到不是递增的那个数上述是3，然后再从后往前找到第一个比3大的数，交换这两个数的位置后[1,2,4,6,5,3]
3、已近知道6,5,3从后往前是递增的，所以要逆序一下
4、注意边界判断

### 代码

```java
class Solution {
     public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        revers(nums, i + 1, nums.length - 1);
    }

    private void revers(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```