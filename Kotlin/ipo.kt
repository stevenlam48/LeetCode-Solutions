package ipo

import java.util.PriorityQueue

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun findMaximizedCapital(k: Int, W: Int, Profits: IntArray, Capital: IntArray): Int {
        val future = ArrayList<Pair<Int, Int>>()
        for (i in Profits.indices) {
            future.add(Pair(Capital[i], Profits[i]))
        }
        future.sortWith(
            compareByDescending<Pair<Int, Int>> { it.first }.thenByDescending { it.second }
        )

        val curr = PriorityQueue<Int>(compareByDescending { it })
        var w = W
        repeat(k) {
            while (future.isNotEmpty() && future[future.size - 1].first <= w) {
                curr.add(future.removeAt(future.size - 1).second)
            }
            if (curr.isNotEmpty()) {
                w += curr.poll()
            }
        }
        return w
    }
}
