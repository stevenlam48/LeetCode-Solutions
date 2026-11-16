package greatestcommondivisortraversal

// Time:  precompute: O(sqrt(r)), r = max(nums)
//        runtime:    O(n * (logr + pi(sqrt(r))) = O(n * (logr + sqrt(r)/log(sqrt(r)))), pi(n) = number of primes in a range [1, n] = O(n/logn) by prime number theorem, see https://en.wikipedia.org/wiki/Prime_number_theorem
// Space: O(sqrt(r) + nlogr)

import kotlin.math.sqrt

private fun linearSieveOfEratosthenes(n: Long): List<Long> {
    val spf = LongArray((n + 1).toInt()) { -1 }
    val primes = mutableListOf<Long>()
    for (i in 2L..n) {
        if (spf[i.toInt()] == -1L) {
            spf[i.toInt()] = i
            primes.add(i)
        }
        for (p in primes) {
            if (i * p > n || p > spf[i.toInt()]) {
                break
            }
            spf[(i * p).toInt()] = p
        }
    }
    return primes
}

private const val MAX_VALUE = 100000
private val PRIMES = linearSieveOfEratosthenes(sqrt(MAX_VALUE.toDouble()).toLong())

class Solution {
    fun canTraverseAllPairs(nums: IntArray): Boolean {
        fun primeFactors(value: Int): HashMap<Int, Int> {
            var x = value
            val factors = HashMap<Int, Int>()
            for (prime in PRIMES) {
                val p = prime.toInt()
                if (p * p > x) {
                    break
                }
                while (x % p == 0) {
                    x /= p
                    factors[p] = (factors[p] ?: 0) + 1
                }
            }
            if (x != 1) {
                factors[x] = (factors[x] ?: 0) + 1
            }
            return factors
        }

        val adj = Array(nums.size) { mutableListOf<Int>() }
        fun bfs(): Boolean {
            val visited = BooleanArray(nums.size)
            visited[0] = true
            var queue = listOf(0)
            while (queue.isNotEmpty()) {
                val newQueue = mutableListOf<Int>()
                for (u in queue) {
                    for (v in adj[u]) {
                        if (visited[v]) {
                            continue
                        }
                        visited[v] = true
                        newQueue.add(v)
                    }
                }
                queue = newQueue
            }
            return visited.all { it }
        }

        val lookup = HashMap<Int, Int>()
        for (i in nums.indices) {
            for (p in primeFactors(nums[i]).keys) {
                if (p !in lookup) {
                    lookup[p] = i
                    continue
                }
                adj[i].add(lookup[p]!!)
                adj[lookup[p]!!].add(i)
            }
        }
        return bfs()
    }
}
