package countnicepairsinanarray

// Time:  O(nlogm), m is max of nums
// Space: O(n)

class Solution {
    fun countNicePairs(nums: IntArray): Int {
        val MOD = 1_000_000_007
        val lookup = HashMap<Int, Int>()
        var result = 0
        for (i in nums) {
            val key = i - rev(i)
            val v = lookup.getOrDefault(key, 0)
            result = (result + v) % MOD
            lookup[key] = v + 1
        }
        return result
    }

    private fun rev(i0: Int): Int {
        var i = i0
        var result = 0
        while (i != 0) {
            result = result * 10 + i % 10
            i /= 10
        }
        return result
    }
}
