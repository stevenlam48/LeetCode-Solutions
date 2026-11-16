package countprimegapbalancedsubarrays

// Time:  precompute: O(r), r = max(nums)
//        runtime:    O(n)
// Space: O(r)

private const val MAX_NUMS = 50_000
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

class Solution {
    fun primeSubarray(nums: IntArray, k: Int): Int {
        val indices = ArrayDeque<Int>()
        val maxDeque = ArrayDeque<Int>()
        val minDeque = ArrayDeque<Int>()
        var result = 0
        var left = 0
        for (right in nums.indices) {
            if (SPF[nums[right]] == nums[right]) {
                indices.addLast(right)
                while (maxDeque.isNotEmpty() && nums[maxDeque.last()] <= nums[right]) {
                    maxDeque.removeLast()
                }
                maxDeque.addLast(right)
                while (minDeque.isNotEmpty() && nums[minDeque.last()] >= nums[right]) {
                    minDeque.removeLast()
                }
                minDeque.addLast(right)
                while (nums[maxDeque.first()] - nums[minDeque.first()] > k) {
                    if (maxDeque.first() == left) {
                        maxDeque.removeFirst()
                    }
                    if (minDeque.first() == left) {
                        minDeque.removeFirst()
                    }
                    if (indices.first() == left) {
                        indices.removeFirst()
                    }
                    ++left
                }
            }
            if (indices.size >= 2) {
                result += indices[indices.size - 2] - left + 1
            }
        }
        return result
    }
}
