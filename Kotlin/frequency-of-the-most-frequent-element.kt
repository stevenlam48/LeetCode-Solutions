package frequencyofthemostfrequentelement

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        nums.sort()
        var left = 0
        var total = k.toLong()
        for (right in nums.indices) {
            total += nums[right]
            if (total < nums[right].toLong() * (right - left + 1)) {
                total -= nums[left]
                left++
            }
        }
        return (nums.size - 1) - left + 1
    }
}
