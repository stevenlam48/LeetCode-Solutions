package minimizemaximumpairsuminarray
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()
        var result = 0
        for (i in 0 until nums.size / 2) {
            result = maxOf(result, nums[i] + nums[nums.size - 1 - i])
        }
        return result
    }
}
