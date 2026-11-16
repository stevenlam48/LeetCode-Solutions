package numberofwaystobuildsturdybrickwall

// Time:  O(h * p^2), p is the number of patterns
// Space: O(p^2)

class Solution {
    fun buildWall(height: Int, width: Int, bricks: IntArray): Int {
        val MOD = 1_000_000_007
        val patterns = ArrayList<Int>()
        val lookup = HashSet<Int>()
        backtracking(width, bricks, 0, 0, lookup, patterns)
        val adj = Array(patterns.size) { mutableListOf<Int>() }
        for (i in patterns.indices) {
            for (j in patterns.indices) {
                if ((patterns[i] and patterns[j]) == 0) {
                    adj[i].add(j)
                }
            }
        }
        val dp = arrayOf(IntArray(patterns.size) { 1 }, IntArray(patterns.size))
        for (i in 0 until height) {
            for (j in patterns.indices) {
                dp[(i + 1) % 2][j] = 0
                for (k in adj[j]) {
                    dp[(i + 1) % 2][j] = ((dp[(i + 1) % 2][j].toLong() + dp[i % 2][k]) % MOD).toInt()
                }
            }
        }
        var total = 0L
        for (x in dp[(height - 1) % 2]) {
            total = (total + x) % MOD
        }
        return total.toInt()
    }

    private fun backtracking(width: Int, bricks: IntArray, total: Int, mask: Int, lookup: HashSet<Int>, patterns: MutableList<Int>) {
        if (!lookup.add(mask)) {
            return
        }
        if (total >= width) {
            if (total == width) {
                patterns.add(mask xor (1 shl width))
            }
            return
        }
        for (x in bricks) {
            backtracking(width, bricks, total + x, mask or (1 shl (total + x)), lookup, patterns)
        }
    }
}
