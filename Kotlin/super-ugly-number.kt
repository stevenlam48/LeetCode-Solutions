package superuglynumber

import java.util.PriorityQueue

// Time:  O(n * k)
// Space: O(n + k)

// Heap solution. (308ms)
class Solution {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val heap = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))
        val uglies = IntArray(n)
        val idx = IntArray(primes.size)
        val uglyByLastPrime = IntArray(n)
        uglies[0] = 1

        for (i in primes.indices) {
            heap.add(Pair(primes[i], i))
        }
        for (i in 1 until n) {
            val top = heap.poll()
            uglies[i] = top.first
            val k = top.second
            uglyByLastPrime[i] = k
            while (true) {
                ++idx[k]
                if (uglyByLastPrime[idx[k]] <= k) {
                    break
                }
            }
            heap.add(Pair(uglies[idx[k]] * primes[k], k))
        }
        return uglies[n - 1]
    }
}
