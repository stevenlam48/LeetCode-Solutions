package findtheshortestsuperstring

// Time:  O(n^2 * (l^2 + 2^n))
// Space: O(n^2)

class Solution {
    fun shortestSuperstring(A: List<String>): String {
        val n = A.size
        val overlaps = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (l in minOf(A[i].length, A[j].length) downTo 0) {
                    if (A[i].substring(A[i].length - l) == A[j].substring(0, l)) {
                        overlaps[i][j] = l
                        break
                    }
                }
            }
        }

        val dp = Array(1 shl n) { IntArray(n) }
        val prev = Array(1 shl n) { IntArray(n) { -1 } }
        for (mask in 1 until (1 shl n)) {
            for (bit in 0 until n) {
                if (((mask shr bit) and 1) == 0) {
                    continue
                }
                val prevMask = mask xor (1 shl bit)
                for (i in 0 until n) {
                    if (((prevMask shr i) and 1) == 0) {
                        continue
                    }
                    val value = dp[prevMask][i] + overlaps[i][bit]
                    if (value > dp[mask][bit]) {
                        dp[mask][bit] = value
                        prev[mask][bit] = i
                    }
                }
            }
        }

        val full = (1 shl n) - 1
        var bit = -1
        for (i in 0 until n) {
            if (bit == -1 || dp[full][i] > dp[full][bit]) {
                bit = i
            }
        }
        val words = ArrayList<Int>()
        var mask = full
        while (bit != -1) {
            words.add(bit)
            val next = prev[mask][bit]
            mask = mask xor (1 shl bit)
            bit = next
        }
        words.reverse()
        val lookup = words.toHashSet()
        for (i in 0 until n) {
            if (i !in lookup) {
                words.add(i)
            }
        }

        val result = StringBuilder(A[words[0]])
        for (i in 1 until words.size) {
            val overlap = overlaps[words[i - 1]][words[i]]
            result.append(A[words[i]].substring(overlap))
        }
        return result.toString()
    }
}
