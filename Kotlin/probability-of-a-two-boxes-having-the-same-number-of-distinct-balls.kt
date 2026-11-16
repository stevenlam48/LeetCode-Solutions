package probabilityofatwoboxeshavingthesamenumberofdistinctballs

// Time:  O(k^3 * n^2)
// Space: O(k^2 * n)

class Solution {
    fun getProbability(balls: IntArray): Double {
        var dp = hashMapOf(Pair(0, 0) to 1L)
        for (n in balls) {
            val newDp = hashMapOf<Pair<Int, Int>, Long>()
            for ((key, count) in dp) {
                val (ndiff, cdiff) = key
                var newCount = 1L
                for (k in 0..n) {
                    if (k > 0) {
                        newCount *= (n - k + 1).toLong()
                        newCount /= k
                    }
                    val newNdiff = ndiff + k - (n - k)
                    val newCdiff = when {
                        k == 0 -> cdiff - 1
                        k == n -> cdiff + 1
                        else -> cdiff
                    }
                    val newKey = Pair(newNdiff, newCdiff)
                    newDp[newKey] = (newDp[newKey] ?: 0L) + count * newCount
                }
            }
            dp = newDp
        }
        val total = balls.sum()
        return dp.getValue(Pair(0, 0)).toDouble() / nCr(total, total / 2)
    }

    private fun nCr(n: Int, r: Int): Long {
        if (n - r < r) {
            return nCr(n, n - r)
        }
        var c = 1L
        for (k in 1..r) {
            c *= (n - k + 1).toLong()
            c /= k
        }
        return c
    }
}
