package streamofcharacters
// Time:  ctor:  O(n)    , n is the total size of patterns
//       query: O(m + z), m is the total size of query string
//                      , z is the number of all matched strings
//                      , query time could be further improved to O(m) if we don't return all matched patterns
// Space: O(t), t is the total size of ac automata trie
//            , space could be further improved by DAT (double-array trie)

private class AhoNode {
    val children = arrayOfNulls<AhoNode>(26)
    val indices = mutableListOf<Int>()
    var suffix: AhoNode? = null
    var output: AhoNode? = null
}

private class AhoTrie(patterns: List<String>) {
    private val root = createACTrie(patterns)
    private var node: AhoNode? = createACSuffixAndOutputLinks(root)

    fun step(letter: Char): List<Int> {
        val index = letter - 'a'
        while (node != null && node!!.children[index] == null) {
            node = node!!.suffix
        }
        node = node?.children?.get(index) ?: root
        return getACNodeOutputs()
    }

    private fun createACTrie(patterns: List<String>): AhoNode {
        val root = AhoNode()
        for (i in patterns.indices) {
            var node = root
            for (c in patterns[i]) {
                val index = c - 'a'
                if (node.children[index] == null) {
                    node.children[index] = AhoNode()
                }
                node = node.children[index]!!
            }
            node.indices.add(i)
        }
        return root
    }

    private fun createACSuffixAndOutputLinks(root: AhoNode): AhoNode {
        val queue = ArrayDeque<AhoNode>()
        for (node in root.children) {
            if (node != null) {
                queue.addLast(node)
                node.suffix = root
            }
        }
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            for (c in node.children.indices) {
                val child = node.children[c] ?: continue
                queue.addLast(child)
                var suffix = node.suffix
                while (suffix != null && suffix.children[c] == null) {
                    suffix = suffix.suffix
                }
                child.suffix = suffix?.children?.get(c) ?: root
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
        val result = mutableListOf<Int>()
        result.addAll(node!!.indices)
        var output = node!!.output
        while (output != null) {
            result.addAll(output.indices)
            output = output.output
        }
        return result
    }
}

class StreamChecker(words: List<String>) {
    private val trie = AhoTrie(words)

    fun query(letter: Char): Boolean = trie.step(letter).isNotEmpty()
}
