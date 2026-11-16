package minimumcosttoequalizearray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minCostToEqualizeArray(nums: IntArray, cost1: Int, cost2: Int): Int {
        val mod = 1_000_000_007
        val n = nums.size
        val mx = nums.max().toLong()
        val mn = nums.min().toLong()
        var total = mx * n - nums.sumOf { it.toLong() }
        if (n <= 2 || 2 * cost1 <= cost2) {
            return (total * cost1 % mod).toInt()
        }

        var result = Long.MAX_VALUE
        var cnt1 = maxOf((mx - mn) - (total - (mx - mn)), 0L)
        var cnt2 = total - cnt1
        result = minOf(result, (cnt1 + cnt2 % 2) * cost1 + cnt2 / 2 * cost2)

        val x = cnt1 / (n - 2)
        cnt1 %= n - 2
        total += n * x
        cnt2 = total - cnt1
        result = minOf(result, (cnt1 + cnt2 % 2) * cost1 + cnt2 / 2 * cost2)

        repeat(2) {
            total += n
            result = minOf(result, total % 2 * cost1 + total / 2 * cost2)
        }
        return (result % mod).toInt()
    }
}
