package numberofdivisiblesubstrings

// Time:  O(d * n)
// Space: O(n)

class Solution {
    fun countDivisibleSubstrings(word: String): Int {
        var result = 0
        for (d in 1..9) {
            var prefix = 0
            val cnt = mutableMapOf(0 to 1)
            for (i in word.indices) {
                prefix += (word[i] - 'a' + 1) / 3 + 1
                val key = prefix - d * (i + 1)
                result += cnt.getOrDefault(key, 0)
                cnt[key] = cnt.getOrDefault(key, 0) + 1
            }
        }
        return result
    }
}
