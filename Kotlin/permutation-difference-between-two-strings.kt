package permutationdifferencebetweentwostrings

import kotlin.math.abs

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun findPermutationDifference(s: String, t: String): Int {
        val lookup = IntArray(26) { -1 }
        for (i in s.indices) {
            lookup[s[i] - 'a'] = i
        }
        var result = 0
        for (i in t.indices) {
            result += abs(lookup[t[i] - 'a'] - i)
        }
        return result
    }
}
