package findtheminimumnumberoffibonaccinumberswhosesumisk

// Time:  O(logk)
// Space: O(1)

class Solution {
    fun findMinFibonacciNumbers(k0: Int): Int {
        var k = k0
        var result = 0
        var a = 1
        var b = 1
        while (b <= k) {
            val nb = a + b
            a = b
            b = nb
        }
        while (k != 0) {
            if (a <= k) {
                k -= a
                ++result
            }
            val na = b - a
            b = a
            a = na
        }
        return result
    }
}
