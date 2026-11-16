package applyoperationstomaximizescore

// Time:  O(sqrt(r) + n * (logr + pi(sqrt(r))) + klogn) = O(sqrt(r) + n * (logr + sqrt(r)/log(sqrt(r))) + klogn), m is max(k for _, k in queries), pi(n) = number of primes in a range [1, n] = O(n/logn) by prime number theorem, see https://en.wikipedia.org/wiki/Prime_number_theorem
// Space: O(sqrt(r) + n)

import java.util.PriorityQueue
import kotlin.math.min
import kotlin.math.sqrt

class Solution {
    fun maximumScore(nums: IntArray, k: Int): Int {
        val primes = linearSieveOfEratosthenes(sqrt(nums.max().toDouble()).toInt())
        val lookup = HashMap<Int, Int>()

        fun countOfDistinctPrimeFactors(value: Int): Int {
            var x = value
            return lookup.getOrPut(value) {
                var cnt = 0
                for (p in primes) {
                    if (p * p > x) {
                        break
                    }
                    if (x % p != 0) {
                        continue
                    }
                    ++cnt
                    while (x % p == 0) {
                        x /= p
                    }
                }
                if (x != 1) {
                    ++cnt
                }
                cnt
            }
        }

        val scores = IntArray(nums.size) { countOfDistinctPrimeFactors(nums[it]) }
        val stk = ArrayDeque<Int>()
        stk.addLast(-1)
        val left = IntArray(scores.size) { -1 }
        for (i in scores.indices) {
            while (stk.last() != -1 && scores[stk.last()] < scores[i]) {
                stk.removeLast()
            }
            left[i] = stk.last()
            stk.addLast(i)
        }
        stk.clear()
        stk.addLast(scores.size)
        val right = IntArray(scores.size) { -1 }
        for (i in scores.size - 1 downTo 0) {
            while (stk.last() != scores.size && scores[stk.last()] <= scores[i]) {
                stk.removeLast()
            }
            right[i] = stk.last()
            stk.addLast(i)
        }

        var result = 1L
        var operationsLeft = k
        val maxHeap = PriorityQueue<Pair<Int, Int>>(
            compareByDescending<Pair<Int, Int>> { it.first }.thenByDescending { it.second }
        )
        for (i in nums.indices) {
            maxHeap.add(nums[i] to i)
        }
        while (maxHeap.isNotEmpty()) {
            val (_, i) = maxHeap.poll()
            val c = min((i - left[i]) * (right[i] - i), operationsLeft)
            result = result * powMod(nums[i].toLong(), c) % MOD
            operationsLeft -= c
            if (operationsLeft == 0) {
                break
            }
        }
        return result.toInt()
    }

    private fun powMod(base: Long, exponent: Int): Long {
        var a = base % MOD
        var b = exponent
        var result = 1L
        while (b != 0) {
            if (b and 1 != 0) {
                result = result * a % MOD
            }
            a = a * a % MOD
            b = b shr 1
        }
        return result
    }

    private fun linearSieveOfEratosthenes(n: Int): List<Int> {
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
        return primes
    }

    companion object {
        private const val MOD = 1_000_000_007L
    }
}
