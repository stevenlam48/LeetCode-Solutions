package cutofftreesforgolfevent

import java.util.PriorityQueue

// Time:  O(t * (logt + m * n)), t is the number of trees
// Space: O(t + m * n)

class Solution {
    fun cutOffTree(forest: Array<IntArray>): Int {
        val m = forest.size
        val n = forest[0].size
        val minHeap = PriorityQueue<IntArray>(
            Comparator { a: IntArray, b: IntArray ->
                compareValuesBy(a, b, { it[0] }, { it[1] }, { it[2] })
            }
        )

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (forest[i][j] > 1) {
                    minHeap.add(intArrayOf(forest[i][j], i, j))
                }
            }
        }

        var start = intArrayOf(0, 0)
        var result = 0
        while (minHeap.isNotEmpty()) {
            val tree = minHeap.poll()
            val step = minStep(forest, start, intArrayOf(tree[1], tree[2]), m, n)
            if (step < 0) {
                return -1
            }
            result += step
            start = intArrayOf(tree[1], tree[2])
        }
        return result
    }

    private fun minStep(forest: Array<IntArray>, start: IntArray, end: IntArray, m: Int, n: Int): Int {
        var minSteps = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1])
        val lookup = HashSet<Int>()
        var closer = ArrayDeque<IntArray>().apply { addLast(start) }
        var detour = ArrayDeque<IntArray>()
        while (true) {
            if (closer.isEmpty()) {
                if (detour.isEmpty()) {
                    return -1
                }
                minSteps += 2
                val tmp = closer
                closer = detour
                detour = tmp
            }
            val cur = closer.removeLast()
            val i = cur[0]
            val j = cur[1]
            if (i == end[0] && j == end[1]) {
                return minSteps
            }
            if (i * n + j !in lookup) {
                lookup.add(i * n + j)
                val expansions = arrayOf(
                    intArrayOf(i + 1, j),
                    intArrayOf(i - 1, j),
                    intArrayOf(i, j + 1),
                    intArrayOf(i, j - 1),
                )
                for (e in expansions) {
                    val I = e[0]
                    val J = e[1]
                    if (I in 0 until m && J in 0 until n &&
                        forest[I][J] != 0 && I * n + J !in lookup
                    ) {
                        val isCloser = (I - i) * (end[0] - i) + (J - j) * (end[1] - j) > 0
                        if (isCloser) closer.addLast(e) else detour.addLast(e)
                    }
                }
            }
        }
    }
}
