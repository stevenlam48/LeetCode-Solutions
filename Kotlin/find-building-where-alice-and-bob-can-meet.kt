package findbuildingwherealiceandbobcanmeet

// Time:  O(n + qlogn)
// Space: O(n)

class Solution {
    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        val result = IntArray(queries.size) { -1 }
        val segmentTree = SegmentTree(heights)
        for (i in queries.indices) {
            var a = queries[i][0]
            var b = queries[i][1]
            if (a > b) {
                val temp = a
                a = b
                b = temp
            }
            if (a == b || heights[a] < heights[b]) {
                result[i] = b
                continue
            }
            result[i] = segmentTree.binarySearch(b + 1, heights.lastIndex, 0, heights.lastIndex, 1, heights[a])
        }
        return result
    }

    private class SegmentTree(private val heights: IntArray) {
        private val tree = IntArray(
            if (heights.size > 1) {
                1 shl ((31 - (heights.size - 1).countLeadingZeroBits()) + 2)
            } else {
                2
            }
        )

        init {
            build(0, heights.lastIndex, 1)
        }

        private fun build(left: Int, right: Int, index: Int) {
            if (left == right) {
                tree[index] = heights[left]
                return
            }
            val mid = left + (right - left) / 2
            build(left, mid, index * 2)
            build(mid + 1, right, index * 2 + 1)
            tree[index] = maxOf(tree[index * 2], tree[index * 2 + 1])
        }

        fun binarySearch(
            queryLeft: Int,
            queryRight: Int,
            left: Int,
            right: Int,
            index: Int,
            height: Int
        ): Int {
            if (right < queryLeft || left > queryRight) {
                return -1
            }
            if (queryLeft <= left && right <= queryRight) {
                if (tree[index] <= height) {
                    return -1
                }
                if (left == right) {
                    return left
                }
            }
            val mid = left + (right - left) / 2
            val result = binarySearch(queryLeft, queryRight, left, mid, index * 2, height)
            return if (result != -1) {
                result
            } else {
                binarySearch(queryLeft, queryRight, mid + 1, right, index * 2 + 1, height)
            }
        }
    }
}
