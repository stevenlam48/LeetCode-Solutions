package rectangleareaii

import java.util.TreeSet

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun rectangleArea(rectangles: Array<IntArray>): Int {
        if (rectangles.isEmpty()) {
            return 0
        }
        val events = ArrayList<IntArray>()
        val xVals = TreeSet<Int>()
        for (rec in rectangles) {
            events.add(intArrayOf(rec[1], OPEN, rec[0], rec[2]))
            events.add(intArrayOf(rec[3], CLOSE, rec[0], rec[2]))
            xVals.add(rec[0])
            xVals.add(rec[2])
        }
        events.sortWith(compareBy({ it[0] }, { it[1] }, { it[2] }, { it[3] }))
        val X = xVals.toIntArray()
        val xi = HashMap<Int, Int>()
        for (i in X.indices) {
            xi[X[i]] = i
        }

        val st = SegmentTreeNode(0, X.size - 1, X)
        var result = 0L
        var curXSum = 0L
        var curY = events[0][0]
        for (event in events) {
            val y = event[0]
            val type = event[1]
            val x1 = event[2]
            val x2 = event[3]
            result += curXSum * (y - curY)
            curXSum = st.update(xi[x1]!!, xi[x2]!!, type)
            curY = y
        }
        return (result % (1e9 + 7).toLong()).toInt()
    }

    private class SegmentTreeNode(val start: Int, val end: Int, val X: IntArray) {
        private var leftNode: SegmentTreeNode? = null
        private var rightNode: SegmentTreeNode? = null
        private var count = 0
        var total = 0L

        private fun mid(): Int {
            return start + (end - start) / 2
        }

        private fun left(): SegmentTreeNode {
            if (leftNode == null) {
                leftNode = SegmentTreeNode(start, mid(), X)
            }
            return leftNode!!
        }

        private fun right(): SegmentTreeNode {
            if (rightNode == null) {
                rightNode = SegmentTreeNode(mid(), end, X)
            }
            return rightNode!!
        }

        fun update(i: Int, j: Int, v: Int): Long {
            if (i >= j) {
                return 0L
            }
            if (start == i && end == j) {
                count += v
            } else {
                left().update(i, minOf(mid(), j), v)
                right().update(maxOf(mid(), i), j, v)
            }
            total = if (count > 0) {
                (X[end] - X[start]).toLong()
            } else {
                left().total + right().total
            }
            return total
        }
    }

    companion object {
        private const val OPEN = 1
        private const val CLOSE = -1
    }
}
