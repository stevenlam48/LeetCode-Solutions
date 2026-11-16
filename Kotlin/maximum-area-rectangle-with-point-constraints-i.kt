package maximumarearectanglewithpointconstraintsi

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
    fun maxRectangleArea(points: Array<IntArray>): Int {
        points.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        val sortedYs = sortedSetOf<Int>()
        for (p in points) {
            sortedYs.add(p[1])
        }
        val yToIdx = HashMap<Int, Int>()
        for (y in sortedYs) {
            yToIdx[y] = yToIdx.size
        }
        val bit = BIT(yToIdx.size)
        val lookup = HashMap<Int, HashMap<Int, Pair<Int, Int>>>()
        var result = -1
        var prevX = -1
        var prevY = -1
        for (p in points) {
            val x = p[0]
            val y = p[1]
            val yIdx = yToIdx[y]!!
            bit.add(yIdx, 1)
            if (x == prevX) {
                val prevYIdx = yToIdx[prevY]!!
                val curr = bit.query(yIdx) - bit.query(prevYIdx - 1)
                val (prev, prevX2) = lookup.getOrPut(prevYIdx) { HashMap() }[yIdx] ?: (0 to 0)
                if (prev != 0 && prev == curr - 2) {
                    result = maxOf(result, (x - prevX2) * (y - prevY))
                }
                lookup[prevYIdx]!![yIdx] = curr to x
            }
            prevX = x
            prevY = y
        }
        return result
    }
}
