package powerofheroes
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun sumOfPower(nums: IntArray): Int {
        var result = 0
        var dp = 0
        nums.sort()
        for (value in nums) {
            val x = value.toLong()
            result = (result + (x * x % MOD) * (dp + x) % MOD).toInt()
            dp = (dp + (dp + x) % MOD).toInt()
        }
        return result
    }

    companion object {
        private const val MOD = 1_000_000_007L
    }
}
