package collectcoinsinatree

// Time:  O(n)
// Space: O(n)


class Solution {
    fun collectTheCoins(coins: IntArray, edges: Array<IntArray>): Int {
        val adj = Array(coins.size) { HashSet<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        var n = coins.size
        for (i in coins.indices) {
            var u = i
            while (adj[u].size == 1 && coins[u] == 0) {
                val v = adj[u].first()
                adj[u].remove(v)
                adj[v].remove(u)
                --n
                u = v
            }
        }
        var q = ArrayList<Int>()
        for (u in coins.indices) {
            if (adj[u].size == 1) {
                q.add(u)
            }
        }
        repeat(2) {
            val newQ = ArrayList<Int>()
            for (u in q) {
                if (adj[u].isEmpty()) {
                    break
                }
                val v = adj[u].first()
                adj[u].remove(v)
                adj[v].remove(u)
                --n
                if (adj[v].size == 1) {
                    newQ.add(v)
                }
            }
            q = newQ
        }
        return (n - 1) * 2
    }
}
