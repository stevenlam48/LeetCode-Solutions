package reverseinteger

// Time:  O(logn) = O(1)
// Space: O(1)

class Solution {
    fun reverse(x0: Int): Int {
        var x = x0
        var result = 0
        while (x != 0) {
            if (result > Int.MAX_VALUE / 10 ||
                (result == Int.MAX_VALUE / 10 && x % 10 > Int.MAX_VALUE % 10)) {
                return 0
            }
            if (result < Int.MIN_VALUE / 10 ||
                (result == Int.MIN_VALUE / 10 && x % 10 < Int.MIN_VALUE % 10)) {
                return 0
            }
            result *= 10
            result += x % 10
            x /= 10
        }
        return result
    }
}
