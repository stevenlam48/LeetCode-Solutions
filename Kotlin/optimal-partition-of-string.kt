package optimalpartitionofstring

// Time:  O(n)
// Space: O(n)

class Solution {
    fun partitionString(s: String): Int {
        var result = 1
        var left = 0
        val lookup = IntArray(26) { -1 }
        for (i in s.indices) {
            if (lookup[s[i] - 'a'] >= left) {
                left = i
                ++result
            }
            lookup[s[i] - 'a'] = i
        }
        return result
    }
}
