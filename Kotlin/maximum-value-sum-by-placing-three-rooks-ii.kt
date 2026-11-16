package maximumvaluesumbyplacingthreerooksii

import java.util.PriorityQueue

// Time:  O(m * n * logk + nCr((k-1)*(2*k-1)+1), k) * k) = O(m * n)
// Space: O(k * (m + n)) = O(m + n)

class Solution {
    fun maximumValueSum(board: Array<IntArray>): Long {
        val k = 3

        val cmp = compareBy<Triple<Int, Int, Int>>({ it.first }, { it.second }, { it.third })
        val minHeaps = Array(board[0].size) { PriorityQueue<Triple<Int, Int, Int>>(cmp) }
        for (i in board.indices) {
            val minHeap = PriorityQueue<Triple<Int, Int, Int>>(cmp)
            for (j in board[0].indices) {
                minHeap.add(Triple(board[i][j], i, j))
                if (minHeap.size == k + 1) {
                    minHeap.poll()
                }
            }
            while (minHeap.isNotEmpty()) {
                val (v, ii, jj) = minHeap.poll()
                minHeaps[jj].add(Triple(v, ii, jj))
                if (minHeaps[jj].size == k + 1) {
                    minHeaps[jj].poll()
                }
            }
        }
        val minHeap = PriorityQueue<Triple<Int, Int, Int>>(cmp)
        for (h in minHeaps) {
            while (h.isNotEmpty()) {
                val x = h.poll()
                minHeap.add(x)
                if (minHeap.size == (k - 1) * (2 * k - 1) + 1 + 1) {
                    minHeap.poll()
                }
            }
        }
        var result = Long.MIN_VALUE
        val candidates = ArrayList<Triple<Int, Int, Int>>()
        while (minHeap.isNotEmpty()) {
            candidates.add(minHeap.poll())
        }
        val c = candidates.size
        for (a in 0 until c) {
            for (b in a + 1 until c) {
                for (d in b + 1 until c) {
                    val x = candidates[a]
                    val y = candidates[b]
                    val z = candidates[d]
                    if ((x.second != y.second && y.second != z.second && z.second != x.second) &&
                        (x.third != y.third && y.third != z.third && z.third != x.third)
                    ) {
                        result = maxOf(result, x.first.toLong() + y.first + z.first)
                    }
                }
            }
        }
        return result
    }
}
