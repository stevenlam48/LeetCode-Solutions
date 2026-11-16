package binarytreeswithfactors

// Time:  O(n^2)
// Space: O(n)
class Solution {
    fun numFactoredBinaryTrees(a: IntArray): Int {
        val m = 1_000_000_007L
        a.sort()
        val dp = HashMap<Int, Long>()
        for (i in a.indices) {
            dp[a[i]] = 1L
            for (j in 0 until i) {
                if (a[i] % a[j] == 0 && dp.containsKey(a[i] / a[j])) {
                    dp[a[i]] = (dp.getValue(a[i]) + dp.getValue(a[j]) * dp.getValue(a[i] / a[j])) % m
                }
            }
        }
        return (dp.values.fold(0L) { sum, value -> sum + value } % m).toInt()
    }
}
