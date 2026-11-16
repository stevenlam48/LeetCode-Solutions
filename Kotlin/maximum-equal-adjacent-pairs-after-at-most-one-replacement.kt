package maximumequaladjacentpairsafteratmostonereplacement

// Time:  O(n)
// Space: O(n)

// freq table
class Solution {
    fun maxEqualAdjacentPairs(nums: IntArray): Int {
        var result = 0
        val cnt = HashMap<Pair<Int, Int>, Int>()
        for (i in 0 until nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                ++result
            } else {
                val key = minOf(nums[i], nums[i + 1]) to maxOf(nums[i], nums[i + 1])
                cnt[key] = (cnt[key] ?: 0) + 1
            }
        }
        if (cnt.isNotEmpty()) {
            result += cnt.values.maxOrNull()!!
        }
        return result
    }
}
