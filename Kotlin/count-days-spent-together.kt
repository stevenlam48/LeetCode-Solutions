package countdaysspenttogether

// Time:  O(1)
// Space: O(1)

class Solution {
    fun countDaysTogether(arriveAlice: String, leaveAlice: String, arriveBob: String, leaveBob: String): Int {
        val nums = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        val prefix = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }

        fun day(date: String): Int =
            prefix[date.substring(0, 2).toInt() - 1] + date.substring(3).toInt()

        return maxOf(day(minOf(leaveAlice, leaveBob)) - day(maxOf(arriveAlice, arriveBob)) + 1, 0)
    }
}
