package wordladder

// Time:  O(b^(d/2)), b is the branch factor of bfs, d is the result depth
// Space: O(w * l), w is the number of words, l is the max length of words

class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val words = wordList.toHashSet()
        if (endWord !in words) return 0
        var ladder = 2
        var left = hashSetOf(beginWord)
        var right = hashSetOf(endWord)
        while (left.isNotEmpty()) {
            for (word in left) words.remove(word)
            val newLeft = HashSet<String>()
            for (word in left) {
                val newWord = word.toCharArray()
                for (i in newWord.indices) {
                    val previous = newWord[i]
                    for (j in 0 until 26) {
                        newWord[i] = 'a' + j
                        val candidate = String(newWord)
                        if (candidate !in words) continue
                        if (candidate in right) return ladder
                        newLeft.add(candidate)
                    }
                    newWord[i] = previous
                }
            }
            left = newLeft
            ++ladder
            if (left.size > right.size) {
                val temporary = left
                left = right
                right = temporary
            }
        }
        return 0
    }
}
