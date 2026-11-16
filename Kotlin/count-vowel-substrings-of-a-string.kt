package countvowelsubstringsofastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countVowelSubstrings(word: String): Int {
        val k = 5
        return atLeastK(word, k)
    }

    private fun atLeastK(word: String, k: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')

        val cnt = HashMap<Char, Int>()
        var result = 0
        var left = 0
        var right = 0
        for (i in word.indices) {
            if (!vowels.contains(word[i])) {
                cnt.clear()
                left = i + 1
                right = i + 1
                continue
            }
            cnt[word[i]] = (cnt[word[i]] ?: 0) + 1
            while (cnt.size > k - 1) {
                val c = word[right]
                val v = (cnt[c] ?: 0) - 1
                if (v == 0) {
                    cnt.remove(c)
                } else {
                    cnt[c] = v
                }
                ++right
            }
            result += right - left
        }
        return result
    }
}
