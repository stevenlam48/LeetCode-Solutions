package maximumxoroftwononoverlappingsubtrees

import java.util.ArrayDeque

// Time:  O(nlogr), r is sum(values)
// Space: O(n)

class Solution {
    private class Trie(private val bitLength: Int) {
        private val nodes = ArrayList<IntArray>()

        init {
            nodes.add(intArrayOf(0, 0))
        }

        fun insert(num: Long) {
            var idx = 0
            for (i in bitLength - 1 downTo 0) {
                val curr = ((num shr i) and 1L).toInt()
                if (nodes[idx][curr] == 0) {
                    nodes.add(intArrayOf(0, 0))
                    nodes[idx][curr] = nodes.size - 1
                }
                idx = nodes[idx][curr]
            }
        }

        fun query(num: Long): Long {
            if (nodes.size == 1) {
                return -1
            }
            var result = 0L
            var idx = 0
            for (i in bitLength - 1 downTo 0) {
                val curr = ((num shr i) and 1L).toInt()
                if (nodes[idx][1 xor curr] != 0) {
                    idx = nodes[idx][1 xor curr]
                    result = result or (1L shl i)
                } else {
                    idx = nodes[idx][curr]
                }
            }
            return result
        }
    }

    fun maxXor(n: Int, edges: Array<IntArray>, values: IntArray): Long {
        val adj = Array(values.size) { ArrayList<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }

        val lookup = LongArray(values.size)
        val stk = ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(1, 0, -1))
        while (stk.isNotEmpty()) {
            val f = stk.removeLast()
            val step = f[0]
            val u = f[1]
            val p = f[2]
            if (step == 1) {
                stk.addLast(intArrayOf(2, u, p))
                for (v in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    stk.addLast(intArrayOf(1, v, u))
                }
            } else if (step == 2) {
                lookup[u] = values[u].toLong()
                for (v in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    lookup[u] += lookup[v]
                }
            }
        }

        val trie = Trie(bitLength(lookup[0]))
        val accs = ArrayList<LongArray>()
        accs.add(longArrayOf(0L))
        val stk2 = ArrayDeque<IntArray>()
        stk2.addLast(intArrayOf(1, 0, -1, 0, -1))
        while (stk2.isNotEmpty()) {
            val f = stk2.removeLast()
            val step = f[0]
            val u = f[1]
            val p = f[2]
            val retId = f[3]
            val childId = f[4]
            if (step == 1) {
                accs[retId][0] = maxOf(accs[retId][0], trie.query(lookup[u]))
                stk2.addLast(intArrayOf(3, u, p, retId, -1))
                for (v in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    val newId = accs.size
                    accs.add(longArrayOf(0L))
                    stk2.addLast(intArrayOf(2, v, u, retId, newId))
                    stk2.addLast(intArrayOf(1, v, u, newId, -1))
                }
            } else if (step == 2) {
                accs[retId][0] = maxOf(accs[retId][0], accs[childId][0])
            } else if (step == 3) {
                trie.insert(lookup[u])
            }
        }
        return accs[0][0]
    }

    private fun bitLength(x: Long): Int {
        return if (x != 0L) 64 - java.lang.Long.numberOfLeadingZeros(x) else 1
    }
}
