package computedecimalrepresentation
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun decimalRepresentation(n: Int): IntArray {
        val result = mutableListOf<Int>()
        var current = n
        var base = 1L
        while (current != 0) {
            val r = current % 10
            if (r != 0) {
                result.add((r * base).toInt())
            }
            current /= 10
            base *= 10
        }
        return result.asReversed().toIntArray()
    }
}
