package secondminimumtimetoreachdestination

// Time:  O(|V| + |E|) = O(|E|) since graph is connected, O(|E|) >= O(|V|)
// Space: O(|V| + |E|) = O(|E|)

class Solution {
    fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            adj[edge[0] - 1].add(edge[1] - 1)
            adj[edge[1] - 1].add(edge[0] - 1)
        }
        return calcTime(time, change, biBfs(adj, 0, n - 1))
    }

    private fun biBfs(adj: Array<MutableList<Int>>, start: Int, end: Int): Int {
        var left = hashSetOf(start)
        var right = hashSetOf(end)
        val lookup = hashSetOf<Int>()
        var result = 0
        var steps = 0
        while (left.isNotEmpty() && (result == 0 || result + 2 > steps)) {
            for (u in left) {
                lookup.add(u)
            }
            val newLeft = hashSetOf<Int>()
            for (u in left) {
                if (u in right) {
                    if (result == 0) {
                        result = steps
                    } else if (result < steps) {
                        return result + 1
                    }
                }
                for (v in adj[u]) {
                    if (v in lookup) {
                        continue
                    }
                    newLeft.add(v)
                }
            }
            left = newLeft
            ++steps
            if (left.size > right.size) {
                val temp = left
                left = right
                right = temp
            }
        }
        return result + 2
    }

    private fun calcTime(time: Int, change: Int, dist: Int): Int {
        var result = 0
        var remaining = dist
        while (remaining-- > 0) {
            if (result / change % 2 != 0) {
                result = (result / change + 1) * change
            }
            result += time
        }
        return result
    }
}
