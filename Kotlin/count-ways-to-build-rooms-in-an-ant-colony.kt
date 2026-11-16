package countwaystobuildroomsinanantcolony

// Time:  O(n)
// Space: O(n)

private const val MOD = 1_000_000_007L

private val FACT = mutableListOf(1L, 1L)
private val INV = mutableListOf(0L, 1L)
private val INV_FACT = mutableListOf(1L, 1L)

private fun ensureFactorials(n: Int) {
    while (INV.size <= n) {
        val i = INV.size
        FACT.add(FACT.last() * i % MOD)
        INV.add(INV[(MOD % i).toInt()] * (MOD - MOD / i) % MOD)
        INV_FACT.add(INV_FACT.last() * INV.last() % MOD)
    }
}

private fun nCr(n: Int, k: Int): Long {
    return FACT[n] * INV_FACT[n - k] % MOD * INV_FACT[k] % MOD
}

class Solution {
    fun waysToBuildRooms(prevRoom: IntArray): Int {
        val n = prevRoom.size
        val adj = Array(n) { mutableListOf<Int>() }
        for (i in 1 until n) {
            adj[prevRoom[i]].add(i)
        }
        ensureFactorials(n)

        val ways = IntArray(n)
        val cnt = IntArray(n)
        val order = IntArray(n)
        val stack = IntArray(n)
        var size = 0
        var top = 0
        stack[top++] = 0
        while (top > 0) {
            val u = stack[--top]
            order[size++] = u
            for (child in adj[u]) {
                stack[top++] = child
            }
        }
        for (t in size - 1 downTo 0) {
            val u = order[t]
            var totalWays = 1L
            var totalCnt = 0
            for (child in adj[u]) {
                totalCnt += cnt[child]
                totalWays = totalWays * ways[child] % MOD
                totalWays = totalWays * nCr(totalCnt, cnt[child]) % MOD
            }
            ways[u] = totalWays.toInt()
            cnt[u] = totalCnt + 1
        }
        return ways[0]
    }
}
