package arrangingcoins

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun arrangeCoins(n: Int): Int {
        return ((Math.sqrt(8.0 * n + 1) - 1) / 2).toInt()
    }
}
