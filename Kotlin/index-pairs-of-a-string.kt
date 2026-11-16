package indexpairsofastring

// Time:  O(n + m + z), n is the total size of patterns
//                    , m is the total size of query string
//                    , z is the number of all matched strings
// Space: O(t), t is the total size of ac automata trie

private class AhoNode {
    val children = arrayOfNulls<AhoNode>(26)
    val indices = ArrayList<Int>()
    var suffix: AhoNode? = null
    var output: AhoNode? = null
}

private class AhoTrie(patterns: List<String>) {
    private val root: AhoNode = createACTrie(patterns)
    private var node: AhoNode? = createACSuffixAndOutputLinks(root)

    fun step(letter: Char): List<Int> {
        val idx = letter - 'a'
        while (node != null && node!!.children[idx] == null) {
            node = node!!.suffix
        }
        node = if (node != null) node!!.children[idx] else root
        return getACNodeOutputs()
    }

    private fun createACTrie(patterns: List<String>): AhoNode {
        val root = AhoNode()
        for (i in patterns.indices) {
            var node = root
            for (c in patterns[i]) {
                val idx = c - 'a'
                if (node.children[idx] == null) {
                    node.children[idx] = AhoNode()
                }
                node = node.children[idx]!!
            }
            node.indices.add(i)
        }
        return root
    }

    private fun createACSuffixAndOutputLinks(root: AhoNode): AhoNode {
        val q = ArrayDeque<AhoNode>()
        for (child in root.children) {
            if (child == null) {
                continue
            }
            q.addLast(child)
            child.suffix = root
        }

        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            for (c in node.children.indices) {
                val child = node.children[c] ?: continue
                q.addLast(child)
                var suffix = node.suffix
                while (suffix != null && suffix.children[c] == null) {
                    suffix = suffix.suffix
                }
                child.suffix = if (suffix != null) suffix.children[c] else root
                child.output = if (child.suffix!!.indices.isNotEmpty()) {
                    child.suffix
                } else {
                    child.suffix!!.output
                }
            }
        }

        return root
    }

    private fun getACNodeOutputs(): List<Int> {
        val result = ArrayList<Int>()
        val current = node ?: return result
        result.addAll(current.indices)
        var output = current.output
        while (output != null) {
            result.addAll(output.indices)
            output = output.output
        }
        return result
    }
}

class Solution {
    fun indexPairs(text: String, words: List<String>): List<List<Int>> {
        val patterns = words.map { it.reversed() }
        val trie = AhoTrie(patterns)
        val result = ArrayList<List<Int>>()
        for (i in text.length - 1 downTo 0) {
            for (j in trie.step(text[i])) {
                result.add(listOf(i, i + patterns[j].length - 1))
            }
        }
        result.reverse()
        return result
    }
}
