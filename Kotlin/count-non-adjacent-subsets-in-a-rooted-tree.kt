package countnonadjacentsubsetsinarootedtree

// Time:  O(n * k^2)
// Space: O(n * k)

// topological sort, tree dp
class Solution {
    fun countValidSubsets(parent: IntArray, nums: IntArray, k: Int): Int {
        val MOD = 1_000_000_007
        val n = nums.size
        val adj = Array(n) { mutableListOf<Int>() }
        for (v in 1 until parent.size) {
            adj[parent[v]].add(v)
        }
        val dp = Array(n) { Array(2) { IntArray(k) } }
        for (u in n - 1 downTo 0) {
            val newDp = Array(2) { IntArray(k) }
            newDp[0][0] = 1
            newDp[1][nums[u] % k] = 1
            for (v in adj[u]) {
                val dp2 = IntArray(k)
                for (i in 0 until k) {
                    dp2[i] = (dp[v][0][i] + dp[v][1][i]) % MOD
                }
                newDp[0] = merge(newDp[0], dp2, k, MOD)
                newDp[1] = merge(newDp[1], dp[v][0], k, MOD)
            }
            dp[u] = newDp
        }
        return (((dp[0][0][0] + dp[0][1][0] - 1L) % MOD + MOD) % MOD).toInt()
    }

    private fun merge(a: IntArray, b: IntArray, k: Int, mod: Int): IntArray {
        val result = IntArray(a.size)
        for (i in 0 until k) {
            if (a[i] == 0) {
                continue
            }
            for (j in 0 until k) {
                if (b[j] == 0) {
                    continue
                }
                result[(i + j) % k] = ((result[(i + j) % k] + a[i].toLong() * b[j]) % mod).toInt()
            }
        }
        return result
    }
}
