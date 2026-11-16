package redistributecharacterstomakeallstringsequal

// Time:  O(n)
// Space: O(1)

class Solution {
    fun makeEqual(words: List<String>): Boolean {
        val cnt = IntArray(26)
        for (w in words) {
            for (c in w) {
                ++cnt[c - 'a']
            }
        }
        return cnt.all { it % words.size == 0 }
    }
}
