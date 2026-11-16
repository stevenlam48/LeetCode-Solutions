package concatenationofconsecutivebinarynumbers
// Time:  O(n)
// Space: O(1)

class Solution {
    fun concatenatedBinary(n: Int): Int {
        val mod = 1_000_000_007L
        var result = 0L
        var len = 0L
        for (i in 1..n) {
            if (i and (i - 1) == 0) {
                ++len
            }
            result = ((result shl len.toInt()) % mod + i) % mod
        }
        return result.toInt()
    }
}
