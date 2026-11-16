package checkbalancedstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isBalanced(num: String): Boolean {
        fun sumDigits(start: Int): Int {
            var result = 0
            var i = start
            while (i < num.length) {
                result += num[i].code - '0'.code
                i += 2
            }
            return result
        }

        return sumDigits(0) == sumDigits(1)
    }
}
