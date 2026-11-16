package minimummovestoequalarrayelements

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minMoves(nums: IntArray): Int {
        var sum = 0L
        for (x in nums) {
            sum += x
        }
        return (sum - nums.size.toLong() * nums.min()).toInt()
    }
}
