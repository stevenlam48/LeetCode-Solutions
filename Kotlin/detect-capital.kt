package detectcapital

// Time:  O(l)
// Space: O(1)

class Solution {
    fun detectCapitalUse(word: String): Boolean {
        val count = word.count { it.isUpperCase() }
        return count == word.length || count == 0 ||
            (count == 1 && word[0].isUpperCase())
    }
}
