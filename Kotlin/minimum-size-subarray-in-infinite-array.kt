package minimumsizesubarrayininfinitearray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minSizeSubarray(nums: IntArray, target: Int): Int {
        val inf = Int.MAX_VALUE
        val total = nums.sumOf { it.toLong() }
        val q = target / total
        var remainingTarget = (target % total).toInt()
        if (remainingTarget == 0) {
            return (q * nums.size).toInt()
        }
        var result = inf
        var curr = 0
        var left = 0
        for (right in 0 until (nums.size - 1) + (nums.size - 1)) {
            curr += nums[right % nums.size]
            while (curr > remainingTarget) {
                curr -= nums[left++ % nums.size]
            }
            if (curr == remainingTarget) {
                result = minOf(result, right - left + 1)
            }
        }
        return if (result != inf) (result + q * nums.size).toInt() else -1
    }
}
