package minimumcostpathwithevenxorparity

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minActivationCost(edges: Array<IntArray>, values: IntArray): Int {
        val INF = Int.MAX_VALUE

        fun parity(x: Int): Int = Integer.bitCount(x) % 2

        val mn = IntArray(values.size) { INF }
        var result = INF
        for (e in edges) {
            var u = e[0]
            val v = e[1]
            val c = e[2]
            val i = parity(values[u])
            val j = parity(values[v])
            if (i == j) {
                result = minOf(result, c)
                continue
            }
            if (i > j) {
                u = v
            }
            if (mn[u] != INF) {
                result = minOf(result, mn[u] + c)
            }
            mn[u] = minOf(mn[u], c)
        }
        return if (result != INF) result else -1
    }
}
