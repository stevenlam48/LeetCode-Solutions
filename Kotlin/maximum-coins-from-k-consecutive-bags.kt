package maximumcoinsfromkconsecutivebags

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumCoins(coins: Array<IntArray>, k: Int): Long {
        fun maxAmount(): Long {
            var result = 0L
            var curr = 0L
            coins.sortWith(compareBy({ it[0] }, { it[1] }, { it[2] }))
            var left = 0
            for (right in coins.indices) {
                curr += (coins[right][1].toLong() - coins[right][0] + 1) * coins[right][2]
                while (coins[right][1] - coins[left][1] + 1 > k) {
                    curr -= (coins[left][1].toLong() - coins[left][0] + 1) * coins[left][2]
                    ++left
                }
                result = maxOf(
                    result,
                    curr - maxOf((coins[right][1] - coins[left][0] + 1) - k, 0).toLong() * coins[left][2]
                )
            }
            return result
        }

        var result = maxAmount()
        for (i in coins.indices) {
            val a = coins[i][0]
            val b = coins[i][1]
            coins[i][0] = -b
            coins[i][1] = -a
        }
        result = maxOf(result, maxAmount())
        return result
    }
}
