package sumofperfectsquareancestors

// Time:  precompute: O(r)
//        runtime:    O(nlogx)
// Space: O(r + n)

private const val MAX_NUMS = 100000

private val SPF = linearSieveOfEratosthenes(MAX_NUMS)

private fun linearSieveOfEratosthenes(n: Int): IntArray {
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

private data class Frame(val step: Int, val u: Int, val parent: Int, val index: Int, val x: Int)

class Solution {
    fun sumOfAncestors(n: Int, edges: Array<IntArray>, nums: IntArray): Long {
        val adj = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }
        val cnt = HashMap<Int, Int>()
        var result = 0L
        val stack = mutableListOf(Frame(1, 0, -1, -1, 0))
        while (stack.isNotEmpty()) {
            val frame = stack.removeAt(stack.lastIndex)
            if (frame.step == 1) {
                val x = primeFactors(nums[frame.u])
                val count = cnt[x] ?: 0
                result += count
                cnt[x] = count + 1
                stack.add(Frame(3, -1, -1, -1, x))
                stack.add(Frame(2, frame.u, frame.parent, 0, 0))
            } else if (frame.step == 2) {
                if (frame.index == adj[frame.u].size) {
                    continue
                }
                stack.add(Frame(2, frame.u, frame.parent, frame.index + 1, 0))
                val v = adj[frame.u][frame.index]
                if (v == frame.parent) {
                    continue
                }
                stack.add(Frame(1, v, frame.u, -1, 0))
            } else {
                cnt[frame.x] = cnt[frame.x]!! - 1
            }
        }
        return result
    }

    private fun primeFactors(x: Int): Int {
        var value = x
        var result = 1
        while (value != 1) {
            if (result % SPF[value] == 0) {
                result /= SPF[value]
            } else {
                result *= SPF[value]
            }
            value /= SPF[value]
        }
        return result
    }
}
