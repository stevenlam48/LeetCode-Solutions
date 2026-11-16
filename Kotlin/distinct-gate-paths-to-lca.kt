package distinctgatepathstolca

// Time:  O(nlogn + qlogn)
// Space: O(nlogn)

// dfs, binary lifting
class Solution {
    fun distinctPaths(n: Int, parent: IntArray, gates: Array<IntArray>, queries: Array<IntArray>): Int {
        val MOD = 1_000_000_007L
        val BB = 0
        val BR = 1
        val RB = 2
        val RR = 3

        fun ceilLog2(x: Int): Int {
            val v = x - 1
            return if (v == 0) 0 else 32 - Integer.numberOfLeadingZeros(v)
        }

        fun mult(x: LongArray, y: LongArray): LongArray {
            return longArrayOf(
                (x[BB] * y[BB] + x[BR] * y[RB]) % MOD,
                (x[BB] * y[BR] + x[BR] * y[RR]) % MOD,
                (x[RB] * y[BB] + x[RR] * y[RB]) % MOD,
                (x[RB] * y[BR] + x[RR] * y[RR]) % MOD
            )
        }

        val depth = IntArray(n)
        val levels = ceilLog2(n - 1) + 1
        val par = Array(levels) { IntArray(n) }

        fun lca(a0: Int, b0: Int): Int {
            var a = a0
            var b = b0
            if (depth[a] < depth[b]) {
                val tmp = a
                a = b
                b = tmp
            }
            val d = depth[a] - depth[b]
            for (k in 0 until par.size) {
                if (d and (1 shl k) != 0) {
                    a = par[k][a]
                }
            }
            if (a == b) {
                return a
            }
            for (k in par.size - 1 downTo 0) {
                if (par[k][a] == par[k][b]) {
                    continue
                }
                a = par[k][a]
                b = par[k][b]
            }
            return par[0][a]
        }

        val cnt = Array(levels) { Array(n) { LongArray(4) } }

        fun count(u0: Int, card: Int, t: Int): Long {
            if (u0 == t) {
                return 1
            }
            var u = u0
            val d = depth[u] - depth[t]
            var b = if (card == 0) 1L else 0L
            var r = if (card == 1) 1L else 0L
            for (k in 0 until par.size) {
                if (d and (1 shl k) == 0) {
                    continue
                }
                val nb = (b * cnt[k][u][BB] + r * cnt[k][u][RB]) % MOD
                val nr = (b * cnt[k][u][BR] + r * cnt[k][u][RR]) % MOD
                b = nb
                r = nr
                u = par[k][u]
            }
            return (b + r) % MOD
        }

        val adj = Array(n) { mutableListOf<Int>() }
        for (u in 0 until n) {
            if (parent[u] != -1) {
                adj[parent[u]].add(u)
            }
        }
        val stk = mutableListOf(0)
        while (stk.isNotEmpty()) {
            val u = stk.removeAt(stk.size - 1)
            for (v in adj[u]) {
                depth[v] = depth[u] + 1
                stk.add(v)
            }
        }
        for (u in 0 until n) {
            par[0][u] = parent[u]
            cnt[0][u] = longArrayOf(
                gates[u][1].toLong(), gates[u][2].toLong(),
                gates[u][2].toLong(), gates[u][0].toLong()
            )
        }
        for (k in 1 until par.size) {
            for (u in 0 until n) {
                if (par[k - 1][u] == -1) {
                    continue
                }
                par[k][u] = par[k - 1][par[k - 1][u]]
                cnt[k][u] = mult(cnt[k - 1][u], cnt[k - 1][par[k - 1][u]])
            }
        }
        var result = 0
        for (q in queries) {
            val l = lca(q[0], q[2])
            result = result xor (((count(q[0], q[1], l) * count(q[2], q[3], l)) % MOD).toInt())
        }
        return result
    }
}
