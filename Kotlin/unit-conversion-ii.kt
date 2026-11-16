package unitconversionii

// Time:  O(n + qlogm)
// Space: O(n)

class Solution {
    fun queryConversions(conversions: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val mod = 1_000_000_007

        fun powmod(initialA: Int, initialB: Int): Long {
            var a = initialA % mod
            var b = initialB
            var result = 1L
            while (b != 0) {
                if (b and 1 != 0) {
                    result = result * a % mod
                }
                a = (a.toLong() * a % mod).toInt()
                b = b shr 1
            }
            return result
        }

        fun divmod(a: Int, b: Int): Long {
            return a * powmod(b, mod - 2) % mod
        }

        val adj = Array(conversions.size + 1) { mutableListOf<Pair<Int, Int>>() }
        for (c in conversions) {
            adj[c[0]].add(c[1] to c[2])
        }
        val lookup = IntArray(adj.size)
        lookup[0] = 1
        var queue = listOf(0)
        while (queue.isNotEmpty()) {
            val newQueue = ArrayList<Int>()
            for (u in queue) {
                for ((v, w) in adj[u]) {
                    lookup[v] = (lookup[u].toLong() * w % mod).toInt()
                    newQueue.add(v)
                }
            }
            queue = newQueue
        }
        return IntArray(queries.size) { i ->
            divmod(lookup[queries[i][1]], lookup[queries[i][0]]).toInt()
        }
    }
}
