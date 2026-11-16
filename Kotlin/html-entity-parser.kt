package htmlentityparser

// Time:  O(n + m + z) = O(m), n is the total size of patterns
//                           , m is the total size of query string
//                           , z is the number of all matched strings
//                           , O(n) = O(1), O(z) = O(m) in this problem
// Space: O(t) = O(1), t is the total size of ac automata trie
//                   , O(t) = O(1) in this problem

private class AhoNode {
    val children = HashMap<Char, AhoNode>()
    val indices = ArrayList<Int>()
    var suffix: AhoNode? = null
    var output: AhoNode? = null
}

private class AhoTrie(patterns: List<String>) {
    private val root: AhoNode = createACTrie(patterns)
    private var node: AhoNode? = createACSuffixAndOutputLinks(root)

    fun step(letter: Char): List<Int> {
        while (node != null && node!!.children[letter] == null) {
            node = node!!.suffix
        }
        node = if (node != null) node!!.children[letter] else root
        return getACNodeOutputs()
    }

    private fun createACTrie(patterns: List<String>): AhoNode {
        val root = AhoNode()
        for (i in patterns.indices) {
            var node = root
            for (c in patterns[i]) {
                node = node.children.getOrPut(c) { AhoNode() }
            }
            node.indices.add(i)
        }
        return root
    }

    private fun createACSuffixAndOutputLinks(root: AhoNode): AhoNode {
        val q = ArrayDeque<AhoNode>()
        for (child in root.children.values) {
            q.addLast(child)
            child.suffix = root
        }

        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            for ((c, child) in node.children) {
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
    fun entityParser(text: String): String {
        val patterns = listOf("&quot;", "&apos;", "&amp;", "&gt;", "&lt;", "&frasl;")
        val chars = listOf("\"", "'", "&", ">", "<", "/")
        val trie = AhoTrie(patterns)
        val positions = ArrayList<Pair<Int, Int>>()
        for (i in text.indices) {
            for (j in trie.step(text[i])) {
                positions.add(Pair(i - patterns[j].length + 1, j))
            }
        }
        val result = StringBuilder()
        var i = 0
        var j = 0
        while (i != text.length) {
            if (j == positions.size || i != positions[j].first) {
                result.append(text[i])
                ++i
            } else {
                result.append(chars[positions[j].second])
                i += patterns[positions[j].second].length
                ++j
            }
        }
        return result.toString()
    }
}
