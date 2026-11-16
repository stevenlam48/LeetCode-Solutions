package largestintegerwithgivendigitsum

// Time:  O(n)
// Space: O(1)

class Solution {
    fun largestInteger(n: Int, s: Int): Int {
        var result = 0
        var remaining = s
        repeat(n) {
            val x = minOf(remaining, 9)
            result = result * 10 + x
            remaining -= x
        }
        return if (remaining == 0) result else -1
    }
}
