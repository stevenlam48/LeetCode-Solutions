package maximumarearectanglewithpointconstraintsii

// Time:  O(nlogn)
// Space: O(n)

private class BIT(n: Int) {
    private val bit = IntArray(n + 1)

    fun add(i: Int, value: Int) {
        var index = i + 1
        while (index < bit.size) {
            bit[index] += value
            index += index and -index
        }
    }

    fun query(i: Int): Int {
        var index = i + 1
        var total = 0
        while (index > 0) {
            total += bit[index]
            index -= index and -index
        }
        return total
    }
}

class Solution {
    fun maxRectangleArea(xCoord: IntArray, yCoord: IntArray): Long {
        val points = Array(xCoord.size) { i -> xCoord[i] to yCoord[i] }
        points.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        val sortedYs = sortedSetOf<Int>()
        for (point in points) {
            sortedYs.add(point.second)
        }
        val yToIdx = HashMap<Int, Int>()
        for (y in sortedYs) {
            yToIdx[y] = yToIdx.size
        }
        val bit = BIT(yToIdx.size)
        val lookup = HashMap<Int, HashMap<Int, Pair<Int, Int>>>()
        var result = -1L
        var prevX = -1
        var prevY = -1
        for ((x, y) in points) {
            val yIdx = yToIdx[y]!!
            bit.add(yIdx, 1)
            if (x == prevX) {
                val prevYIdx = yToIdx[prevY]!!
                val curr = bit.query(yIdx) - bit.query(prevYIdx - 1)
                val (prev, prevX2) = lookup.getOrPut(prevYIdx) { HashMap() }[yIdx] ?: (0 to 0)
                if (prev != 0 && prev == curr - 2) {
                    result = maxOf(result, (x - prevX2).toLong() * (y - prevY))
                }
                lookup[prevYIdx]!![yIdx] = curr to x
            }
            prevX = x
            prevY = y
        }
        return result
    }
}
