package stoneremovalgame

// Time:  O(1)
// Space: O(1)

class Solution {
    fun canAliceWin(n: Int): Boolean {
        val c = 10
        val l = (((2 * c + 1) - Math.sqrt(((2 * c + 1) * (2 * c + 1) - 8 * n).toDouble())) / 2).toInt()
        return l % 2 == 1
    }
}
