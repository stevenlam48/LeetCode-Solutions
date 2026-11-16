package findmaximumnumberofnonintersectingsubstrings

// Time:  O(n)
// Space: O(26)

class Solution {
    fun maxSubstrings(word: String): Int {
        val L = 4

        var result = 0
        val lookup = HashMap<Char, Int>()
        for (i in word.indices) {
            val c = word[i]
            if (!lookup.containsKey(c)) {
                lookup[c] = i
            } else if (i - lookup[c]!! + 1 >= L) {
                ++result
                lookup.clear()
            }
        }
        return result
    }
}
