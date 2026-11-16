package substringsthatbeginandendwiththesameletter

// Time:  O(n)
// Space: O(1)
class Solution {
    fun numberOfSubstrings(s: String): Long {
        val count = HashMap<Char, Int>()
        var result = 0L
        for (c in s) {
            val current = count.getOrDefault(c, 0) + 1
            count[c] = current
            result += current
        }
        return result
    }
}
