package wordladderii

// Time:  O(b^(d/2)), b is the branch factor of bfs, d is the result depth
// Space: O(w * l), w is the number of words, l is the max length of words

class Solution {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val words = wordList.toHashSet()
        if (endWord !in words) return emptyList()
        val tree = HashMap<String, MutableSet<String>>()
        var left = hashSetOf(beginWord)
        var right = hashSetOf(endWord)
        var isFound = false
        var isReversed = false
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
                        if (candidate in right) {
                            isFound = true
                        } else {
                            newLeft.add(candidate)
                        }
                        if (!isReversed) {
                            tree.getOrPut(candidate) { HashSet() } .add(word)
                        } else {
                            tree.getOrPut(word) { HashSet() } .add(candidate)
                        }
                    }
                    newWord[i] = previous
                }
            }
            if (isFound) break
            left = newLeft
            if (left.size > right.size) {
                val temporary = left
                left = right
                right = temporary
                isReversed = !isReversed
            }
        }
        return backtracking(tree, beginWord, endWord)
    }

    private fun backtracking(
        tree: Map<String, Set<String>>,
        beginWord: String,
        word: String
    ): List<List<String>> {
        val result = mutableListOf<List<String>>()
        if (word == beginWord) {
            result.add(listOf(beginWord))
        } else {
            for (newWord in tree[word].orEmpty()) {
                if (word == newWord) continue
                for (path in backtracking(tree, beginWord, newWord)) {
                    result.add(path + word)
                }
            }
        }
        return result
    }
}
