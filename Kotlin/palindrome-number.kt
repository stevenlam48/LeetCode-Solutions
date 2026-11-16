package palindromenumber
// Time:  O(logx) = O(1)
// Space: O(1)

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        var temp = x
        var reversed = 0
        while (temp != 0) {
            if (isOverflow(reversed, temp % 10)) {
                return false
            }
            reversed = reversed * 10 + temp % 10
            temp /= 10
        }
        return reversed == x
    }

    private fun isOverflow(q: Int, r: Int): Boolean {
        val maxQ = Int.MAX_VALUE / 10
        val maxR = Int.MAX_VALUE % 10
        return q > maxQ || (q == maxQ && r > maxR)
    }
}
