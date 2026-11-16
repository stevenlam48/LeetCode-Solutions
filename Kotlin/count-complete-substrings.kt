package countcompletesubstrings

// Time:  O(26 + d * n), d = len(set(word))
// Space: O(26)

import kotlin.math.abs

class Solution {
    fun countCompleteSubstrings(word: String, k: Int): Int {
        val d = word.toHashSet().size
        var result = 0
        var valid = 0
        val cnt = IntArray(26)
        for (c in 1..d) {
            var left = 0
            for (right in word.indices) {
                val curr = ++cnt[word[right] - 'a']
                valid += if (curr == k) 1 else if (curr == k + 1) -1 else 0
                if (right - left + 1 == c * k + 1) {
                    val removed = cnt[word[left++] - 'a']--
                    valid -= if (removed == k) 1 else if (removed == k + 1) -1 else 0
                }
                if (valid == c) {
                    ++result
                }
                if (right + 1 == word.length || abs(word[right + 1] - word[right]) > 2) {
                    while (left < right + 1) {
                        val removed = cnt[word[left++] - 'a']--
                        valid -= if (removed == k) 1 else if (removed == k + 1) -1 else 0
                    }
                }
            }
        }
        return result
    }
}
