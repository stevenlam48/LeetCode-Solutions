package subarraysumequalsk

// Time:  O(n)
// Space: O(n)

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var result = 0
        var accumulatedSum = 0
        val lookup = HashMap<Int, Int>()
        lookup[0] = (lookup[0] ?: 0) + 1
        for (num in nums) {
            accumulatedSum += num
            result += lookup[accumulatedSum - k] ?: 0
            lookup[accumulatedSum] = (lookup[accumulatedSum] ?: 0) + 1
        }
        return result
    }
}
