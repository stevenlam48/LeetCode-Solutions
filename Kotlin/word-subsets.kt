package wordsubsets

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun wordSubsets(words1: List<String>, words2: List<String>): List<String> {
        val count = IntArray(26)
        for (word in words2) {
            val current = counter(word)
            for (i in 0 until 26) {
                count[i] = maxOf(count[i], current[i])
            }
        }
        val result = mutableListOf<String>()
        for (word in words1) {
            val current = counter(word)
            var i = 0
            while (i < 26 && current[i] >= count[i]) ++i
            if (i == 26) result.add(word)
        }
        return result
    }

    private fun counter(word: String): IntArray {
        val count = IntArray(26)
        for (c in word) ++count[c - 'a']
        return count
    }
}
