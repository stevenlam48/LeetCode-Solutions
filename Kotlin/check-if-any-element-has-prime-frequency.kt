package checkifanyelementhasprimefrequency

// Time:  precompute: O(MAX_N)
//        runtime: O(n)
// Space: O(MAX_N)

private const val MAX_N = 100

private val SPF: IntArray = run {
    val spf = IntArray(MAX_N + 1) { -1 }
    val primes = mutableListOf<Int>()
    for (i in 2..MAX_N) {
        if (spf[i] == -1) {
            spf[i] = i
            primes.add(i)
        }
        for (p in primes) {
            if (i * p > MAX_N || p > spf[i]) {
                break
            }
            spf[i * p] = p
        }
    }
    spf
}

class Solution {
    fun checkPrimeFrequency(nums: IntArray): Boolean {
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        return cnt.values.any { it in 2..MAX_N && SPF[it] == it }
    }
}
