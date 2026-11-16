package checkifonestringswapcanmakestringsequal

// Time:  O(n)
// Space: O(1)
class Solution {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        val diff = ArrayList<Pair<Char, Char>>()
        for (i in s1.indices) {
            if (s1[i] == s2[i]) {
                continue
            }
            if (diff.size == 2) {
                return false
            }
            diff.add(if (diff.isEmpty()) Pair(s1[i], s2[i]) else Pair(s2[i], s1[i]))
        }
        return diff.isEmpty() || (diff.size == 2 && diff[0] == diff[1])
    }
}
