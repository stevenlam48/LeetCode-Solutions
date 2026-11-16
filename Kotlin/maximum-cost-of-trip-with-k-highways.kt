package maximumcostoftripwithkhighways

// Time:  O(n^2 * 2^n)
// Space: O(n * 2^n)

class Solution {
    fun maximumCost(n: Int, highways: Array<IntArray>, k: Int): Int {
        if (k + 1 > n) {
            return -1
        }
        val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (h in highways) {
            adj[h[0]].add(Pair(h[1], h[2]))
            adj[h[1]].add(Pair(h[0], h[2]))
        }
        val dp = Array(1 shl n) { Pair(0, mutableListOf<Int>()) }
        for (u in 0 until n) {
            dp[1 shl u].second.add(u)
        }
        var result = if (k != 1) -1 else 0
        for (cnt in 1..n) {
            combinations(n, cnt) { idxs ->
                var mask = 0
                for (idx in idxs) {
                    mask = mask or (1 shl idx)
                }
                val (total, lasts) = dp[mask]
                for (u in lasts) {
                    for ((v, t) in adj[u]) {
                        if (mask and (1 shl v) != 0) {
                            continue
                        }
                        val newMask = mask or (1 shl v)
                        if (total + t < dp[newMask].first) {
                            continue
                        }
                        if (total + t == dp[newMask].first) {
                            dp[newMask].second.add(v)
                            continue
                        }
                        dp[newMask] = Pair(total + t, mutableListOf(v))
                        if (Integer.bitCount(mask) == k) {
                            result = maxOf(result, dp[newMask].first)
                        }
                    }
                }
            }
        }
        return result
    }

    private fun combinations(n: Int, k: Int, callback: (IntArray) -> Unit) {
        val idxs = IntArray(k) { it }
        callback(idxs)
        while (true) {
            var i = k - 1
            while (i >= 0 && idxs[i] == i + n - k) {
                --i
            }
            if (i < 0) {
                break
            }
            ++idxs[i]
            for (j in i + 1 until k) {
                idxs[j] = idxs[j - 1] + 1
            }
            callback(idxs)
        }
    }
}
