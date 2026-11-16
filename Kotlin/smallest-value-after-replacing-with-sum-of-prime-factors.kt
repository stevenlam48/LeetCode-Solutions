package smallestvalueafterreplacingwithsumofprimefactors

// Time:  O(s * logn), s is the times of simulation
// Space: O(max_n^0.5)

private fun linearSieveOfEratosthenes(n: Int): List<Int> {
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
    return primes
}

private val PRIMES: List<Int> = linearSieveOfEratosthenes(316)

class Solution {
    fun smallestValue(n: Int): Int {
        var value = n
        while (true) {
            var curr = value
            var newN = 0
            for (p in PRIMES) {
                if (p * p > curr) {
                    continue
                }
                while (curr % p == 0) {
                    curr /= p
                    newN += p
                }
            }
            if (curr > 1) {
                newN += curr
            }
            if (newN == value) {
                break
            }
            value = newN
        }
        return value
    }
}
