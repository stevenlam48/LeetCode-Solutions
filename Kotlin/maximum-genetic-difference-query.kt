package maximumgeneticdifferencequery

// Time:  O(nlogk + mlogk), k is max(max(vals), n-1)
// Space: O(n + logk)

class Solution {
    private class Trie(private val bitLength: Int) {
        private val nodes = mutableListOf(IntArray(3))
        private val pools = mutableListOf<Int>()

        fun insert(num: Int, v: Int) {
            var idx = 0
            for (i in bitLength downTo 0) {
                val curr = (num shr i) and 1
                if (nodes[idx][curr] == 0) {
                    if (pools.isNotEmpty()) {
                        nodes[idx][curr] = pools.removeAt(pools.size - 1)
                    } else {
                        nodes.add(IntArray(3))
                        nodes[idx][curr] = nodes.size - 1
                    }
                }
                val newIdx = nodes[idx][curr]
                nodes[newIdx][2] += v
                if (nodes[newIdx][2] == 0) {
                    nodes[idx][curr] = 0
                    pools.add(newIdx)
                }
                idx = newIdx
            }
        }

        fun query(num: Int): Int {
            var result = 0
            var idx = 0
            for (i in bitLength downTo 0) {
                val curr = (num shr i) and 1
                if (nodes[idx][1 xor curr] != 0) {
                    idx = nodes[idx][1 xor curr]
                    result = result or (1 shl i)
                } else {
                    idx = nodes[idx][curr]
                }
            }
            return result
        }
    }

    fun maxGeneticDifference(parents: IntArray, queries: Array<IntArray>): IntArray {
        val adj = HashMap<Int, MutableList<Int>>()
        for (i in parents.indices) {
            adj.getOrPut(parents[i]) { mutableListOf() }.add(i)
        }
        var maxVal = parents.size - 1
        val qs = HashMap<Int, MutableList<Pair<Int, Int>>>()
        for (i in queries.indices) {
            qs.getOrPut(queries[i][0]) { mutableListOf() }.add(Pair(i, queries[i][1]))
            maxVal = maxOf(maxVal, queries[i][1])
        }
        val result = IntArray(queries.size)
        val trie = Trie(bitLength(maxVal))
        iterDfs(adj, qs, adj[-1]!![0], trie, result)
        return result
    }

    private fun iterDfs(
        adj: HashMap<Int, MutableList<Int>>,
        qs: HashMap<Int, MutableList<Pair<Int, Int>>>,
        node: Int,
        trie: Trie,
        result: IntArray
    ) {
        val stk = ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(1, node))
        while (stk.isNotEmpty()) {
            val top = stk.removeLast()
            val step = top[0]
            val cur = top[1]
            if (step == 1) {
                trie.insert(cur, 1)
                qs[cur]?.let { list ->
                    for ((i, v) in list) {
                        result[i] = trie.query(v)
                    }
                }
                stk.addLast(intArrayOf(2, cur))
                adj[cur]?.let { children ->
                    for (child in children) {
                        stk.addLast(intArrayOf(1, child))
                    }
                }
            } else if (step == 2) {
                trie.insert(cur, -1)
            }
        }
    }

    private fun bitLength(x: Int): Int = if (x != 0) 32 - Integer.numberOfLeadingZeros(x) else 1
}
