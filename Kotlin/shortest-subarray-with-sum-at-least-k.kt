package shortestsubarraywithsumatleastk

// Time:  O(n)
// Space: O(n)

class Solution {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        val accumulatedSum = IntArray(nums.size + 1)
        for (i in nums.indices) {
            accumulatedSum[i + 1] = accumulatedSum[i] + nums[i]
        }

        var result = Int.MAX_VALUE
        val monoIncreasingQ = ArrayDeque<Int>()
        for (i in accumulatedSum.indices) {
            while (monoIncreasingQ.isNotEmpty() &&
                accumulatedSum[i] <= accumulatedSum[monoIncreasingQ.last()]
            ) {
                monoIncreasingQ.removeLast()
            }
            while (monoIncreasingQ.isNotEmpty() &&
                accumulatedSum[i] - accumulatedSum[monoIncreasingQ.first()] >= k
            ) {
                result = minOf(result, i - monoIncreasingQ.first())
                monoIncreasingQ.removeFirst()
            }
            monoIncreasingQ.addLast(i)
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
