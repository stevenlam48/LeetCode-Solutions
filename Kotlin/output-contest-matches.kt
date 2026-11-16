package outputcontestmatches
// Time:  O(n)
// Space: O(n)

class Solution {
    fun findContestMatch(n: Int): String {
        var matches = MutableList(n) { (it + 1).toString() }
        while (matches.size / 2 != 0) {
            val nextMatches = mutableListOf<String>()
            for (i in 0 until matches.size / 2) {
                nextMatches.add("(${matches[i]},${matches[matches.size - 1 - i]})")
            }
            matches = nextMatches
        }
        return matches[0]
    }
}
