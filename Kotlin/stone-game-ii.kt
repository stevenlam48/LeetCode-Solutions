package stonegameii

// Time:  O(n*(logn)^2)
// Space: O(nlogn)

class Solution {
    fun stoneGameII(piles: IntArray): Int {
        for (i in piles.size - 2 downTo 0) {
            piles[i] += piles[i + 1]
        }
        val lookup = HashMap<Int, HashMap<Int, Int>>()
        return dp(piles, lookup, 0, 1)
    }

    private fun dp(piles: IntArray, lookup: HashMap<Int, HashMap<Int, Int>>, i: Int, m: Int): Int {
        if (i + 2 * m >= piles.size) {
            return piles[i]
        }
        val inner = lookup[i]
        if (inner == null || !inner.containsKey(m)) {
            var minDp = Int.MAX_VALUE
            for (x in 1..2 * m) {
                minDp = minOf(minDp, dp(piles, lookup, i + x, maxOf(m, x)))
            }
            lookup.getOrPut(i) { HashMap() }[m] = piles[i] - minDp
        }
        return lookup[i]!![m]!!
    }
}
