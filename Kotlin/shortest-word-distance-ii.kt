package shortestworddistanceii

// Time:  ctor: O(n), shortest: O(a + b), a, b is occurences of word1, word2
// Space: O(n)
class WordDistance(words: List<String>) {
    private val wordIndex = HashMap<String, MutableList<Int>>()

    init {
        for (i in words.indices) {
            wordIndex.getOrPut(words[i]) { mutableListOf() }.add(i)
        }
    }

    fun shortest(word1: String, word2: String): Int {
        val indexes1 = wordIndex.getOrPut(word1) { mutableListOf() }
        val indexes2 = wordIndex.getOrPut(word2) { mutableListOf() }
        var i = 0
        var j = 0
        var dist = Int.MAX_VALUE
        while (i < indexes1.size && j < indexes2.size) {
            dist = minOf(dist, kotlin.math.abs(indexes1[i] - indexes2[j]))
            if (indexes1[i] < indexes2[j]) ++i else ++j
        }
        return dist
    }
}
