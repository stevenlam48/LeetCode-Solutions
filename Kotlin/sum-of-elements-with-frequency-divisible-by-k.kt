package sumofelementswithfrequencydivisiblebyk

// Time:  O(n + r)
// Space: O(r)

// freq table
class Solution {
    fun sumDivisibleByK(nums: IntArray, k: Int): Int {
        val mx = nums.maxOrNull() ?: 0
        val cnt = IntArray(mx + 1)
        for (x in nums) {
            ++cnt[x]
        }
        var result = 0
        for (x in nums) {
            result += if (cnt[x] % k == 0) x else 0
        }
        return result
    }
}
