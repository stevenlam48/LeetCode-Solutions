package minimumrunestoaddtocastspell

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minRunesToAdd(n: Int, crystals: IntArray, flowFrom: IntArray, flowTo: IntArray): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        for (i in flowFrom.indices) {
            adj[flowFrom[i]].add(flowTo[i])
        }
        val sccs = stronglyConnectedComponents(adj)
        val lookup = IntArray(n) { -1 }
        for (i in sccs.indices) {
            for (x in sccs[i]) {
                lookup[x] = i
            }
        }
        val result = BooleanArray(sccs.size)
        for (u in 0 until n) {
            for (v in adj[u]) {
                if (lookup[v] != lookup[u]) {
                    result[lookup[v]] = true
                }
            }
        }
        for (x in crystals) {
            result[lookup[x]] = true
        }
        return result.count { !it }
    }

    private fun stronglyConnectedComponents(adj: Array<MutableList<Int>>): List<List<Int>> {
        var indexCounter = 0
        val index = IntArray(adj.size) { -1 }
        val lowlinks = IntArray(adj.size) { -1 }
        val stack = ArrayDeque<Int>()
        val stackSet = BooleanArray(adj.size)
        val result = mutableListOf<List<Int>>()
        for (v in adj.indices) {
            if (index[v] == -1) {
                indexCounter = strongconnect(adj, v, indexCounter, index, lowlinks, stack, stackSet, result)
            }
        }
        return result
    }

    private fun strongconnect(
        adj: Array<MutableList<Int>>,
        v: Int,
        indexCounter: Int,
        index: IntArray,
        lowlinks: IntArray,
        stack: ArrayDeque<Int>,
        stackSet: BooleanArray,
        result: MutableList<List<Int>>
    ): Int {
        var counter = indexCounter
        index[v] = counter
        lowlinks[v] = counter
        ++counter
        stackSet[v] = true
        stack.addLast(v)
        for (w in adj[v]) {
            if (index[w] == -1) {
                counter = strongconnect(adj, w, counter, index, lowlinks, stack, stackSet, result)
                lowlinks[v] = minOf(lowlinks[v], lowlinks[w])
            } else if (stackSet[w]) {
                lowlinks[v] = minOf(lowlinks[v], index[w])
            }
        }
        if (lowlinks[v] == index[v]) {
            val connectedComponent = mutableListOf<Int>()
            var w = -1
            while (w != v) {
                w = stack.removeLast()
                stackSet[w] = false
                connectedComponent.add(w)
            }
            result.add(connectedComponent)
        }
        return counter
    }
}
