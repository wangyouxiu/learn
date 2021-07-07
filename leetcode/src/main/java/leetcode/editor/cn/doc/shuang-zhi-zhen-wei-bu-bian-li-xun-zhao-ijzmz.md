双指针，从尾部开始遍历，寻找第一个下降点nums[left]，
![截图-20210513172526.png](https://pic.leetcode-cn.com/1620897979-eZkRYM-%E6%88%AA%E5%9B%BE-20210513172526.png)
（5 未第一个下降点）
然后在下降点的右侧寻找第一个大于nums[left]的点记为nums[right]，
交换nums[left]和nums[right]，
交换后，对nums[left]点右侧的所有点排序（排为升序），得出结果~

```
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        if (n <= 1) return;
        int right = n - 1;
        int left = right - 1;
            while (left >= 0){
                if (nums[left] < nums[right]){
                    right = n - 1; //当左指针找到下降点，将右指针返回尾部
                    while (nums[right] <= nums[left]){//在下降点的右侧寻找第一个大于nums[left]的点记为nums[right]
                        --right;
                    }
                    swap(nums[left], nums[right]);
                    sort(nums.begin()+left+1, nums.end());
                    return;
                }
                //左右指针同时左移，来检查第一个下降点
                --left;
                --right;
            }
        sort(nums.begin(), nums.end());//若没有下降点，按照提议返回升序序列
        return;
    }
};
```
