package findmirrorscoreofastring

// Time:  O(n + 26)
// Space: O(n + 26)

class Solution {
    fun calculateScore(s: String): Long {
        var result = 0L
        val lookup = Array(26) { mutableListOf<Int>() }
        for (i in s.indices) {
            val x = s[i] - 'a'
            if (lookup[25 - x].isNotEmpty()) {
                result += i - lookup[25 - x].removeAt(lookup[25 - x].size - 1)
            } else {
                lookup[x].add(i)
            }
        }
        return result
    }
}
