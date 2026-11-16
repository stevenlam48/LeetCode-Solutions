package validanagram

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val count = HashMap<Char, Int>()
        for (c in s) {
            count[c] = (count[c] ?: 0) + 1
        }
        for (c in t) {
            count[c] = (count[c] ?: 0) - 1
            if (count[c]!! < 0) {
                return false
            }
        }
        return true
    }
}
