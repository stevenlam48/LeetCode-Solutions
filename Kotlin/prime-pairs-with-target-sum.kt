package primepairswithtargetsum

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findPrimePairs(n: Int): Array<IntArray> {
        val spf = linearSieveOfEratosthenes(n)
        val result = ArrayList<IntArray>()
        for (i in 2..n / 2) {
            if (spf[i] == i && spf[n - i] == n - i) {
                result.add(intArrayOf(i, n - i))
            }
        }
        return result.toTypedArray()
    }

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
}
