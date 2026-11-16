package jewelsandstones

// Time:  O(m + n)
// Space: O(n)

class Solution {
    fun numJewelsInStones(J: String, S: String): Int {
        val lookup = HashSet<Char>()
        for (j in J) {
            lookup.add(j)
        }
        var result = 0
        for (s in S) {
            if (lookup.contains(s)) {
                ++result
            }
        }
        return result
    }
}
