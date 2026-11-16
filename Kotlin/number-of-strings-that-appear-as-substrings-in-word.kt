package numberofstringsthatappearassubstringsinword

// Time:  O(n * l + m), n is the number of patterns
//                    , l is the max length of patterns
//                    , m is the length of word
// Space: O(t)        , t is the total size of ac automata trie

class AhoNode {
    val children = arrayOfNulls<AhoNode>(26)
    val indices = mutableListOf<Int>()
    var suffix: AhoNode? = null
    var output: AhoNode? = null
}

class AhoTrie(patterns: List<String>) {
    private val root_: AhoNode = createACTrie(patterns)
    private var node_: AhoNode? = createACSuffixAndOutputLinks(root_)
    private val lookup_ = HashSet<AhoNode>()

    fun step(letter: Char): List<Int> {
        while (node_ != null && node_!!.children[letter - 'a'] == null) {
            node_ = node_!!.suffix
        }
        node_ = if (node_ != null) node_!!.children[letter - 'a'] else root_
        return getACNodeOutputs(node_!!)
    }

    fun reset() {
        node_ = root_
    }

    private fun createACTrie(patterns: List<String>): AhoNode {  // Time:  O(n * l), Space: O(t)
        val root = AhoNode()
        for (i in patterns.indices) {
            var node = root
            for (c in patterns[i]) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = AhoNode()
                }
                node = node.children[c - 'a']!!
            }
            node.indices.add(i)
        }
        return root
    }

    private fun createACSuffixAndOutputLinks(root: AhoNode): AhoNode {  // Time: O(n * l), Space: O(t)
        val q = java.util.ArrayDeque<AhoNode>()
        for (c in root.children.indices) {
            val node = root.children[c] ?: continue
            q.addLast(node)
            node.suffix = root
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

    private fun getACNodeOutputs(node: AhoNode): List<Int> {  // Total Time: O(n), modified
        val result = mutableListOf<Int>()
        if (!lookup_.contains(node)) {  // modified
            lookup_.add(node)  // modified
            for (i in node_!!.indices) {
                result.add(i)
            }
            var output = node_!!.output
            while (output != null && !lookup_.contains(output)) {  // modified
                lookup_.add(output)
                for (i in output.indices) {  // modified
                    result.add(i)
                }
                output = output.output
            }
        }
        return result
    }
}

// ac automata solution
class Solution {
    fun numOfStrings(patterns: List<String>, word: String): Int {
        val trie = AhoTrie(patterns)
        return word.sumOf { trie.step(it).size }
    }
}
