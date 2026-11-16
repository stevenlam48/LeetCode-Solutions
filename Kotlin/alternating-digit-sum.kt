package alternatingdigitsum

// Time:  O(logn)
// Space: O(1)

// math
class Solution {
    fun alternateDigitSum(n: Int): Int {
        var x = n
        var result = 0
        var sign = 1
        while (x != 0) {
            sign *= -1
            result += sign * (x % 10)
            x /= 10
        }
        return sign * result
    }
}
