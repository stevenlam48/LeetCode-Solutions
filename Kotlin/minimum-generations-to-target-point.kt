package minimumgenerationstotargetpoint

// Time:  O(7^6)
// Space: O(7^3)

// bfs
class Solution {
    fun minGenerations(points: Array<IntArray>, target: IntArray): Int {
        val encode = { p: IntArray -> p[0] * 7 * 7 + p[1] * 7 + p[2] }

        val lookup = BooleanArray(7 * 7 * 7)
        var k = 0
        var total = 0
        for (p in points) {
            if (lookup[encode(p)]) {
                continue
            }
            if (p.contentEquals(target)) {
                return k
            }
            lookup[encode(p)] = true
        }
        val pts = points.toMutableList()
        var i = 0
        while (i < pts.size) {
            if (i == total) {
                total = pts.size
                ++k
            }
            for (j in 0 until i) {
                val p = intArrayOf(
                    (pts[i][0] + pts[j][0]) / 2,
                    (pts[i][1] + pts[j][1]) / 2,
                    (pts[i][2] + pts[j][2]) / 2
                )
                if (lookup[encode(p)]) {
                    continue
                }
                if (p.contentEquals(target)) {
                    return k
                }
                lookup[encode(p)] = true
                pts.add(p)
            }
            ++i
        }
        return -1
    }
}
