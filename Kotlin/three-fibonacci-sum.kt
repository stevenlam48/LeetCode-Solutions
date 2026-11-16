package threefibonaccisum
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun threeFibonacciSum(n: Int): Boolean {
        if (n % 2 != 0) {
            return false
        }
        var a = 1
        var b = 1
        while (b < n / 2) {
            val next = a + b
            a = b
            b = next
        }
        return b == n / 2
    }
}
