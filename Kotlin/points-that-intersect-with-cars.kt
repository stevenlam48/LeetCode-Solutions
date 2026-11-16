package pointsthatintersectwithcars
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun numberOfPoints(nums: Array<IntArray>): Int {
        nums.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        var result = 0
        var curr = nums[0].copyOf()
        for (i in 1 until nums.size) {
            if (nums[i][0] <= curr[1]) {
                curr[1] = maxOf(curr[1], nums[i][1])
            } else {
                result += curr[1] - curr[0] + 1
                curr = nums[i].copyOf()
            }
        }
        result += curr[1] - curr[0] + 1
        return result
    }
}
