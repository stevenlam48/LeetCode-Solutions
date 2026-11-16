package findresultantarrayafterremovinganagrams

// Time:  O(n * l)
// Space: O(1)

// freq table
class Solution {
    fun removeAnagrams(words: List<String>): List<String> {
        val result = mutableListOf<String>()
        var prev: IntArray? = null
        for (x in words) {
            val cnt = IntArray(26)
            for (c in x) {
                ++cnt[c - 'a']
            }
            if (prev != null && prev.contentEquals(cnt)) {
                continue
            }
            prev = cnt
            result.add(x)
        }
        return result
    }
}
