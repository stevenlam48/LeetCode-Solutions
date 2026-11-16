package delayedcountofequalelements

// Time:  O(n)
// Space: O(n)
class Solution {
    fun delayedCount(nums: IntArray, k: Int): IntArray {
        val result = IntArray(nums.size)
        val cnt = HashMap<Int, Int>()
        for (i in nums.size - 1 - k downTo 0) {
            result[i] = cnt[nums[i]] ?: 0
            cnt[nums[i + k]] = (cnt[nums[i + k]] ?: 0) + 1
        }
        return result
    }
}
