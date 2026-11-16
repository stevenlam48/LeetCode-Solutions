package lemonadechange
// Time:  O(n)
// Space: O(1)

class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        val coins = intArrayOf(20, 10, 5)
        val counts = HashMap<Int, Int>()
        for (bill in bills) {
            counts[bill] = (counts[bill] ?: 0) + 1
            var change = bill - coins.last()
            for (coin in coins) {
                if (change == 0) {
                    break
                }
                if (change >= coin) {
                    val count = minOf(counts[coin] ?: 0, change / coin)
                    counts[coin] = (counts[coin] ?: 0) - count
                    change -= coin * count
                }
            }
            if (change != 0) {
                return false
            }
        }
        return true
    }
}
