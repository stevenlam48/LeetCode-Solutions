package minimumadjacentswapstomakeavalidarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumSwaps(nums: IntArray): Int {
        var minIndex = 0
        var maxIndex = 0
        for (i in nums.indices) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i
            }
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i
            }
        }
        return (nums.size - 1 - maxIndex) + minIndex - if (maxIndex < minIndex) 1 else 0
    }
}
