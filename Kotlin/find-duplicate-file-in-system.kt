package findduplicatefileinsystem

// Time:  O(n * l), l is the average length of file content
// Space: O(n * l)

class Solution {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val files = HashMap<String, MutableList<String>>()
        for (path in paths) {
            val tokens = path.split(" ")
            val root = tokens[0]
            for (i in 1 until tokens.size) {
                val s = tokens[i]
                val fileName = root + "/" + s.substring(0, s.indexOf('('))
                val fileContent = s.substring(s.indexOf('(') + 1, s.indexOf(')'))
                files.getOrPut(fileContent) { mutableListOf() }.add(fileName)
            }
        }

        val result = mutableListOf<List<String>>()
        for (file in files.values) {
            if (file.size > 1) {
                result.add(file)
            }
        }
        return result
    }
}
