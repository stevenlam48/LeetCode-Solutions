package minimummovestoequalarrayelementsiii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minMoves(nums: IntArray): Int {
        var sum = 0L
        for (x in nums) {
            sum += x
        }
        return (nums.max().toLong() * nums.size - sum).toInt()
    }
}
