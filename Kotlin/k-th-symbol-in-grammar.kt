package kthsymbolingrammar

// Time:  O(logn) = O(1) because n is 32-bit integer
// Space: O(1)

class Solution {
    fun kthGrammar(N: Int, K: Int): Int {
        return bitCount(K - 1) % 2
    }

    private fun bitCount(n: Int): Int {
        var x = n
        var count = 0
        while (x != 0) {
            x = x and (x - 1)
            ++count
        }
        return count
    }
}
