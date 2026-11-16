package frogpositionaftertseconds

// Time:  O(n)
// Space: O(n)

// bfs solution with better precision
class Solution {
    fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
        val G = HashMap<Int, MutableList<Int>>()
        G[1] = mutableListOf()
        for (edge in edges) {
            G.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            G.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }

        var stk = mutableListOf(intArrayOf(t, 1, 0, 1))
        while (stk.isNotEmpty()) {
            val newStk = mutableListOf<IntArray>()
            while (stk.isNotEmpty()) {
                val cur = stk.removeAt(stk.size - 1)
                val time = cur[0]
                val node = cur[1]
                val parent = cur[2]
                val choices = cur[3]
                if (time == 0 || G[node]!!.size - (if (parent != 0) 1 else 0) == 0) {
                    if (node == target) {
                        return 1.0 / choices
                    }
                    continue
                }
                for (child in G[node]!!) {
                    if (child == parent) {
                        continue
                    }
                    newStk.add(
                        intArrayOf(
                            time - 1, child, node,
                            choices * (G[node]!!.size - (if (parent != 0) 1 else 0))
                        )
                    )
                }
            }
            stk = newStk
        }
        return 0.0
    }
}
