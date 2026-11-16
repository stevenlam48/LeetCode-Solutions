package designinmemoryfilesystem

// Time:  ls: O(l + klogk), l is the path length, k is the number of entries in the last level directory
//        mkdir: O(l)
//        addContentToFile: O(l + c), c is the content size
//        readContentFromFile: O(l + c)
// Space: O(n + s), n is the number of dir/file nodes, s is the total content size.
class FileSystem {
    private class TrieNode {
        var isFile = false
        val children = HashMap<String, TrieNode>()
        var content = ""
    }

    private val root = TrieNode()

    fun ls(path: String): List<String> {
        val current = getNode(path)
        if (current.isFile) {
            return listOf(split(path).last())
        }
        return current.children.keys.sorted()
    }

    fun mkdir(path: String) {
        putNode(path).isFile = false
    }

    fun addContentToFile(filePath: String, content: String) {
        val current = putNode(filePath)
        current.isFile = true
        current.content += content
    }

    fun readContentFromFile(filePath: String): String = getNode(filePath).content

    private fun getNode(path: String): TrieNode {
        var current = root
        for (component in split(path)) {
            current = current.children.getValue(component)
        }
        return current
    }

    private fun putNode(path: String): TrieNode {
        var current = root
        for (component in split(path)) {
            current = current.children.getOrPut(component) { TrieNode() }
        }
        return current
    }

    private fun split(path: String): List<String> = path.split('/').filter { it.isNotEmpty() }
}
