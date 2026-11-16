package maximizevalueoffunctioninaballpassinggame

// Time:  O(n)
// Space: O(n)

class Solution {
    fun getMaxFunctionValue(receiver: IntArray, k: Long): Long {
        fun findCycles(adj: IntArray): List<Pair<Int, Int>> {
            val result = mutableListOf<Pair<Int, Int>>()
            val lookup = IntArray(adj.size)
            var idx = 0
            for (i in adj.indices) {
                var u = i
                val prev = idx
                while (lookup[u] == 0) {
                    lookup[u] = ++idx
                    u = adj[u]
                }
                if (lookup[u] > prev) {
                    result.add(u to idx - lookup[u] + 1)
                }
            }
            return result
        }

        val cycles = findCycles(receiver)
        val lookup = Array(receiver.size) { -1 to -1 }
        val prefixes = Array(cycles.size) { mutableListOf(0L) }

        for (idx in cycles.indices) {
            var (u, l) = cycles[idx]
            for (i in 0 until l) {
                lookup[u] = idx to i
                prefixes[idx].add(prefixes[idx][i] + u)
                u = receiver[u]
            }
        }

        fun getSum(prefix: List<Long>, i: Long, count: Long): Long {
            val l = (prefix.size - 1).toLong()
            val q = count / l
            val r = count % l
            return q * prefix.last() +
                (prefix[minOf(i + r, l).toInt()] - prefix[i.toInt()]) +
                (prefix[maxOf(i + r - l, 0L).toInt()] - prefix[0])
        }

        var result = 0L
        for ((u0, l) in cycles) {
            var u = u0
            for (x in 0 until l) {
                val (idx, i) = lookup[u]
                result = maxOf(result, getSum(prefixes[idx], i.toLong(), k + 1))
                u = receiver[u]
            }
        }

        val degree = IntArray(receiver.size)
        for (x in receiver) {
            ++degree[x]
        }
        for (u0 in receiver.indices) {
            if (degree[u0] != 0) {
                continue
            }
            var curr = 0L
            val dq = ArrayDeque<Int>()
            var v = u0
            while (lookup[v].first == -1) {
                curr += v
                dq.addLast(v)
                if (dq.size.toLong() == k + 1) {
                    result = maxOf(result, curr)
                    curr -= dq.removeFirst()
                }
                v = receiver[v]
            }
            val (idx, i) = lookup[v]
            while (dq.isNotEmpty()) {
                result = maxOf(
                    result,
                    curr + getSum(prefixes[idx], i.toLong(), (k + 1) - dq.size.toLong())
                )
                curr -= dq.removeFirst()
            }
        }
        return result
    }
}
