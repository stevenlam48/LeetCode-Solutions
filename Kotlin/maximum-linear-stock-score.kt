package maximumlinearstockscore

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxScore(prices: IntArray): Long {
        val scores = HashMap<Int, Long>()
        for (i in prices.indices) {
            val key = prices[i] - i
            scores[key] = (scores[key] ?: 0L) + prices[i]
        }
        return scores.values.maxOrNull() ?: 0L
    }
}
