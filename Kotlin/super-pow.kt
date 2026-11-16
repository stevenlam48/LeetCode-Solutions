package superpow

// Time:  O(n), n is the size of b.
// Space: O(1)

class Solution {
    fun superPow(a: Int, b: IntArray): Int {
        var result = 1
        for (digit in b) {
            result = myPow(result, 10, 1337) * myPow(a, digit, 1337) % 1337
        }
        return result
    }

    private fun myPow(a: Int, n0: Int, b: Int): Int {
        var result = 1
        var x = a % b
        var n = n0
        while (n != 0) {
            if (n and 1 != 0) {
                result = result * x % b
            }
            n = n shr 1
            x = x * x % b
        }
        return result % b
    }
}
