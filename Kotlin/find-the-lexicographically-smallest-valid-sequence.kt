package findthelexicographicallysmallestvalidsequence
// Time:  O(n + m)
// Space: O(m)

class Solution {
    fun validSequence(word1: String, word2: String): IntArray {
        val lookup = IntArray(word2.length) { -1 }
        var j = word2.length - 1
        for (i in word1.indices.reversed()) {
            if (word1[i] != word2[j]) {
                continue
            }
            lookup[j--] = i
            if (j == -1) {
                break
            }
        }
        val result = mutableListOf<Int>()
        var cnt = 0
        for (i in word1.indices) {
            if (!(word1[i] == word2[result.size] ||
                    cnt == 0 && (result.size + 1 == word2.length || i < lookup[result.size + 1]))) {
                continue
            }
            if (word1[i] != word2[result.size]) {
                ++cnt
            }
            result.add(i)
            if (result.size == word2.length) {
                return result.toIntArray()
            }
        }
        return IntArray(0)
    }
}
