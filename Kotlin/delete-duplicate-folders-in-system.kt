package deleteduplicatefoldersinsystem

// Time:  O(n * m * l + tlogt + l * t), m is the max number of folders in a path,
//                                    , n is the number of paths
//                                    , l is the max length of folder name
//                                    , t is the size of trie
// Space: O(l * t)
class Solution {
    private class TrieNode {
        var deleted = false
        val leaves = HashMap<Int, TrieNode>()

        fun insert(s: List<String>, folderIds: HashMap<String, Int>, idFolders: HashMap<Int, String>) {
            var p = this
            for (c in s) {
                val folderId = folderIds.getOrPut(c) {
                    val id = folderIds.size
                    idFolders[id] = c
                    id
                }
                p = p.leaves.getOrPut(folderId) { TrieNode() }
            }
        }
    }

    fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
        val trie = TrieNode()
        val folderIds = HashMap<String, Int>()
        val idFolders = HashMap<Int, String>()
        for (path in paths) trie.insert(path, folderIds, idFolders)
        val lookup = HashMap<Int, TrieNode>()
        val nodeIds = HashMap<List<Pair<Int, Int>>, Int>()
        mark(trie, lookup, nodeIds)
        val result = mutableListOf<List<String>>()
        val path = mutableListOf<Int>()
        sweep(trie, idFolders, path, result)
        return result
    }

    private fun mark(
        node: TrieNode,
        lookup: HashMap<Int, TrieNode>,
        nodeIds: HashMap<List<Pair<Int, Int>>, Int>
    ): Int {
        val idPairs = mutableListOf<Pair<Int, Int>>()
        for ((subfolderId, child) in node.leaves) {
            idPairs.add(Pair(subfolderId, mark(child, lookup, nodeIds)))
        }
        idPairs.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        if (!nodeIds.containsKey(idPairs)) nodeIds[idPairs] = nodeIds.size
        val nodeId = nodeIds[idPairs]!!
        if (nodeId != 0) {
            if (lookup.containsKey(nodeId)) {
                lookup[nodeId]!!.deleted = true
                node.deleted = true
            } else {
                lookup[nodeId] = node
            }
        }
        return nodeId
    }

    private fun sweep(
        node: TrieNode,
        idFolders: HashMap<Int, String>,
        path: MutableList<Int>,
        result: MutableList<List<String>>
    ) {
        if (path.isNotEmpty()) result.add(path.map { idFolders.getValue(it) })
        for ((subfolderId, child) in node.leaves) {
            if (child.deleted) continue
            path.add(subfolderId)
            sweep(child, idFolders, path, result)
            path.removeAt(path.lastIndex)
        }
    }
}
