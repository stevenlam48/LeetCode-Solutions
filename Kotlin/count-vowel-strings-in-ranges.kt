package countvowelstringsinranges

// Time:  O(n + q)
// Space: O(n)

class Solution {
    fun vowelStrings(words: List<String>, queries: Array<IntArray>): IntArray {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        val prefix = IntArray(words.size + 1)
        for (i in words.indices) {
            prefix[i + 1] = prefix[i] + if (vowels.contains(words[i].first()) && vowels.contains(words[i].last())) 1 else 0
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val q = queries[i]
            result[i] = prefix[q[1] + 1] - prefix[q[0]]
        }
        return result
    }
}
