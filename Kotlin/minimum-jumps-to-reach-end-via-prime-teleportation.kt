package minimumjumpstoreachendviaprimeteleportation

// Time:  precompute: O(r)
//        runtime:    O(nlogr)
// Space: O(r + nlogr)

private const val MAX_NUM = 1_000_000

private fun linearSieveOfEratosthenes(n: Int): IntArray {
    val spf = IntArray(n + 1) { -1 }
    val primes = ArrayList<Int>()
    for (i in 2..n) {
        if (spf[i] == -1) {
            spf[i] = i
            primes.add(i)
        }
        for (p in primes) {
            if (i * p > n || p > spf[i]) {
                break
            }
            spf[i * p] = p
        }
    }
    return spf
}

private val SPF = linearSieveOfEratosthenes(MAX_NUM)

class Solution {
    fun minJumps(nums: IntArray): Int {
        val adj = HashMap<Int, MutableList<Int>>()
        for (i in nums.indices) {
            var x = nums[i]
            while (x != 1) {
                val p = SPF[x]
                while (x % p == 0) {
                    x /= p
                }
                adj.getOrPut(p) { mutableListOf() }.add(i)
            }
        }
        val dist = IntArray(nums.size) { -1 }
        dist[0] = 0
        var queue = mutableListOf(0)
        while (queue.isNotEmpty()) {
            val newQueue = mutableListOf<Int>()
            for (i in queue) {
                if (i == nums.size - 1) {
                    return dist.last()
                }
                for (di in intArrayOf(-1, 1)) {
                    val ni = i + di
                    if (ni in nums.indices && dist[ni] == -1) {
                        dist[ni] = dist[i] + 1
                        newQueue.add(ni)
                    }
                }
                val p = nums[i]
                if (SPF[p] != p || !adj.containsKey(p)) {
                    continue
                }
                for (ni in adj[p]!!) {
                    if (dist[ni] != -1) {
                        continue
                    }
                    dist[ni] = dist[i] + 1
                    newQueue.add(ni)
                }
                adj.remove(p)
            }
            queue = newQueue
        }
        return -1
    }
}
