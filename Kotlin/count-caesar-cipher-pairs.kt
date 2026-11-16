package countcaesarcipherpairs

// Time:  O(n * m)
// Space: O(n * m)

class Solution {
    fun countPairs(words: List<String>): Long {
        fun f(s: String): String {
            val chars = s.toCharArray()
            for (i in chars.lastIndex downTo 0) {
                chars[i] = 'a' + ((chars[i] - chars[0]) % 26 + 26) % 26
            }
            return String(chars)
        }

        var result = 0L
        val cnt = HashMap<String, Int>()
        for (w in words) {
            val key = f(w)
            result += cnt[key] ?: 0
            cnt[key] = (cnt[key] ?: 0) + 1
        }
        return result
    }
}
