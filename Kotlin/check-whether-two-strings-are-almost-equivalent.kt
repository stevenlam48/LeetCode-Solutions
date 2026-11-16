package checkwhethertwostringsarealmostequivalent

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkAlmostEquivalent(word1: String, word2: String): Boolean {
        val k = 3

        val cnt1 = HashMap<Char, Int>()
        for (c in word1) {
            cnt1[c] = (cnt1[c] ?: 0) + 1
        }
        val cnt2 = HashMap<Char, Int>()
        for (c in word2) {
            cnt2[c] = (cnt2[c] ?: 0) + 1
        }
        for ((key, value) in cnt1) {
            if (kotlin.math.abs((cnt2[key] ?: 0) - value) > k) {
                return false
            }
        }
        for ((key, value) in cnt2) {
            if (kotlin.math.abs((cnt1[key] ?: 0) - value) > k) {
                return false
            }
        }
        return true
    }
}
