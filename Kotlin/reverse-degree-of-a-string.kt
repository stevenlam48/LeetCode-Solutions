package reversedegreeofastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseDegree(s: String): Int {
        var result = 0
        for (i in s.indices) {
            result += (i + 1) * (26 - (s[i] - 'a'))
        }
        return result
    }
}
