package pathcrossing

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isPathCrossing(path: String): Boolean {
        val lookup = hashSetOf(Pair(0, 0))
        var x = 0
        var y = 0
        for (c in path) {
            when (c) {
                'E' -> ++x
                'W' -> --x
                'N' -> ++y
                'S' -> --y
            }
            if (!lookup.add(Pair(x, y))) {
                return true
            }
        }
        return false
    }
}
