package destinationcity

// Time:  O(n)
// Space: O(n)

class Solution {
    fun destCity(paths: Array<Array<String>>): String {
        val a = HashSet<String>()
        val b = HashSet<String>()
        for (path in paths) {
            a.add(path[0])
            b.add(path[1])
        }
        for (dst in b) {
            if (!a.contains(dst)) {
                return dst
            }
        }
        return ""
    }
}
