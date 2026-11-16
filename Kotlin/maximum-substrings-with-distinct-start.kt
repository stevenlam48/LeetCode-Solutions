package maximumsubstringswithdistinctstart
// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun maxDistinct(s: String): Int {
        var result = 0
        val lookup = BooleanArray(26)
        for (x in s) {
            if (lookup[x - 'a']) {
                continue
            }
            lookup[x - 'a'] = true
            ++result
        }
        return result
    }
}
