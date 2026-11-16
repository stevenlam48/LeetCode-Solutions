package thirdmaximumnumber
// Time:  O(n)
// Space: O(1)

class Solution {
    fun thirdMax(nums: IntArray): Int {
        var count = 0
        val top = LongArray(3) { Long.MIN_VALUE }
        for (number in nums) {
            val num = number.toLong()
            if (num > top[0]) {
                top[2] = top[1]
                top[1] = top[0]
                top[0] = num
                ++count
            } else if (num != top[0] && num > top[1]) {
                top[2] = top[1]
                top[1] = num
                ++count
            } else if (num != top[0] && num != top[1] && num >= top[2]) {
                top[2] = num
                ++count
            }
        }
        return if (count < 3) top[0].toInt() else top[2].toInt()
    }
}
