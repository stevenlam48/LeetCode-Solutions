package substringwithlargestvariance

// Time:  O(a^2 * n), a is the size of alphabets
// Space: O(a)
class Solution {
    fun largestVariance(s: String): Int {
        fun modifiedKadane(x: Char, y: Char): Int {
            var result = 0
            val lookup = BooleanArray(2)
            val remain = intArrayOf(s.count { it == x }, s.count { it == y })
            var curr = 0
            for (c in s) {
                if (c != x && c != y) {
                    continue
                }
                val index = if (c != x) 1 else 0
                lookup[index] = true
                --remain[index]
                curr += if (c == x) 1 else -1
                if (curr < 0 && remain[0] != 0 && remain[1] != 0) {
                    curr = 0
                    lookup[0] = false
                    lookup[1] = false
                }
                if (lookup[0] && lookup[1]) {
                    result = maxOf(result, curr)
                }
            }
            return result
        }

        val alphabets = s.toSet()
        var result = 0
        for (x in alphabets) {
            for (y in alphabets) {
                if (x != y) {
                    result = maxOf(result, modifiedKadane(x, y))
                }
            }
        }
        return result
    }
}
