package typeoftriangleii

// Time:  O(1)
// Space: O(1)

class Solution {
    fun triangleType(nums: IntArray): String {
        nums.sort()
        val a = nums[0]
        val b = nums[1]
        val c = nums[2]
        if (a + b <= c) {
            return "none"
        }
        if (a == b && b == c) {
            return "equilateral"
        }
        if (a == b || b == c) {
            return "isosceles"
        }
        return "scalene"
    }
}
