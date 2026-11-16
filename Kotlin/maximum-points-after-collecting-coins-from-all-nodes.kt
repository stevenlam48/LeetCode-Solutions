package maximumpointsaftercollectingcoinsfromallnodes
// Time:  O(nlogr), r = max(coins)
// Space: O(n)

class Solution {
    fun maximumPoints(edges: Array<IntArray>, coins: IntArray, k: Int): Int {
        val negativeInfinity = Int.MIN_VALUE
        val adj = Array(coins.size) { mutableListOf<Int>() }
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }
        val maximum = coins.maxOrNull()!!
        val maxBase = 1 shl (if (maximum != 0) Integer.numberOfTrailingZeros(Integer.highestOneBit(maximum)) + 1 else 0)
        val lookup = IntArray(coins.size)

        fun dfs(u: Int, parent: Int, base: Int): Int {
            if (base >= maxBase) {
                return 0
            }
            if (lookup[u] and base != 0) {
                return negativeInfinity
            }
            lookup[u] = lookup[u] or base
            var total1 = coins[u] / base - k
            for (v in adj[u]) {
                if (v == parent) {
                    continue
                }
                val result = dfs(v, u, base)
                if (result == negativeInfinity) {
                    total1 = result
                    break
                }
                total1 += result
            }
            if (coins[u] / base - k >= coins[u] / (base shl 1)) {
                return total1
            }
            var total2 = coins[u] / (base shl 1)
            for (v in adj[u]) {
                if (v == parent) {
                    continue
                }
                val result = dfs(v, u, base shl 1)
                if (result == negativeInfinity) {
                    total2 = result
                    break
                }
                total2 += result
            }
            return maxOf(total1, total2)
        }

        return dfs(0, -1, 1)
    }
}
