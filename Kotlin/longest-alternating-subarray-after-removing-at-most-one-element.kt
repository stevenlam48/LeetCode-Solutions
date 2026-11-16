package longestalternatingsubarrayafterremovingatmostoneelement

// Time:  O(n)
// Space: O(1)

// dp
class Solution {
    fun longestAlternating(nums: IntArray): Int {
        var result = 1
        var up1 = 1
        var up0 = 1
        var down1 = 1
        var down0 = 1
        for (i in 0 until nums.size - 1) {
            if (nums[i] < nums[i + 1]) {
                val nUp1 = down1 + 1
                val nUp0 = down0 + 1
                val nDown1 = down0
                val nDown0 = 1
                up1 = nUp1
                up0 = nUp0
                down1 = nDown1
                down0 = nDown0
            } else if (nums[i] > nums[i + 1]) {
                val nUp1 = up0
                val nUp0 = 1
                val nDown1 = up1 + 1
                val nDown0 = up0 + 1
                up1 = nUp1
                up0 = nUp0
                down1 = nDown1
                down0 = nDown0
            } else {
                val nUp1 = up0
                val nUp0 = 1
                val nDown1 = down0
                val nDown0 = 1
                up1 = nUp1
                up0 = nUp0
                down1 = nDown1
                down0 = nDown0
            }
            result = maxOf(result, up1, down1)
        }
        return result
    }
}
