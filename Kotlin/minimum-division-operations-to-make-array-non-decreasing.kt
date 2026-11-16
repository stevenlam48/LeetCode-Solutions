package minimumdivisionoperationstomakearraynondecreasing
// Time:  precompute: O(r)
//        runtime:    O(n)
// Space: O(r) 

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

private const val MAX_N = 1_000_000
private val SPF = linearSieveOfEratosthenes(MAX_N)

class Solution {
    fun minOperations(nums: IntArray): Int {
        var result = 0
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] <= nums[i + 1]) {
                continue
            }
            if (SPF[nums[i]] > nums[i + 1]) {
                return -1
            }
            nums[i] = SPF[nums[i]]
            ++result
        }
        return result
    }
}
