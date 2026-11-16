package sumofprimesbetweennumberanditsreverse

// Time:  precompute: O(r)
//        runtime:    O(1)
// Space: O(r)

private const val MAX_N = 1000

private val PREFIX = precompute(MAX_N)

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

private fun precompute(n: Int): IntArray {
    val spf = linearSieveOfEratosthenes(n)
    val prefix = IntArray(spf.size + 1)
    for (i in 0 until prefix.size - 1) {
        prefix[i + 1] = prefix[i] + if (spf[i] == i) i else 0
    }
    return prefix
}

class Solution {
    fun sumOfPrimesInRange(n: Int): Int {
        val reversed = reverse(n)
        val left = minOf(n, reversed)
        val right = maxOf(n, reversed)
        return PREFIX[right + 1] - PREFIX[left]
    }

    private fun reverse(n: Int): Int {
        var value = n
        var result = 0
        while (value != 0) {
            result = result * 10 + value % 10
            value /= 10
        }
        return result
    }
}
