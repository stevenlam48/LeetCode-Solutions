package numberswithsameconsecutivedifferences

// Time:  O(2^n)
// Space: O(2^n)

class Solution {
    fun numsSameConsecDiff(N: Int, K: Int): IntArray {
        var curr = (0..9).toMutableList()
        for (i in 0 until N - 1) {
            val next = mutableListOf<Int>()
            for (x in curr) {
                val y = x % 10
                if (x > 0 && y + K < 10) {
                    next.add(x * 10 + y + K)
                }
                if (x > 0 && K > 0 && y - K >= 0) {
                    next.add(x * 10 + y - K)
                }
            }
            curr = next
        }
        return curr.toIntArray()
    }
}
