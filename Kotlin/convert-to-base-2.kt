package converttobase2

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun baseNeg2(n: Int): String {
        var x = n
        val result = StringBuilder()
        while (x != 0) {
            result.append(((-x) and 1).toString())
            x = -(x shr 1)
        }
        return if (result.isEmpty()) "0" else result.reverse().toString()
    }
}
