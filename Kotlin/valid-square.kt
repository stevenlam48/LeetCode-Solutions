package validsquare

// Time:  O(1)
// Space: O(1)

class Solution {
    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        val lookup = HashSet<Int>()
        lookup.add(dist(p1, p2))
        lookup.add(dist(p1, p3))
        lookup.add(dist(p1, p4))
        lookup.add(dist(p2, p3))
        lookup.add(dist(p2, p4))
        lookup.add(dist(p3, p4))
        return !lookup.contains(0) && lookup.size == 2
    }

    private fun dist(p1: IntArray, p2: IntArray): Int {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) +
            (p1[1] - p2[1]) * (p1[1] - p2[1])
    }
}
