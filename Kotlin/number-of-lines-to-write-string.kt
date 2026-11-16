package numberoflinestowritestring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun numberOfLines(widths: IntArray, s: String): IntArray {
        val result = IntArray(2)
        result[0] = 1
        for (c in s) {
            val w = widths[c - 'a']
            result[1] += w
            if (result[1] > 100) {
                result[0]++
                result[1] = w
            }
        }
        return result
    }
}
