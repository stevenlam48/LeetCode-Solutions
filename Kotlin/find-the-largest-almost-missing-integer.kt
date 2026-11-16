package findthelargestalmostmissinginteger

// Time:  O(n)
// Space: O(n)

class Solution {
    fun largestInteger(nums: IntArray, k: Int): Int {
        if (k == nums.size) {
            return nums.max()
        }
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        var result = -1
        if (k == 1) {
            for ((x, v) in cnt) {
                if (v == 1) {
                    result = maxOf(result, x)
                }
            }
            return result
        }
        if (cnt[nums[0]] == 1) {
            result = maxOf(result, nums[0])
        }
        if (cnt[nums[nums.size - 1]] == 1) {
            result = maxOf(result, nums[nums.size - 1])
        }
        return result
    }
}
