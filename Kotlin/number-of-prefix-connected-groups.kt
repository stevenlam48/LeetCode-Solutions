package numberofprefixconnectedgroups

// Time:  O(n * k)
// Space: O(n * k)

// freq table
class Solution {
    fun prefixConnected(words: List<String>, k: Int): Int {
        val cnt = HashMap<String, Int>()
        for (w in words) {
            if (w.length < k) {
                continue
            }
            val prefix = w.substring(0, k)
            cnt[prefix] = (cnt[prefix] ?: 0) + 1
        }
        var result = 0
        for (v in cnt.values) {
            if (v >= 2) {
                ++result
            }
        }
        return result
    }
}
