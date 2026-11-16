package removecomments
// Time:  O(n), n is the length of the source
// Space: O(k), k is the max length of a line

class Solution {
    fun removeComments(source: List<String>): List<String> {
        var inBlock = false
        val result = mutableListOf<String>()
        val newline = StringBuilder()
        for (line in source) {
            var i = 0
            while (i < line.length) {
                if (!inBlock && i + 1 < line.length && line.substring(i, i + 2) == "/*") {
                    inBlock = true
                    ++i
                } else if (inBlock && i + 1 < line.length && line.substring(i, i + 2) == "*/") {
                    inBlock = false
                    ++i
                } else if (!inBlock && i + 1 < line.length && line.substring(i, i + 2) == "//") {
                    break
                } else if (!inBlock) {
                    newline.append(line[i])
                }
                ++i
            }
            if (!inBlock && newline.isNotEmpty()) {
                result.add(newline.toString())
                newline.setLength(0)
            }
        }
        return result
    }
}
