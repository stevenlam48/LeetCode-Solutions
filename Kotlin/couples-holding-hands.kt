package couplesholdinghands

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minSwapsCouples(row: IntArray): Int {
        val n = row.size / 2
        val couples = Array(n) { mutableListOf<Int>() }
        for (seat in row.indices) {
            couples[row[seat] / 2].add(seat / 2)
        }
        val adj = Array(n) { mutableListOf<Int>() }
        for (couple in couples) {
            adj[couple[0]].add(couple[1])
            adj[couple[1]].add(couple[0])
        }

        var result = 0
        for (couch in 0 until n) {
            if (adj[couch].isEmpty()) {
                continue
            }
            var couch1 = couch
            var couch2 = adj[couch1].removeAt(adj[couch1].lastIndex)
            while (couch2 != couch) {
                ++result
                adj[couch2].removeAt(adj[couch2].indexOf(couch1))
                couch1 = couch2
                couch2 = adj[couch1].removeAt(adj[couch1].lastIndex)
            }
        }
        return result
    }
}
