package countcommonwordswithoneoccurrence

// Time:  O(m + n)
// Space: O(m + n)

class Solution {
    fun countWords(words1: List<String>, words2: List<String>): Int {
        val cnt = HashMap<String, Int>()
        for (w in words1) {
            cnt[w] = (cnt[w] ?: 0) + 1
        }
        for (w in words2) {
            if ((cnt[w] ?: 0) < 2) {
                cnt[w] = (cnt[w] ?: 0) - 1
            }
        }
        return cnt.values.count { it == 0 }
    }
}
