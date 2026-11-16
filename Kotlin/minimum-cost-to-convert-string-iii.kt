package minimumcosttoconvertstringiii
// Time:  O(n * r * l)
// Space: O(min(n, l))

class Solution {
    fun minCost(source: String, target: String, rules: List<List<String>>, costs: IntArray): Int {
        val inf = Int.MAX_VALUE
        var mx = 0
        for (x in rules) {
            mx = maxOf(mx, x[1].length)
        }
        val w = minOf(mx, source.length) + 1
        val dp = IntArray(w) { inf }
        dp[0] = 0
        for (i in source.indices) {
            dp[(i - 1 + w) % w] = inf
            if (dp[i % w] == inf) {
                continue
            }
            if (source[i] == target[i]) {
                dp[(i + 1) % w] = minOf(dp[(i + 1) % w], dp[i % w])
            }
            for (j in rules.indices) {
                if (i + rules[j][0].length > source.length) {
                    continue
                }
                var c = costs[j]
                val p = rules[j][0]
                val r = rules[j][1]
                var ok = true
                for (k in p.indices) {
                    if (r[k] != target[i + k]) {
                        ok = false
                        break
                    }
                    if (p[k] == '*') {
                        ++c
                    } else if (p[k] != source[i + k]) {
                        ok = false
                        break
                    }
                }
                if (ok) {
                    val next = (i + p.length) % w
                    dp[next] = minOf(dp[next], dp[i % w] + c)
                }
            }
        }
        return if (dp[source.length % w] != inf) dp[source.length % w] else -1
    }
}
