package canconvertstringinkmoves

// Time:  O(n)
// Space: O(1)

class Solution {
    fun canConvertString(s: String, t: String, k: Int): Boolean {
        if (s.length != t.length) {
            return false
        }
        val cnt = IntArray(26)
        for (i in s.indices) {
            val diff = (cnt.size + t[i].code - s[i].code) % cnt.size
            if (diff != 0 && cnt[diff] * cnt.size + diff > k) {
                return false
            }
            ++cnt[diff]
        }
        return true
    }
}
