package countsubstringsthatcanberearrangedtocontainastringii
// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun validSubstringCount(word1: String, word2: String): Long {
        val cnt = IntArray(26)
        var curr = 0
        for (x in word2) {
            if (cnt[x - 'a']++ == 0) {
                ++curr
            }
        }
        var result = 0L
        var left = 0
        for (right in word1.indices) {
            if (--cnt[word1[right] - 'a'] == 0) {
                --curr
            }
            while (curr == 0) {
                result += word1.length - right
                if (cnt[word1[left] - 'a']++ == 0) {
                    ++curr
                }
                ++left
            }
        }
        return result
    }
}
