package containerwithmostwater
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.size - 1
        var maxArea = 0
        while (i < j) {
            maxArea = maxOf(maxArea, minOf(height[i], height[j]) * (j - i))
            if (height[i] > height[j]) {
                --j
            } else if (height[i] < height[j]) {
                ++i
            } else {
                ++i
                --j
            }
        }
        return maxArea
    }
}
