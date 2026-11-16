package minimumcosttomakeallcharactersequal
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumCost(s: String): Long {
        var result = 0L
        for (i in 0 until s.length - 1) {
            if (s[i] != s[i + 1]) {
                result += minOf(i + 1, s.length - (i + 1))
            }
        }
        return result
    }
}
