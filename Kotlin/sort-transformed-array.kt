package sorttransformedarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sortTransformedArray(nums: IntArray, a: Int, b: Int, c: Int): IntArray {
        fun f(x: Int): Int {
            return a * x * x + b * x + c
        }

        val result = ArrayList<Int>()
        if (nums.isEmpty()) {
            return result.toIntArray()
        }
        var left = 0
        var right = nums.size - 1
        val d = if (a > 0) -1 else 1
        while (left <= right) {
            if (d * f(nums[left]) < d * f(nums[right])) {
                result.add(f(nums[left]))
                ++left
            } else {
                result.add(f(nums[right]))
                --right
            }
        }
        if (d == -1) {
            result.reverse()
        }
        return result.toIntArray()
    }
}
