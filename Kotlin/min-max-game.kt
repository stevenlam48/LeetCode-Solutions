package minmaxgame

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minMaxGame(nums: IntArray): Int {
        var n = nums.size
        while (n != 1) {
            for (i in 0 until n / 2) {
                nums[i] = if (i % 2 == 0) minOf(nums[2 * i], nums[2 * i + 1]) else maxOf(nums[2 * i], nums[2 * i + 1])
            }
            n /= 2
        }
        return nums[0]
    }
}
