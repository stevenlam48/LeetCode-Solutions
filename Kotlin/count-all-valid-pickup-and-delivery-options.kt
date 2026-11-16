package countallvalidpickupanddeliveryoptions

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countOrders(n: Int): Int {
        val MOD = 1_000_000_007L
        var result = 1L
        var i = 2 * n
        while (i > 0) {
            result = result * i * (i - 1) / 2 % MOD
            i -= 2
        }
        return result.toInt()
    }
}
