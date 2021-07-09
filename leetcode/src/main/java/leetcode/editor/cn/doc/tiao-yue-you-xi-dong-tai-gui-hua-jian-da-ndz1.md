**动态规划**
定义 *dp[i]* 表示从 *0* 出发，经过 *j<=i*，可以跳出的最远距离。
- 初始化: *dp[0]=nums[0]*
- 迭代: 如果能通过前 *i-1* 个位置到达 *i*，即 *dp[i-1]>=i*, 那么 *dp[i]=max(dp[i-1], i+nums[i])*, 否则 *dp[i]=dp[i-1]*
```python3
def canJump(nums):
    dp=[0 for _ in range(len(nums))]
    dp[0]=nums[0]
    for i in range(1,len(nums)):
        if dp[i-1]>=i: dp[i]=max(dp[i-1], i+nums[i])
        else: dp[i]=dp[i-1]
    return dp[-1]>=len(nums)-1
```
由于`dp[i]`只和`dp[i-1]`有关，我们还可以进一步优化空间复杂度。
```python3
def canJump(nums):
    max_len=nums[0]
    for i in range(1,len(nums)):
        if max_len>=i: max_len=max(max_len, i+nums[i])
    return max_len>=len(nums)-1
```
其他感受：
- 个人感觉从动态规划的角度比贪心好理解.
- 还可以优化的点是如果中间*dp[i]*或者*max_len*大于*len(nums)-1*就返回，但是那样每次都要判断，从测试用例上看节省不了多少时间.