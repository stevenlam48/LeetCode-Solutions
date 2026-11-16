package trappingrainwater
// Time:  O(n)
// Space: O(1)

class Solution {
    fun trap(height: IntArray): Int {
        var result = 0
        var left = 0
        var right = height.size - 1
        var level = 0
        while (left < right) {
            val lower = if (height[left] < height[right]) height[left++] else height[right--]
            level = maxOf(level, lower)
            result += level - lower
        }
        return result
    }
}
