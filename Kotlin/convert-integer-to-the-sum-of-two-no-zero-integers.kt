package convertintegertothesumoftwonozerointegers

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun getNoZeroIntegers(n: Int): IntArray {
        var a = 0
        var curr = n
        var base = 1
        while (curr != 0) {
            if (curr % 10 == 0 || (curr % 10 == 1 && curr != 1)) {
                a += base
                curr -= 10
            }
            a += base
            base *= 10
            curr /= 10
        }
        return intArrayOf(a, n - a)
    }
}
