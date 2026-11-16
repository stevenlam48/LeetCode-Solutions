package burstballoons

// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun maxCoins(nums: IntArray): Int {
        val coinList = ArrayList<Int>()
        coinList.add(1)
        for (n in nums) {
            if (n > 0) {
                coinList.add(n)
            }
        }
        coinList.add(1)
        val coins = coinList.toIntArray()
        val maxCoins = Array(coins.size) { IntArray(coins.size) }
        for (k in 2 until coins.size) {
            for (left in 0 until coins.size - k) {
                val right = left + k
                for (i in left + 1 until right) {
                    maxCoins[left][right] = maxOf(
                        maxCoins[left][right],
                        coins[left] * coins[i] * coins[right] + maxCoins[left][i] + maxCoins[i][right]
                    )
                }
            }
        }
        return maxCoins[0][coins.size - 1]
    }
}
