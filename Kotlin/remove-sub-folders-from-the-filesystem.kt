package removesubfoldersfromthefilesystem
// Time:  O(n), n is the total sum of the lengths of folder names
// Space: O(t), t is the number of nodes in trie

class Solution {
    private class TrieNode {
        var isEnd = false
        val leaves = HashMap<String, TrieNode>()

        fun insert(parts: List<String>) {
            var node = this
            for (part in parts) {
                if (part.isEmpty()) {
                    continue
                }
                node = node.leaves.getOrPut(part) { TrieNode() }
            }
            node.isEnd = true
        }
    }

    fun removeSubfolders(folder: List<String>): List<String> {
        val trie = TrieNode()
        for (path in folder) {
            trie.insert(path.split('/'))
        }
        val result = mutableListOf<String>()
        dfs(trie, mutableListOf(), result)
        return result
    }

    private fun dfs(curr: TrieNode, path: MutableList<String>, result: MutableList<String>) {
        if (curr.isEnd) {
            result.add(path.joinToString("/", prefix = "/"))
            return
        }
        for ((name, child) in curr.leaves) {
            path.add(name)
            dfs(child, path, result)
            path.removeAt(path.lastIndex)
        }
    }
}
