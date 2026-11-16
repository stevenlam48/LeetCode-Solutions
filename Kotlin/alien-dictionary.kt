package aliendictionary

// Time:  O(n)
// Space: O(|V|+|E|) = O(26 + 26^2) = O(1)

class Solution {
    fun alienOrder(words: List<String>): String {
        val nodes = HashSet<Char>()
        val inDegree = HashMap<Char, HashSet<Char>>()
        val outDegree = HashMap<Char, HashSet<Char>>()
        val zeroInDegreeQueue = ArrayDeque<Char>()
        for (word in words) {
            for (c in word) {
                nodes.add(c)
            }
        }
        for (i in 1 until words.size) {
            if (words[i - 1].length > words[i].length &&
                words[i - 1].substring(0, words[i].length) == words[i]
            ) {
                return ""
            }
            findEdges(words[i - 1], words[i], inDegree, outDegree)
        }
        for (node in nodes) {
            if (!inDegree.containsKey(node)) {
                zeroInDegreeQueue.addLast(node)
            }
        }
        val result = StringBuilder()
        while (zeroInDegreeQueue.isNotEmpty()) {
            val precedence = zeroInDegreeQueue.removeFirst()
            result.append(precedence)
            val successors = outDegree[precedence]
            if (successors != null) {
                for (c in successors) {
                    inDegree[c]!!.remove(precedence)
                    if (inDegree[c]!!.isEmpty()) {
                        zeroInDegreeQueue.addLast(c)
                    }
                }
                outDegree.remove(precedence)
            }
        }
        if (outDegree.isNotEmpty()) {
            return ""
        }
        return result.toString()
    }

    private fun findEdges(
        word1: String,
        word2: String,
        inDegree: HashMap<Char, HashSet<Char>>,
        outDegree: HashMap<Char, HashSet<Char>>
    ) {
        val length = minOf(word1.length, word2.length)
        for (i in 0 until length) {
            if (word1[i] != word2[i]) {
                inDegree.getOrPut(word2[i]) { HashSet() }.add(word1[i])
                outDegree.getOrPut(word1[i]) { HashSet() }.add(word2[i])
                break
            }
        }
    }
}
