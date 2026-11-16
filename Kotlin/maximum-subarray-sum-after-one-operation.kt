package maximumsubarraysumafteroneoperation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxSumAfterOperation(nums: IntArray): Int {
        var previousWithSquare = 0
        var previousWithoutSquare = 0
        var result = 0
        for (num in nums) {
            val withoutSquare = maxOf(num, num + previousWithoutSquare)
            val withSquare = maxOf(
                num * num,
                num * num + previousWithoutSquare,
                previousWithSquare + num
            )
            result = maxOf(result, withSquare)
            previousWithSquare = withSquare
            previousWithoutSquare = withoutSquare
        }
        return result
    }
}
