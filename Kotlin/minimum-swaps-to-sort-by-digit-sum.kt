package minimumswapstosortbydigitsum

// Time:  O(nlogr + nlogn)
// Space: O(n)

class Solution {
    fun minSwaps(nums: IntArray): Int {
        fun digitSum(x0: Int): Int {
            var x = x0
            var result = 0
            while (x != 0) {
                result += x % 10
                x /= 10
            }
            return result
        }

        val n = nums.size
        val totals = IntArray(n) { digitSum(nums[it]) }
        val idxs = (0 until n).sortedWith(compareBy({ totals[it] }, { nums[it] }))
        val iToIdx = IntArray(n) { -1 }
        for (i in idxs.indices) {
            iToIdx[idxs[i]] = i
        }
        var result = 0
        val lookup = BooleanArray(n)
        for (start in 0 until n) {
            var i = start
            var l = 0
            while (!lookup[i]) {
                lookup[i] = true
                ++l
                i = iToIdx[i]
            }
            result += maxOf(l - 1, 0)
        }
        return result
    }
}
