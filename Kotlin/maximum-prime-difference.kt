package maximumprimedifference

// Time:  O(r + n), r = max(nums)
// Space: O(r)

private const val MAX_N = 100

private fun linearSieveOfEratosthenes(n: Int): IntArray {
    val spf = IntArray(n + 1) { -1 }
    val primes = ArrayList<Int>()
    for (i in 2..n) {
        if (spf[i] == -1) {
            spf[i] = i
            primes.add(i)
        }
        for (p in primes) {
            if (i.toLong() * p > n || p > spf[i]) {
                break
            }
            spf[i * p] = p
        }
    }
    return spf
}

private val SPF = linearSieveOfEratosthenes(MAX_N)

class Solution {
    fun maximumPrimeDifference(nums: IntArray): Int {
        var left = -1
        var right = -1
        for (i in nums.indices) {
            if (SPF[nums[i]] != nums[i]) {
                continue
            }
            if (left == -1) {
                left = i
            }
            right = i
        }
        return right - left
    }
}
