package findallgoodstrings

// Time:  O(m * n)
// Space: O(m)

class Solution {
    fun findGoodStrings(n: Int, s1: String, s2: String, evil: String): Int {
        val prefix = getPrefix(evil)
        val m = evil.length
        var dp = Array(2) { Array(2) { IntArray(m) } }
        dp[0][0][0] = 1
        for (i in 0 until n) {
            val next = Array(2) { Array(2) { IntArray(m) } }
            for (j in 0..1) {
                for (k in 0..1) {
                    val minC = if (j != 0) 'a' else s1[i]
                    val maxC = if (k != 0) 'z' else s2[i]
                    for (l in 0 until m) {
                        if (dp[j][k][l] == 0) {
                            continue
                        }
                        var c = minC
                        while (c <= maxC) {
                            var mm = l - 1
                            while (mm != -1 && evil[mm + 1] != c) {
                                mm = prefix[mm]
                            }
                            if (evil[mm + 1] == c) {
                                ++mm
                            }
                            if (mm + 1 == m) {
                                ++c
                                continue
                            }
                            val nj = if (j != 0 || c != s1[i]) 1 else 0
                            val nk = if (k != 0 || c != s2[i]) 1 else 0
                            add(next[nj][nk], mm + 1, dp[j][k][l])
                            ++c
                        }
                    }
                }
            }
            dp = next
        }
        var result = 0
        for (j in 0..1) {
            for (k in 0..1) {
                for (l in 0 until m) {
                    result = addTo(result, dp[j][k][l])
                }
            }
        }
        return result
    }

    private fun getPrefix(pattern: String): IntArray {
        val prefix = IntArray(pattern.length) { -1 }
        var j = -1
        for (i in 1 until pattern.length) {
            while (j != -1 && pattern[j + 1] != pattern[i]) {
                j = prefix[j]
            }
            if (pattern[j + 1] == pattern[i]) {
                ++j
            }
            prefix[i] = j
        }
        return prefix
    }

    private fun add(arr: IntArray, idx: Int, y: Int) {
        arr[idx] = ((arr[idx].toLong() + y) % MOD).toInt()
    }

    private fun addTo(x: Int, y: Int): Int {
        return ((x.toLong() + y) % MOD).toInt()
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}
