package integerreplacement
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun integerReplacement(n: Int): Int {
        if (n == Int.MAX_VALUE) {
            return 2 + integerReplacement(n / 2 + 1)
        }
        var value = n
        var result = 0
        while (value != 1) {
            when {
                value == 3 -> --value
                (value and 3) == 3 -> ++value
                (value and 3) == 1 -> --value
                else -> value /= 2
            }
            ++result
        }
        return result
    }
}
