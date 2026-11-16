package maximumvalueofkcoinsfrompiles

// Time:  O(min(n * k^2, m * k)), m = sum(len(pile) for pile in piles)
// Space: O(k)

class Solution {
    fun maxValueOfCoins(piles: Array<IntArray>, k: Int): Int {
        var dp = IntArray(1)
        for (pile in piles) {
            val newDp = IntArray(minOf(dp.size + pile.size, k + 1))
            for (i in dp.indices) {
                var j = 0
                var curr = 0
                while (j <= minOf(k - i, pile.size)) {
                    newDp[i + j] = maxOf(newDp[i + j], dp[i] + curr)
                    curr += if (j < pile.size) pile[j] else 0
                    j++
                }
            }
            dp = newDp
        }
        return dp.last()
    }
}
