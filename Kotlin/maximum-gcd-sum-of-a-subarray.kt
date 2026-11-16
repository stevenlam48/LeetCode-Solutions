package maximumgcdsumofasubarray

// Time:  O(nlogr), r = max(nums)
// Space: O(logr)

// number theory, dp, prefix sum
class Solution {
    fun maxGcdSum(nums: IntArray, k: Int): Long {
        var result = 0L
        var dp = mutableListOf<Triple<Int, Int, Long>>()
        var prefix = 0L
        for (right in nums.indices) {
            dp.add(Triple(right, nums[right], prefix))
            prefix += nums[right]
            val newDp = mutableListOf<Triple<Int, Int, Long>>()
            for ((left, g, p) in dp) {
                val ng = gcd(g, nums[right])
                if (newDp.isEmpty() || newDp.last().second != ng) {
                    newDp.add(Triple(left, ng, p))
                }
            }
            dp = newDp
            for ((left, g, p) in dp) {
                if (right - left + 1 < k) {
                    break
                }
                result = maxOf(result, (prefix - p) * g)
            }
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }
}
