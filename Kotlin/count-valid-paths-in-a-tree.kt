package countvalidpathsinatree

// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    private class Frame(
        val step: Int,
        val u: Int,
        val p: Int,
        val i: Int,
        val newRet: LongArray?,
        val ret: LongArray
    )

    fun countPaths(n: Int, edges: Array<IntArray>): Long {
        fun linearSieveOfEratosthenes(n: Int): IntArray {
            val spf = IntArray(n + 1) { -1 }
            val primes = mutableListOf<Int>()
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

        val spf = linearSieveOfEratosthenes(n)
        fun isPrime(x: Int): Boolean = spf[x] == x

        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            val u = e[0] - 1
            val v = e[1] - 1
            adj[u].add(v)
            adj[v].add(u)
        }

        var result = 0L
        val ret = LongArray(2)
        val stack = ArrayDeque<Frame>()
        stack.addLast(Frame(1, 0, -1, -1, null, ret))
        while (stack.isNotEmpty()) {
            val frame = stack.removeLast()
            val current = frame.ret
            when (frame.step) {
                1 -> {
                    current[0] = if (isPrime(frame.u + 1)) 0L else 1L
                    current[1] = if (isPrime(frame.u + 1)) 1L else 0L
                    stack.addLast(Frame(2, frame.u, frame.p, 0, null, current))
                }
                2 -> {
                    if (frame.i == adj[frame.u].size) {
                        continue
                    }
                    val v = adj[frame.u][frame.i]
                    stack.addLast(Frame(2, frame.u, frame.p, frame.i + 1, null, current))
                    if (v == frame.p) {
                        continue
                    }
                    val newRet = LongArray(2)
                    stack.addLast(Frame(3, frame.u, frame.p, frame.i, newRet, current))
                    stack.addLast(Frame(1, v, frame.u, -1, null, newRet))
                }
                3 -> {
                    val newRet = frame.newRet!!
                    result += current[0] * newRet[1] + current[1] * newRet[0]
                    if (isPrime(frame.u + 1)) {
                        current[1] += newRet[0]
                    } else {
                        current[0] += newRet[0]
                        current[1] += newRet[1]
                    }
                }
            }
        }
        return result
    }
}
