package factorialtrailingzeroes

// Time:  O(logn) = O(1)
// Space: O(1)

class Solution {
    fun trailingZeroes(n: Int): Int {
        var n = n
        var number = 0
        while (n > 0) {
            number += n / 5
            n /= 5
        }
        return number
    }
}
