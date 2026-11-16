package parallelcoursesii

// Time:  O((n * C(c, min(c, k))) * 2^n)
// Space: O(2^n)

// concise dp solution
class Solution {
    fun minNumberOfSemesters(n: Int, dependencies: Array<IntArray>, k: Int): Int {
        val reqs = IntArray(n)
        for (d in dependencies) {
            reqs[d[1] - 1] = reqs[d[1] - 1] or (1 shl (d[0] - 1))
        }
        val dp = IntArray(1 shl n) { n }
        dp[0] = 0
        for (mask in dp.indices) {
            val candidates = ArrayList<Int>()
            for (v in 0 until n) {
                if ((mask and (1 shl v)) == 0 && (mask and reqs[v]) == reqs[v]) {
                    candidates.add(v)
                }
            }
            combinations(candidates.size, minOf(candidates.size, k)) { idxs ->
                var newMask = mask
                for (b in idxs) {
                    newMask = newMask or (1 shl candidates[b])
                }
                dp[newMask] = minOf(dp[newMask], dp[mask] + 1)
            }
        }
        return dp.last()
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
                return
            }
            ++idxs[i]
            for (j in i + 1 until k) {
                idxs[j] = idxs[j - 1] + 1
            }
            callback(idxs)
        }
    }
}
