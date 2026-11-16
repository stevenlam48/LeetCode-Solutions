package maximumsumcircularsubarray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxSubarraySumCircular(A: IntArray): Int {
        var total = 0
        var maxSum = Int.MIN_VALUE
        var curMax = 0
        var minSum = Int.MAX_VALUE
        var curMin = 0
        for (a in A) {
            curMax = maxOf(curMax + a, a)
            maxSum = maxOf(maxSum, curMax)
            curMin = minOf(curMin + a, a)
            minSum = minOf(minSum, curMin)
            total += a
        }
        return if (maxSum >= 0) maxOf(maxSum, total - minSum) else maxSum
    }
}
