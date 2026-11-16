package streamofcharacters2
// Time:  ctor:  O(n + p^2), n is the total size of patterns
//                         , p is the number of patterns
//        query: O(m + z), m is the total size of query string
//                       , z is the number of all matched strings
//                       , query time would be O(m) if we don't use all the matched patterns
// Space: O(t + p^2), t is the total size of ac automata trie
//                  , space could be further improved by DAT (double-array trie)

private class AhoNode {
    val children = arrayOfNulls<AhoNode>(26)
    var suffix: AhoNode? = null
    val outputs = mutableListOf<Int>()
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
        return node!!.outputs
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
            node.outputs.add(i)
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
                child.outputs.addAll(child.suffix!!.outputs)
            }
        }
        return root
    }
}

class StreamChecker(words: List<String>) {
    private val trie = AhoTrie(words)

    fun query(letter: Char): Boolean = trie.step(letter).isNotEmpty()
}
