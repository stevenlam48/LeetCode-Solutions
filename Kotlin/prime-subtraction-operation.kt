package primesubtractionoperation

// Time:  O(p + nlogp)
// Space: O(p)

private const val MAX_N = 1000

private val PRIMES: IntArray = linearSieveOfEratosthenes(MAX_N - 1)

private fun linearSieveOfEratosthenes(n: Int): IntArray {
    val spf = IntArray(n + 1) { -1 }
    val primes = IntArray(n / 2)
    var count = 0
    for (i in 2..n) {
        if (spf[i] == -1) {
            spf[i] = i
            primes[count++] = i
        }
        for (k in 0 until count) {
            val p = primes[k]
            if (i * p > n || p > spf[i]) {
                break
            }
            spf[i * p] = p
        }
    }
    return primes.copyOf(count)
}

class Solution {
    fun primeSubOperation(nums: IntArray): Boolean {
        for (i in nums.indices) {
            val target = if (i - 1 >= 0) nums[i] - nums[i - 1] else nums[i]
            val index = lowerBound(PRIMES, target)
            if (index != 0) {
                nums[i] -= PRIMES[index - 1]
            }
            if (i - 1 >= 0 && nums[i - 1] >= nums[i]) {
                return false
            }
        }
        return true
    }

    private fun lowerBound(values: IntArray, target: Int): Int {
        var left = 0
        var right = values.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (values[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
