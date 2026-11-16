package simplifypath

// Time:  O(n)
// Space: O(n)
class Solution {
    fun simplifyPath(path: String): String {
        val names = mutableListOf<String>()
        val tokens = path.split('/')
        for (token in tokens) {
            if (token == ".." && names.isNotEmpty()) {
                names.removeAt(names.lastIndex)
            } else if (token != ".." && token != "." && token.isNotEmpty()) {
                names.add(token)
            }
        }
        return "/" + names.joinToString("/")
    }
}
