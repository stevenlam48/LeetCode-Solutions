package linereflection
// Time:  O(n)
// Space: O(n)

class Solution {
    fun isReflected(points: Array<Pair<Int, Int>>): Boolean {
        if (points.isEmpty()) {
            return true
        }
        val groupsByY = HashMap<Int, MutableSet<Int>>()
        var left = Int.MAX_VALUE
        var right = Int.MIN_VALUE
        for (p in points) {
            groupsByY.getOrPut(p.second) { HashSet() }.add(p.first)
            left = minOf(left, p.first)
            right = maxOf(right, p.first)
        }
        val mid = left + right
        for ((_, xs) in groupsByY) {
            for (x in xs) {
                if (mid - x !in xs) {
                    return false
                }
            }
        }
        return true
    }
}
