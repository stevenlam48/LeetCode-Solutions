package minimumnumberofoperationstomakeallarrayelementsequalto1

// Time:  O(n^2)
// Space: O(1)

// math, number theory, constructive algorithms
class Solution {
    fun minOperations(nums: IntArray): Int {
        val inf = Int.MAX_VALUE

        var cnt = 0
        for (x in nums) {
            if (x == 1) {
                ++cnt
            }
        }
        if (cnt > 0) {
            return nums.size - cnt
        }
        var result = inf
        for (i in nums.indices) {
            var g = nums[i]
            for (j in i + 1 until nums.size) {
                g = gcd(g, nums[j])
                if (g == 1) {
                    result = minOf(result, j - i)
                    break
                }
            }
        }
        return if (result != inf) result + (nums.size - 1) else -1
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = Math.abs(a)
        var y = Math.abs(b)
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }
}
