package totalappealofastring

// Time:  O(n)
// Space: O(26)

class Solution {
    fun appealSum(s: String): Long {
        val lookup = IntArray(26) { -1 }
        var result = 0L
        for (i in s.indices) {
            val c = s[i] - 'a'
            result += (i - lookup[c]).toLong() * (s.length - i)
            lookup[c] = i
        }
        return result
    }
}
