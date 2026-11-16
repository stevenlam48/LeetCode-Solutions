package maximumalternatingsumofsquares

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxAlternatingSum(nums: IntArray): Long {
        val arr = IntArray(nums.size)
        for (i in arr.indices) {
            arr[i] = nums[i] * nums[i]
        }
        arr.sort()
        var result = 0L
        for (x in arr) {
            result += x
        }
        for (i in 0 until arr.size / 2) {
            result -= 2L * arr[i]
        }
        return result
    }
}
