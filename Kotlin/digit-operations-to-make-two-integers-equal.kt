package digitoperationstomaketwointegersequal

import java.util.PriorityQueue

// Time:  O(nlogn)
// Space: O(n)

// number theory, dijkstra's algorithm
class Solution {
    fun minOperations(n: Int, m: Int): Int {
        fun linearSieveOfEratosthenes(limit: Int): IntArray {
            val spf = IntArray(limit + 1) { -1 }
            val primes = mutableListOf<Int>()
            for (i in 2..limit) {
                if (spf[i] == -1) {
                    spf[i] = i
                    primes.add(i)
                }
                for (p in primes) {
                    if (i * p > limit || p > spf[i]) {
                        break
                    }
                    spf[i * p] = p
                }
            }
            return spf
        }

        var base = 1
        while (base < maxOf(n, m)) {
            base *= 10
        }
        val spf = linearSieveOfEratosthenes(base)

        fun dijkstra(start: Int, target: Int): Int {
            if (spf[start] == start) {
                return -1
            }
            val lookup = HashSet<Int>()
            val minHeap = PriorityQueue<IntArray>(compareBy({ it[0] }, { it[1] }))
            minHeap.add(intArrayOf(start, start))
            while (minHeap.isNotEmpty()) {
                val top = minHeap.poll()
                val curr = top[0]
                val i = top[1]
                if (lookup.contains(i)) {
                    continue
                }
                lookup.add(i)
                if (i == target) {
                    return curr
                }
                var b = 1
                while (b <= i) {
                    val x = i / b
                    for (d in intArrayOf(-1, 1)) {
                        val digit = x % 10 + d
                        if ((if (x <= 9) 1 else 0) <= digit && digit <= 9 &&
                            spf[i + d * b] != i + d * b && !lookup.contains(i + d * b)
                        ) {
                            minHeap.add(intArrayOf(curr + (i + d * b), i + d * b))
                        }
                    }
                    b *= 10
                }
            }
            return -1
        }

        return dijkstra(n, m)
    }
}
