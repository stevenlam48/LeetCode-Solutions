package minimizehammingdistanceafterswapoperations

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
        val adj = Array(source.size) { HashSet<Int>() }
        for (swap in allowedSwaps) {
            adj[swap[0]].add(swap[1])
            adj[swap[1]].add(swap[0])
        }
        val lookup = BooleanArray(source.size)
        var result = 0
        for (i in source.indices) {
            if (lookup[i]) {
                continue
            }
            val idxs = ArrayList<Int>()
            iterFloodFill(adj, i, lookup, idxs)
            val sourceCnt = HashMap<Int, Int>()
            val targetCnt = HashMap<Int, Int>()
            for (idx in idxs) {
                sourceCnt[source[idx]] = (sourceCnt[source[idx]] ?: 0) + 1
                targetCnt[target[idx]] = (targetCnt[target[idx]] ?: 0) + 1
            }
            for ((value, count) in sourceCnt) {
                result += maxOf(count - (targetCnt[value] ?: 0), 0)
            }
        }
        return result
    }

    private fun iterFloodFill(
        adj: Array<HashSet<Int>>,
        node: Int,
        lookup: BooleanArray,
        idxs: MutableList<Int>
    ) {
        val stack = java.util.ArrayDeque<Int>()
        stack.add(node)
        while (stack.isNotEmpty()) {
            val curr = stack.removeLast()
            if (lookup[curr]) {
                continue
            }
            lookup[curr] = true
            idxs.add(curr)
            for (child in adj[curr]) {
                stack.add(child)
            }
        }
    }
}
