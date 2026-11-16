package findthemaximumsumofnodevalues

// Time:  O(n)
// Space: O(1)

// greedy
class Solution {
    fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
        var result = 0L
        var diff = Int.MAX_VALUE
        var parity = 0
        for (x in nums) {
            val y = x xor k
            result += maxOf(x, y)
            parity = parity xor (if (x < y) 1 else 0)
            diff = minOf(diff, kotlin.math.abs(x - y))
        }
        return result - parity.toLong() * diff
    }
}
