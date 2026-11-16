package movementofrobots

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun sumDistance(nums: IntArray, s: String, d: Int): Int {
        val mod = 1_000_000_007L

        for (i in nums.indices) {
            nums[i] += if (s[i] == 'R') d else -d
        }
        nums.sort()
        var result = 0L
        for (i in nums.indices) {
            result = ((result + (i - (nums.size - (i + 1))).toLong() * nums[i]) % mod + mod) % mod
        }
        return result.toInt()
    }
}
