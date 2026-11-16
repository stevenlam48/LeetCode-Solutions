package detectsquares

// Time:  ctor:  O(1)
//        add:   O(1)
//        count: O(n)
// Space: O(n)

class DetectSquares {
    private val xToYs = HashMap<Int, HashSet<Int>>()
    private val pointCounts = HashMap<Int, HashMap<Int, Int>>()

    fun add(point: IntArray) {
        xToYs.getOrPut(point[0]) { HashSet() }.add(point[1])
        val ys = pointCounts.getOrPut(point[0]) { HashMap() }
        ys[point[1]] = ys.getOrDefault(point[1], 0) + 1
    }

    fun count(point: IntArray): Int {
        var result = 0
        for (y in xToYs.getOrPut(point[0]) { HashSet() }) {
            if (y == point[1]) {
                continue
            }
            val dy = point[1] - y
            result += countAt(point[0], y) * countAt(point[0] + dy, point[1]) *
                countAt(point[0] + dy, y)
            result += countAt(point[0], y) * countAt(point[0] - dy, point[1]) *
                countAt(point[0] - dy, y)
        }
        return result
    }

    private fun countAt(x: Int, y: Int): Int =
        pointCounts[x]?.getOrDefault(y, 0) ?: 0
}
