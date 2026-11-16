package minimumlimitofballsinabag

// Time:  O(nlogn), m is the max of nums
// Space: O(1)

class Solution {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        val check = { x: Int ->
            var total = 0L
            for (a in nums) {
                total += (a + x - 1) / x - 1
            }
            total <= maxOperations
        }
        var left = 1
        var right = nums.max()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
