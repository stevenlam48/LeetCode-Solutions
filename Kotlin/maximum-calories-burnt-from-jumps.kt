package maximumcaloriesburntfromjumps

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxCaloriesBurnt(heights: IntArray): Long {
        heights.sort()
        var left = 0
        var right = heights.size - 1
        var result = (0L - heights[right]) * (0L - heights[right])
        while (left != right) {
            result += (heights[right].toLong() - heights[left]) * (heights[right].toLong() - heights[left])
            --right
            if (left == right) {
                break
            }
            result += (heights[left].toLong() - heights[right]) * (heights[left].toLong() - heights[right])
            ++left
        }
        return result
    }
}
