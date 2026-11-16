package goodindicesinadigitstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun goodIndices(s: String): IntArray {
        val result = mutableListOf<Int>()
        var curr = 0
        var base = 1
        for (i in s.indices) {
            if (i == base * 10) {
                base *= 10
            }
            curr = (curr % base) * 10 + (s[i] - '0')
            if (curr == i) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }
}
