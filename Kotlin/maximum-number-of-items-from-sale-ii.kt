package maximumnumberofitemsfromsaleii
// Time:  O(rlogr + nlogn) = O(nlogn), r = max(f for f, _ in items) <= n
// Space: O(r + n) = O(n)

import java.util.TreeMap

class Solution {
    fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
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
        var minP = Int.MAX_VALUE
        for (x in items) {
            minP = minOf(minP, x[1])
        }
        val group = TreeMap<Int, Long>()
        for (x in items) {
            if (x[1] >= 2 * minP) {
                continue
            }
            group[x[1]] = group.getOrDefault(x[1], 0L) + total[x[0]] - 1
        }
        var result = 0
        var remainingBudget = budget
        for ((p, x) in group) {
            val c = minOf(remainingBudget.toLong() / p, x)
            result += (2 * c).toInt()
            remainingBudget -= (c * p).toInt()
            if (remainingBudget < p) {
                break
            }
        }
        result += remainingBudget / minP
        return result
    }
}
