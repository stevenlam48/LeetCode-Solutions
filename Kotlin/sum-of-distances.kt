package sumofdistances

// Time:  O(n)
// Space: O(n)

// freq table, prefix sum
class Solution {
    fun distance(nums: IntArray): LongArray {
        val result = LongArray(nums.size)
        val cnt1 = HashMap<Int, Long>()
        val left = HashMap<Int, Long>()
        for (i in nums.indices) {
            result[i] += (cnt1[nums[i]] ?: 0L) * i - (left[nums[i]] ?: 0L)
            cnt1[nums[i]] = (cnt1[nums[i]] ?: 0L) + 1
            left[nums[i]] = (left[nums[i]] ?: 0L) + i
        }
        val cnt2 = HashMap<Int, Long>()
        val right = HashMap<Int, Long>()
        for (i in nums.indices.reversed()) {
            result[i] += (right[nums[i]] ?: 0L) - (cnt2[nums[i]] ?: 0L) * i
            cnt2[nums[i]] = (cnt2[nums[i]] ?: 0L) + 1
            right[nums[i]] = (right[nums[i]] ?: 0L) + i
        }
        return result
    }
}
