package maximumnumberofitemsfromsalei
// Time:  O(rlogr + n * b), r = max(f for f, _ in items)
// Space: O(r + b)

class Solution {
    fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
        val negInf = Int.MIN_VALUE
        var maxF = 0
        for (x in items) {
            maxF = maxOf(maxF, x[0])
        }
        val cnt = IntArray(maxF + 1)
        for (x in items) {
            ++cnt[x[0]]
        }
        val total = IntArray(cnt.size)
        for (i in 1 until cnt.size) {
            if (cnt[i] == 0) {
                continue
            }
            for (j in i until cnt.size step i) {
                total[i] += cnt[j]
            }
        }
        val dp = IntArray(budget + 1) { negInf }
        dp[0] = 0
        for (x in items) {
            for (i in dp.lastIndex downTo x[1]) {
                if (dp[i - x[1]] == negInf) {
                    continue
                }
                dp[i] = maxOf(dp[i], dp[i - x[1]] + total[x[0]])
            }
        }
        var minP = Int.MAX_VALUE
        for (x in items) {
            minP = minOf(minP, x[1])
        }
        var result = 0
        for (i in dp.indices) {
            if (dp[i] == negInf) {
                continue
            }
            result = maxOf(result, dp[i] + (budget - i) / minP)
        }
        return result
    }
}
